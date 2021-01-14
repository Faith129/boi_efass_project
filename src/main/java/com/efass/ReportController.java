package com.efass;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr221.sheet221_Service;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr311.sheet311_Service;
import com.efass.sheet.mmfbr321.sheet321DAO;
import com.efass.sheet.mmfbr321.sheet321_Service;
import com.efass.sheet.mmfbr641.sheet641DAO;
import com.efass.sheet.mmfbr641.sheet641_Service;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr711.sheet711_Service;
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr746.sheet746_Service;
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.sheet.mmfbr761.sheet761_Service;
import com.efass.specials.SpecialFunction;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class ReportController {

	@Autowired
	private sheet221_Service sheet221Svc;
	
	@Autowired
	private sheet311_Service sheet311Svc;
	
	
	@Autowired
	private sheet641_Service sheet641Svc;
	
	@Autowired
	private sheet321_Service sheet321Svc;
	

	
	@Autowired
	private sheet711_Service sheet711Svc;
	
	
	@Autowired
	private sheet746_Service sheet746Svc;
	
	@Autowired
	private sheet761_Service sheet761Svc;

	// CHOOSE REPORT DATE
	// You can consume the path .../report/date/2019-04-25
	@RequestMapping("/report/date/{from}")
	public ResponseEntity<?> userAddedSince2(
			@PathVariable("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since) {
		// String selectedDate =since.toString();
		long selectedTime = since.getTime();

		int selectedDate = since.getDate();

		// Create a folder inside exports
		SpecialFunction special = new SpecialFunction();
		Response res = new Response();
		String filename = special.createFolderDirectory(selectedTime, selectedDate);
		if (!filename.equals(null)) {
			// Run Procedure to populate the tables on DB
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			res.setFilePath(filename);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} else {
			res.setResponseMessage("Failed To Prepare For Generation");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// Call Procedure to populate tables

	}

	// ########################## MMFBR221 ##########################################

	@GetMapping("/mmfbr221")
	public ResponseEntity<?> getAllData221() {
		return sheet221Svc.fetchAllData();
	}

	@GetMapping("/mmfbr221/{id}")
	public ResponseEntity<?> getDataById221(@PathVariable int id) throws ResourceNotFoundException {
		return sheet221Svc.getDataById(id);
	}

	@PostMapping("/mmfbr221")
	public ResponseEntity<?> createData221(@RequestBody sheet221DAO data) throws ResourceNotFoundException {
		return sheet221Svc.createData(data);
	}

	@PutMapping("/mmfbr221/{id}")
	public ResponseEntity<?> updateData221(@PathVariable int id, @RequestBody sheet221DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet221Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr221/{id}")
	public ResponseEntity<?> deleteData221(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet221Svc.deleteById(id);
	}

	// #################################################################################
	
	
	
	
	
	
	
	// ########################## MMFBR311 ##########################################
	

	@GetMapping("/mmfbr311")
	public ResponseEntity<?> getAllData311() {
		return sheet311Svc.fetchAllData();
	}

	@GetMapping("/mmfbr311/{id}")
	public ResponseEntity<?> getDataById311(@PathVariable int id) throws ResourceNotFoundException {
		return sheet311Svc.getDataById(id);
	}

	@PostMapping("/mmfbr311")
	public ResponseEntity<?> createData311(@RequestBody sheet311DAO data) throws ResourceNotFoundException {
		return sheet311Svc.createData(data);
	}

	@PutMapping("/mmfbr311/{id}")
	public ResponseEntity<?> updateData311(@PathVariable int id, @RequestBody sheet311DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet311Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr311/{id}")
	public ResponseEntity<?> deleteData311(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet311Svc.deleteById(id);
	}
	
	
	
	//###########################################################################
	
	
	
	
	//########################## MMFBR 321 ################################
	
	@GetMapping("/mmfbr321")
	public ResponseEntity<?> getAllData321() {
		return sheet321Svc.fetchAllData();
	}

	@GetMapping("/mmfbr321/{id}")
	public ResponseEntity<?> getDataById321(@PathVariable int id) throws ResourceNotFoundException {
		return sheet321Svc.getDataById(id);
	}

	@PostMapping("/mmfbr321")
	public ResponseEntity<?> createData321(@RequestBody sheet321DAO data) throws ResourceNotFoundException {
		return sheet321Svc.createData(data);
	}

	@PutMapping("/mmfbr321/{id}")
	public ResponseEntity<?> updateData321(@PathVariable int id, @RequestBody sheet321DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet321Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr321/{id}")
	public ResponseEntity<?> deleteData321(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet321Svc.deleteById(id);
	}
	
	
	//##################################################################
	
	
	
	
	
	//################################ MMFBR 641 #########################################
	
	
	@GetMapping("/mmfbr641")
	public ResponseEntity<?> getAllData641() {
		return sheet641Svc.fetchAllData();
	}

	@GetMapping("/mmfbr641/{id}")
	public ResponseEntity<?> getDataById641(@PathVariable int id) throws ResourceNotFoundException {
		return sheet641Svc.getDataById(id);
	}

	@PostMapping("/mmfbr641")
	public ResponseEntity<?> createData641(@RequestBody sheet641DAO data) throws ResourceNotFoundException {
		return sheet641Svc.createData(data);
	}

	@PutMapping("/mmfbr641/{id}")
	public ResponseEntity<?> updateData641(@PathVariable int id, @RequestBody sheet641DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet641Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr641/{id}")
	public ResponseEntity<?> deleteData641(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet641Svc.deleteById(id);
	}
	
	
	
	
	//#####################################  MMFBR 711  ##############
	

	@GetMapping("/mmfbr711")
	public ResponseEntity<?> getAllData711() {
		return sheet711Svc.fetchAllData();
	}

	@GetMapping("/mmfbr711/{id}")
	public ResponseEntity<?> getDataById711(@PathVariable int id) throws ResourceNotFoundException {
		return sheet711Svc.getDataById(id);
	}

	@PostMapping("/mmfbr711")
	public ResponseEntity<?> createData711(@RequestBody sheet711DAO data) throws ResourceNotFoundException {
		return sheet711Svc.createData(data);
	}

	@PutMapping("/mmfbr711/{id}")
	public ResponseEntity<?> updateData711(@PathVariable int id, @RequestBody sheet711DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet711Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr711/{id}")
	public ResponseEntity<?> deleteData711(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet711Svc.deleteById(id);
	}
	
	
	
	
	//########################## MMFBR746 ##########################
	
	@GetMapping("/mmfbr746")
	public ResponseEntity<?> getAllData746() {
		return sheet746Svc.fetchAllData();
	}

	@GetMapping("/mmfbr746/{id}")
	public ResponseEntity<?> getDataById746(@PathVariable int id) throws ResourceNotFoundException {
		return sheet746Svc.getDataById(id);
	}

	@PostMapping("/mmfbr746")
	public ResponseEntity<?> createData746(@RequestBody sheet746DAO data) throws ResourceNotFoundException {
		return sheet746Svc.createData(data);
	}

	@PutMapping("/mmfbr746/{id}")
	public ResponseEntity<?> updateData746(@PathVariable int id, @RequestBody sheet746DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet746Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr746/{id}")
	public ResponseEntity<?> deleteData746(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet746Svc.deleteById(id);
	}
	
	
	
	
	//#############################################################
	
	
	
	
	
	//########################## MMFBR761 ##########################
	@GetMapping("/mmfbr761")
	public ResponseEntity<?> getAllData761() {
		return sheet761Svc.fetchAllData();
	}

	@GetMapping("/mmfbr761/{id}")
	public ResponseEntity<?> getDataById761(@PathVariable int id) throws ResourceNotFoundException {
		return sheet761Svc.getDataById(id);
	}

	@PostMapping("/mmfbr761")
	public ResponseEntity<?> createData761(@RequestBody sheet761DAO data) throws ResourceNotFoundException {
		return sheet761Svc.createData(data);
	}

	@PutMapping("/mmfbr761/{id}")
	public ResponseEntity<?> updateData761(@PathVariable int id, @RequestBody sheet761DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet761Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr761/{id}")
	public ResponseEntity<?> deleteData761(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet761Svc.deleteById(id);
	}
	
	//####################################################################

}
