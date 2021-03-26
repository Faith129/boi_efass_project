
package com.efass;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efass.auth.jwt.user.PassData;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.procedures.ProcedureService;
import com.efass.report.ReportDAO;
import com.efass.report.ReportService;
import com.efass.sheet.mmfbr202.sheet202DAO;
import com.efass.specials.DateConverter;
import com.efass.user.UserDAO;
import com.efass.user.UserRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserRepository userRepository;

	Response res = new Response();
	
	@Autowired
	private ReportService reportSvc;

	@Autowired
	ProcedureService prodSvc;
	
	@Autowired
	DateConverter dateSvc;

	
	@RequestMapping(value ="/testproc/{date}")
	public ResponseEntity<?> testing(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ParseException {
		String _date=null;
		 _date = dateSvc.changeDateToGregorian2(date.toString(), "yyyy-MM-dd");
		prodSvc.callPrepareTableProcedure(_date, "PROC_MMFBR_311");
		
		
		_date = dateSvc.changeDateTime(date.toString());
	//	prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_141");
	
		_date = dateSvc.changeDateTime(date.toString());
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_221");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_311");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_312");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_321");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_641");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_711");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_746");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_761");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_771");
		prodSvc.callPrepareTableProcedure(date.toString(), "PROC_MMFBR_M001");
	//	prodSvc.callPrepareTableProcedure(date.toString(), "PROD_MMFBR_202");


		
		 return null;

	
	}
	
	
	
	
	
	
	
	//FETCH ALL USERS
	@RequestMapping("/users")
	public ResponseEntity<?> fetchAllUsers() {
		Iterable<UserDAO> data = userRepository.findAll();
		res.setAllUsers(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/files")
	public ResponseEntity<?> fetchAllGeneratedFiles() throws FileNotFoundException {
	return reportSvc.fetchallActivity();
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
//			res.setResponseCode(-1001);	
//			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		try {
			
			
			String userdata = userRepository.findByUsername(user.getUsername());
			
			if(!userdata.equals(null)) {
				
				res.setResponseMessage("User Already Exists");
				res.setResponseCode(-1001);	
				return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			
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
	
	
	
	
	
	
	//User Update Password
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<?>  updatePassword(@Valid @RequestBody PassData user)throws ResourceNotFoundException{

				if (!user.getPassword().equals(user.getConfirm_password())) {
					System.out.println(user.getPassword());
			res.setResponseMessage("Confirmation Password doesn't match");
			res.setResponseCode(-1001);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		UserDAO userdata = userRepository.findUserdetails(user.getUsername());
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(user.getOld_password(), userdata.getPassword())) {
			
			
			Optional<UserDAO> DataDb = userRepository.findUserdetails2(user.getUsername());

			if (DataDb.isPresent()) {
				
				
				BCryptPasswordEncoder encodedPass = new BCryptPasswordEncoder();
				String encryptedPassword = encodedPass.encode(user.getPassword());
				
				
				
				UserDAO DataUpdate = DataDb.get();
				DataUpdate.setPassword(encryptedPassword);
				userRepository.save(DataUpdate);
				Response res = new Response();
				res.setResponseMessage("Password Changed");
			
				return new ResponseEntity<>(res, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Could not change Password " );
			}
			
			
			
			
		
		}else {
			
			res.setResponseMessage("Old Password doesn't match");
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