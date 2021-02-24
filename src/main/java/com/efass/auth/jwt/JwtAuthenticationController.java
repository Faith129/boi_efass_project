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
	sheet311Repository _311Repository;
	@Autowired
	sheet221Repository _221Repository;
	@Autowired
	sheet711Repository _711Repository;
	@Autowired
	sheet746Repository _746Repository;
	@Autowired
	sheet761Repository _761Repository;
	@Autowired
	sheet771Repository _771Repository;
	@Autowired
	sheet762Repository _762Repository;
	@Autowired
	sheet763Repository _763Repository;
	@Autowired
	sheet764Repository _764Repository;
	@Autowired
	sheet811Repository _811Repository;
	@Autowired
	sheet141Repository _141Repository;
	@Autowired
	sheet201Repository _201Repository;
	@Autowired
	sheet202Repository _202Repository;
	@Autowired
	sheet312Repository _312Repository;
	@Autowired
	sheet322Repository _322Repository;
	@Autowired
	sheet451Repository _451Repository;
	@Autowired
	sheet501Repository _501Repository;
	@Autowired
	sheet642Repository _642Repository;
	@Autowired
	sheet651Repository _651Repository;
	@Autowired
	sheet933Repository _933Repository;
	@Autowired
	sheet951Repository _951Repository;
	@Autowired
	sheet996Repository _996Repository;
	@Autowired
	sheet980Repository _980Repository;
	
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		//Clear Tables

		clearSheetTables();
		
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
	
	
	
	
	
	
	private void clearSheetTables() {
		
		try {
//		_311Repository.deleteAll();	
//		_221Repository.deleteAll();
		_711Repository.deleteAll();
//		_746Repository.deleteAll();
//		_761Repository.deleteAll();
//		_771Repository.deleteAll();
//		_762Repository.deleteAll();
//		_763Repository.deleteAll();
//		_764Repository.deleteAll();
//		_811Repository.deleteAll();
//		_141Repository.deleteAll();
//		_201Repository.deleteAll();
//		_202Repository.deleteAll();
//		_312Repository.deleteAll();
//		_322Repository.deleteAll();
//		_451Repository.deleteAll();
//		_501Repository.deleteAll();
//		_642Repository.deleteAll();
//		_651Repository.deleteAll();
//		_933Repository.deleteAll();
//		_951Repository.deleteAll();
//		_996Repository.deleteAll();
//		_980Repository.deleteAll();
		
		
		populateSheet711();
		populateSheet762();
		populateSheet763();
		}catch(Exception ex) {
			
		}
	}
	
	
	
	private void populateSheet711() {
		//Delete all 
		_711Repository.deleteAll();
		
		sheet711DAO data = new sheet711DAO();
		data.setLendingModel("Individuals");
		_711Repository.save(data);
		
		sheet711DAO data2 = new sheet711DAO();
		data2.setLendingModel("Solidarity Group");
		_711Repository.save(data2);
		
		
		sheet711DAO data3 = new sheet711DAO();
		data3.setLendingModel("Neighborhood and Small Group Revolving Funds");
		_711Repository.save(data3);
		
		
		sheet711DAO data4 = new sheet711DAO();
		data4.setLendingModel("Village Banking");
		_711Repository.save(data4);
		
		sheet711DAO data5 = new sheet711DAO();
		data5.setLendingModel("Wholesale lending");
		_711Repository.save(data5);
		
		sheet711DAO data6 = new sheet711DAO();
		data6.setLendingModel("Credit Unions");
		_711Repository.save(data6);
		
		sheet711DAO data7 = new sheet711DAO();
		data7.setLendingModel("Staff");
		_711Repository.save(data7);
		
		
		sheet711DAO data8 = new sheet711DAO();	
		data8.setLendingModel("Others - Specify");
		_711Repository.save(data8);
	
	}
	
	public void populateSheet762() {
		//delete all
		_762Repository.deleteAll();	
		
		sheet762DAO data = new sheet762DAO();
		data.setSector("Agriculture & Forestry");
		_762Repository.save(data);
		
		
		sheet762DAO data1 = new sheet762DAO();
		data1.setSector("Mining & Quarry");
		_762Repository.save(data1);
		
		
		sheet762DAO data2 = new sheet762DAO();
		data2.setSector("Manufacturing & Food Processing");
		_762Repository.save(data2);
		
			
		sheet762DAO data3 = new sheet762DAO();
		data3.setSector("Trade & Commerce");
		data3.setNoOfLoans("40");
		data3.setAmountGranted("8270");
		_762Repository.save(data3);

		sheet762DAO data4 = new sheet762DAO();
		data4.setSector("Transport & Communication");
		_762Repository.save(data4);
		
		sheet762DAO data5 = new sheet762DAO();
		data5.setSector("Real Estate & Construction");
		_762Repository.save(data5);
		
		sheet762DAO data6 = new sheet762DAO();
		data6.setSector("Consumer/Personal");
		data6.setNoOfLoans("18");
		data6.setAmountGranted("5010");
		_762Repository.save(data6);
		
		
		
		sheet762DAO data7 = new sheet762DAO();
		data7.setSector("Health");
		_762Repository.save(data7);
		
		
		
		sheet762DAO data8 = new sheet762DAO();
		data8.setSector("Education");
		_762Repository.save(data8);
		
		
		sheet762DAO data9 = new sheet762DAO();
		data9.setSector("Tourism & Hospitality");
		_762Repository.save(data9);
		
		
		sheet762DAO data10 = new sheet762DAO();
		data10.setSector("Purchase of Shares");
		_762Repository.save(data10);
		
		
		
		sheet762DAO data11 = new sheet762DAO();
		data11.setSector("Others (Specify)");
		_762Repository.save(data11);
		
	}
	
	
	
	
	public void populateSheet763() {
		//delete all
		_763Repository.deleteAll();		
	
		sheet763DAO data = new sheet763DAO();
		data.setLoanId("1");
		data.setTypeOfLoans("MICRO-LOANS");
		_763Repository.save(data);
		
		
		sheet763DAO data1 = new sheet763DAO();
		data1.setTypeOfLoans("Number of accounts");
		data1.setTypeId("1");
		_763Repository.save(data1);
		
		
		
		sheet763DAO data2 = new sheet763DAO();
		data2.setTypeOfLoans("Amount (₦)");
		data2.setTypeId("1");
		_763Repository.save(data2);
		
		
		sheet763DAO data3 = new sheet763DAO();
		data.setLoanId("2");
		data3.setTypeOfLoans("SMALL & MEDIUM ENTERPRISES LOANS");
		_763Repository.save(data3);
		
		
		
		sheet763DAO data4 = new sheet763DAO();
		data4.setTypeOfLoans("Number of accounts");
		data4.setTypeId("2");
		_763Repository.save(data4);
		
		
		sheet763DAO data5 = new sheet763DAO();
		data5.setTypeOfLoans("Amount (₦)");
		data5.setTypeId("2");
		_763Repository.save(data4);
		
		
		
		sheet763DAO data6 = new sheet763DAO();
		data.setLoanId("3");
		data6.setTypeOfLoans("HIRE PURCHASE");
		_763Repository.save(data5);
		
		
		
		sheet763DAO data7 = new sheet763DAO();
		data7.setTypeOfLoans("Number of accounts");
		data7.setTypeId("3");
		_763Repository.save(data7);
		
		
		sheet763DAO data8 = new sheet763DAO();
		data8.setTypeOfLoans("Amount (₦)");
		data8.setTypeId("3");
		_763Repository.save(data8);
		
		
		
		sheet763DAO data9 = new sheet763DAO();
		data.setLoanId("4");
		data9.setTypeOfLoans("HIRE PURCHASE");
		_763Repository.save(data9);
		
		sheet763DAO data10 = new sheet763DAO();
		data10.setTypeOfLoans("Number of accounts");
		data10.setTypeId("4");
		_763Repository.save(data10);
		
		
		sheet763DAO data11 = new sheet763DAO();
		data11.setTypeOfLoans("Amount (₦)");
		data11.setTypeId("4");
		_763Repository.save(data11);
		
		
		
		
		
		sheet763DAO data12 = new sheet763DAO();
		data.setLoanId("5");
		data12.setTypeOfLoans("MICRO-LEASES");
		_763Repository.save(data12);
		
		
		sheet763DAO data13 = new sheet763DAO();
		data13.setTypeOfLoans("Amount (₦)");
		data13.setTypeId("5");
		_763Repository.save(data13);
		
		sheet763DAO data14 = new sheet763DAO();
		data14.setTypeOfLoans("Number of accounts");
		data14.setTypeId("5");
		_763Repository.save(data14);
		
		
		
		
		
		sheet763DAO data15 = new sheet763DAO();
		data.setLoanId("6");
		data15.setTypeOfLoans("OTHER LOANS (SPECIFY)");
		_763Repository.save(data15);
		
		
		
		sheet763DAO data16 = new sheet763DAO();
		data16.setTypeOfLoans("Amount (₦)");
		data16.setTypeId("6");
		_763Repository.save(data16);
		
		sheet763DAO data17 = new sheet763DAO();
		data17.setTypeOfLoans("Number of accounts");
		data17.setTypeId("6");
		_763Repository.save(data17);
		
		
		
		sheet763DAO data18 = new sheet763DAO();
		data18.setTypeOfLoans("STAFF LOANS");
		_763Repository.save(data18);
		
		
		sheet763DAO data19 = new sheet763DAO();
		data19.setTypeOfLoans("Amount (₦)");
		data19.setTypeId("7");
		_763Repository.save(data19);
		
		sheet763DAO data20 = new sheet763DAO();
		data20.setTypeOfLoans("Number of accounts");
		data20.setTypeId("7");
		_763Repository.save(data20);
		
	
		
	}
}
