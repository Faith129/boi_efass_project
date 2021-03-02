package com.efass.auth.jwt;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efass.PrepareTables;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr141.sheet141Repository;
import com.efass.sheet.mmfbr201.sheet201Repository;
import com.efass.sheet.mmfbr202.sheet202Repository;
import com.efass.sheet.mmfbr221.sheet221Repository;
import com.efass.sheet.mmfbr311.sheet311Repository;
import com.efass.sheet.mmfbr312.sheet312Repository;
import com.efass.sheet.mmfbr322.sheet322Repository;
import com.efass.sheet.mmfbr451.sheet451Repository;
import com.efass.sheet.mmfbr501.sheet501Repository;
import com.efass.sheet.mmfbr642.sheet642Repository;
import com.efass.sheet.mmfbr651.sheet651Repository;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr711.sheet711Repository;
import com.efass.sheet.mmfbr746.sheet746Repository;
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.sheet.mmfbr761.sheet761Repository;
import com.efass.sheet.mmfbr762.sheet762DAO;
import com.efass.sheet.mmfbr762.sheet762Repository;
import com.efass.sheet.mmfbr763.sheet763DAO;
import com.efass.sheet.mmfbr763.sheet763Repository;
import com.efass.sheet.mmfbr764.sheet764Repository;
import com.efass.sheet.mmfbr771.sheet771Repository;
import com.efass.sheet.mmfbr811.sheet811Repository;
import com.efass.sheet.mmfbr933.sheet933Repository;
import com.efass.sheet.mmfbr951.sheet951Repository;
import com.efass.sheet.mmfbr980.sheet980Repository;
import com.efass.sheet.mmfbr996.sheet996Repository;
import com.efass.user.UserDAO;



@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	
	@Autowired
	private PrepareTables prepareSheets;

	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		//Prepare Tables
		prepareSheets.clearSheetTables();
		
		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		UserDAO user = new UserDAO();
		user.setUsername(authenticationRequest.getUsername());
		Response res = new Response();
		res.setUser(user);
		res.setResponseMessage("Login Successful");
		res.setToken(token);
		return ResponseEntity.ok(res);
	}

	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
	
	
	
}
