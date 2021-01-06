package com.efass;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.user.UserDAO;
import com.efass.user.UserRepository;



@CrossOrigin()
@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserRepository userRepository;

	Response res = new Response();

	
	//FETCH ALL USERS
	@RequestMapping("/users")
	public ResponseEntity<?> fetchAllUsers() {
		Iterable<UserDAO> data = userRepository.findAll();
		res.setAllUsers(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
	//CREATE A USER
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDAO user) throws ResourceNotFoundException {

		String password = user.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);

//		String userdata = userRepository.findByUsername(user.getUsername());
//	
//		
//		if(!userdata.equals(null)) {
//			
//			res.setResponseMessage("User Already Exists");
//			res.setResponseCode(00);	
//			return new ResponseEntity<>(res, HttpStatus.NOT_IMPLEMENTED);
//		}
		try {
			UserDAO _user = userRepository.save(user);

			res.setUser(_user);
			res.setResponseMessage("User Created");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.CREATED);

		} catch (Exception e) {
			res.setResponseMessage("Failed");
			res.setResponseCode(-1001);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	


	
	
	
	
	//FETCH USER BY ID
	@RequestMapping(value = "/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
		UserDAO user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		user.setPassword(null);
		res.setUser(user);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}