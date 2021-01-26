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
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr141.sheet141_Service;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr201.sheet201_Service;
import com.efass.sheet.mmfbr202.sheet202DAO;
import com.efass.sheet.mmfbr202.sheet202_Service;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr221.sheet221_Service;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr311.sheet311_Service;
import com.efass.sheet.mmfbr312.sheet312DAO;
import com.efass.sheet.mmfbr312.sheet312_Service;
import com.efass.sheet.mmfbr321.sheet321DAO;
import com.efass.sheet.mmfbr321.sheet321_Service;
import com.efass.sheet.mmfbr322.sheet322DAO;
import com.efass.sheet.mmfbr322.sheet322_Service;
import com.efass.sheet.mmfbr451.sheet451DAO;
import com.efass.sheet.mmfbr451.sheet451_Service;
import com.efass.sheet.mmfbr501.sheet501DAO;
import com.efass.sheet.mmfbr501.sheet501_Service;
import com.efass.sheet.mmfbr641.sheet641DAO;
import com.efass.sheet.mmfbr641.sheet641_Service;
import com.efass.sheet.mmfbr642.sheet642DAO;
import com.efass.sheet.mmfbr642.sheet642_Service;
import com.efass.sheet.mmfbr651.sheet651DAO;
import com.efass.sheet.mmfbr651.sheet651_Service;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr711.sheet711_Service;
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr746.sheet746_Service;
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.sheet.mmfbr761.sheet761_Service;
import com.efass.sheet.mmfbr762.sheet762DAO;
import com.efass.sheet.mmfbr762.sheet762_Service;
import com.efass.sheet.mmfbr763.sheet763DAO;
import com.efass.sheet.mmfbr763.sheet763_Service;
import com.efass.sheet.mmfbr764.sheet764DAO;
import com.efass.sheet.mmfbr764.sheet764_Service;
import com.efass.sheet.mmfbr771.sheet771DAO;
import com.efass.sheet.mmfbr771.sheet771_Service;
import com.efass.sheet.mmfbr811.sheet811DAO;
import com.efass.sheet.mmfbr811.sheet811_Service;
import com.efass.sheet.mmfbr933.sheet933DAO;
import com.efass.sheet.mmfbr933.sheet933_Service;
import com.efass.sheet.mmfbr951.sheet951DAO;
import com.efass.sheet.mmfbr951.sheet951_Service;
import com.efass.sheet.mmfbr980.sheet980DAO;
import com.efass.sheet.mmfbr980.sheet980_Service;
import com.efass.sheet.mmfbr996.sheet996DAO;
import com.efass.sheet.mmfbr996.sheet996_Service;
import com.efass.sheet.table.TableService;
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

	@Autowired
	private sheet771_Service sheet771Svc;
	
	
	@Autowired
	private sheet762_Service sheet762Svc;
	
	
	@Autowired
	private sheet811_Service sheet811Svc;
	
	@Autowired
	private sheet141_Service sheet141Svc;
	
	
	
	
	@Autowired
	private sheet201_Service sheet201Svc;
	

	@Autowired
	private sheet202_Service sheet202Svc;
	
	@Autowired
	private sheet312_Service sheet312Svc;
	
	
	
	@Autowired
	private sheet322_Service sheet322Svc;
	
	
	
	
	@Autowired
	private sheet451_Service sheet451Svc;
	
	
	
	@Autowired
	private TableService tableSvc;
	
	
	@Autowired
	private sheet763_Service sheet763Svc;
	
	@Autowired
	private sheet764_Service sheet764Svc;
	
	
	@Autowired
	private sheet501_Service sheet501Svc;
	
	
	@Autowired
	private sheet642_Service sheet642Svc;
	
	
	@Autowired
	private sheet651_Service sheet651Svc;
	
	
	
	@Autowired
	private sheet933_Service sheet933Svc;
	
	@Autowired
	private sheet951_Service sheet951Svc;
	
	
	@Autowired
	private sheet996_Service sheet996Svc;
	
	@Autowired
	private sheet980_Service sheet980Svc;
	
	
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

	
	
	//Fetch all table names
	@RequestMapping("/tables/assets")
	public ResponseEntity<?> fetchAssetsChildren(){
		
		return tableSvc.AssetsTableData();
			
	}
	
	
	
	//Fetch all table names
	@RequestMapping("/tables/profits")
	public ResponseEntity<?> fetchProfitsChildren(){
		
		return tableSvc.AssetsTableData();
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	//########################## MMFBR771 ##########################
	@GetMapping("/mmfbr771")
	public ResponseEntity<?> getAllData771() {
		return sheet771Svc.fetchAllData();
	}

	@GetMapping("/mmfbr771/{id}")
	public ResponseEntity<?> getDataById771(@PathVariable int id) throws ResourceNotFoundException {
		return sheet771Svc.getDataById(id);
	}

	@PostMapping("/mmfbr771")
	public ResponseEntity<?> createData771(@RequestBody sheet771DAO data) throws ResourceNotFoundException {
		return sheet771Svc.createData(data);
	}

	@PutMapping("/mmfbr771/{id}")
	public ResponseEntity<?> updateData771(@PathVariable int id, @RequestBody sheet771DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet771Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr771/{id}")
	public ResponseEntity<?> deleteData771(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet771Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	
	//########################## MMFBR762 ##########################
	@GetMapping("/mmfbr762")
	public ResponseEntity<?> getAllData762() {
		return sheet762Svc.fetchAllData();
	}

	@GetMapping("/mmfbr762/{id}")
	public ResponseEntity<?> getDataById762(@PathVariable int id) throws ResourceNotFoundException {
		return sheet762Svc.getDataById(id);
	}

	@PostMapping("/mmfbr762")
	public ResponseEntity<?> createData762(@RequestBody sheet762DAO data) throws ResourceNotFoundException {
		return sheet762Svc.createData(data);
	}

	@PutMapping("/mmfbr762/{id}")
	public ResponseEntity<?> updateData762(@PathVariable int id, @RequestBody sheet762DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet762Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr762/{id}")
	public ResponseEntity<?> deleteData762(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet762Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	//########################## MMFBR763 ##########################
	@GetMapping("/mmfbr763")
	public ResponseEntity<?> getAllData763() {
		return sheet763Svc.fetchAllData();
	}

	@GetMapping("/mmfbr763/{id}")
	public ResponseEntity<?> getDataById763(@PathVariable int id) throws ResourceNotFoundException {
		return sheet763Svc.getDataById(id);
	}

	@PostMapping("/mmfbr763")
	public ResponseEntity<?> createData763(@RequestBody sheet763DAO data) throws ResourceNotFoundException {
		return sheet763Svc.createData(data);
	}

	@PutMapping("/mmfbr763/{id}")
	public ResponseEntity<?> updateData763(@PathVariable int id, @RequestBody sheet763DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet763Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr763/{id}")
	public ResponseEntity<?> deleteData763(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet763Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	//########################## MMFBR764 ##########################
	@GetMapping("/mmfbr764")
	public ResponseEntity<?> getAllData764() {
		return sheet764Svc.fetchAllData();
	}

	@GetMapping("/mmfbr764/{id}")
	public ResponseEntity<?> getDataById764(@PathVariable int id) throws ResourceNotFoundException {
		return sheet764Svc.getDataById(id);
	}

	@PostMapping("/mmfbr764")
	public ResponseEntity<?> createData764(@RequestBody sheet764DAO data) throws ResourceNotFoundException {
		return sheet764Svc.createData(data);
	}

	@PutMapping("/mmfbr764/{id}")
	public ResponseEntity<?> updateData764(@PathVariable int id, @RequestBody sheet764DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet764Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr764/{id}")
	public ResponseEntity<?> deleteData764(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet764Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	//########################## MMFBR811 ##########################
	@GetMapping("/mmfbr811")
	public ResponseEntity<?> getAllData811() {
		return sheet811Svc.fetchAllData();
	}

	@GetMapping("/mmfbr811/{id}")
	public ResponseEntity<?> getDataById811(@PathVariable int id) throws ResourceNotFoundException {
		return sheet811Svc.getDataById(id);
	}

	@PostMapping("/mmfbr811")
	public ResponseEntity<?> createData811(@RequestBody sheet811DAO data) throws ResourceNotFoundException {
		return sheet811Svc.createData(data);
	}

	@PutMapping("/mmfbr811/{id}")
	public ResponseEntity<?> updateData811(@PathVariable int id, @RequestBody sheet811DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet811Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr811/{id}")
	public ResponseEntity<?> deleteData811(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet811Svc.deleteById(id);
	}
	
	//####################################################################
	

	
	
	
	
	
	//########################## MMFBR141 ##########################
	@GetMapping("/mmfbr141")
	public ResponseEntity<?> getAllData141() {
		return sheet141Svc.fetchAllData();
	}

	@GetMapping("/mmfbr141/{id}")
	public ResponseEntity<?> getDataById141(@PathVariable int id) throws ResourceNotFoundException {
		return sheet141Svc.getDataById(id);
	}

	@PostMapping("/mmfbr141")
	public ResponseEntity<?> createData141(@RequestBody sheet141DAO data) throws ResourceNotFoundException {
		return sheet141Svc.createData(data);
	}

	@PutMapping("/mmfbr141/{id}")
	public ResponseEntity<?> updateData141(@PathVariable int id, @RequestBody sheet141DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet141Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr141/{id}")
	public ResponseEntity<?> deleteData141(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet141Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	
	//########################## MMFBR201 ##########################
	@GetMapping("/mmfbr201")
	public ResponseEntity<?> getAllData201() {
		return sheet201Svc.fetchAllData();
	}

	@GetMapping("/mmfbr201/{id}")
	public ResponseEntity<?> getDataById201(@PathVariable int id) throws ResourceNotFoundException {
		return sheet201Svc.getDataById(id);
	}

	@PostMapping("/mmfbr201")
	public ResponseEntity<?> createData201(@RequestBody sheet201DAO data) throws ResourceNotFoundException {
		return sheet201Svc.createData(data);
	}

	@PutMapping("/mmfbr201/{id}")
	public ResponseEntity<?> updateData201(@PathVariable int id, @RequestBody sheet201DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet201Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr201/{id}")
	public ResponseEntity<?> deleteData201(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet201Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	//########################## MMFBR202 ##########################
	@GetMapping("/mmfbr202")
	public ResponseEntity<?> getAllData202() {
		return sheet202Svc.fetchAllData();
	}

	@GetMapping("/mmfbr202/{id}")
	public ResponseEntity<?> getDataById202(@PathVariable int id) throws ResourceNotFoundException {
		return sheet202Svc.getDataById(id);
	}

	@PostMapping("/mmfbr202")
	public ResponseEntity<?> createData202(@RequestBody sheet202DAO data) throws ResourceNotFoundException {
		return sheet202Svc.createData(data);
	}

	@PutMapping("/mmfbr202/{id}")
	public ResponseEntity<?> updateData202(@PathVariable int id, @RequestBody sheet202DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet202Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr202/{id}")
	public ResponseEntity<?> deleteData202(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet202Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	//########################## MMFBR312 ##########################
	@GetMapping("/mmfbr312")
	public ResponseEntity<?> getAllData312() {
		return sheet312Svc.fetchAllData();
	}

	@GetMapping("/mmfbr312/{id}")
	public ResponseEntity<?> getDataById312(@PathVariable int id) throws ResourceNotFoundException {
		return sheet312Svc.getDataById(id);
	}

	@PostMapping("/mmfbr312")
	public ResponseEntity<?> createData312(@RequestBody sheet312DAO data) throws ResourceNotFoundException {
		return sheet312Svc.createData(data);
	}

	@PutMapping("/mmfbr312/{id}")
	public ResponseEntity<?> updateData312(@PathVariable int id, @RequestBody sheet312DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet312Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr312/{id}")
	public ResponseEntity<?> deleteData312(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet312Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	//########################## MMFBR322 ##########################
	@GetMapping("/mmfbr322")
	public ResponseEntity<?> getAllData322() {
		return sheet322Svc.fetchAllData();
	}

	@GetMapping("/mmfbr322/{id}")
	public ResponseEntity<?> getDataById322(@PathVariable int id) throws ResourceNotFoundException {
		return sheet322Svc.getDataById(id);
	}

	@PostMapping("/mmfbr322")
	public ResponseEntity<?> createData322(@RequestBody sheet322DAO data) throws ResourceNotFoundException {
		return sheet322Svc.createData(data);
	}

	@PutMapping("/mmfbr322/{id}")
	public ResponseEntity<?> updateData322(@PathVariable int id, @RequestBody sheet322DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet322Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr322/{id}")
	public ResponseEntity<?> deleteData322(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet322Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	//########################## MMFBR451 ##########################
	@GetMapping("/mmfbr451")
	public ResponseEntity<?> getAllData451() {
		return sheet451Svc.fetchAllData();
	}

	@GetMapping("/mmfbr451/{id}")
	public ResponseEntity<?> getDataById451(@PathVariable int id) throws ResourceNotFoundException {
		return sheet451Svc.getDataById(id);
	}

	@PostMapping("/mmfbr451")
	public ResponseEntity<?> createData451(@RequestBody sheet451DAO data) throws ResourceNotFoundException {
		return sheet451Svc.createData(data);
	}

	@PutMapping("/mmfbr451/{id}")
	public ResponseEntity<?> updateData451(@PathVariable int id, @RequestBody sheet451DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet451Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr451/{id}")
	public ResponseEntity<?> deleteData451(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet451Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	

	//########################## MMFBR501 ##########################
	@GetMapping("/mmfbr501")
	public ResponseEntity<?> getAllData501() {
		return sheet501Svc.fetchAllData();
	}

	@GetMapping("/mmfbr501/{id}")
	public ResponseEntity<?> getDataById501(@PathVariable int id) throws ResourceNotFoundException {
		return sheet501Svc.getDataById(id);
	}

	@PostMapping("/mmfbr501")
	public ResponseEntity<?> createData501(@RequestBody sheet501DAO data) throws ResourceNotFoundException {
		return sheet501Svc.createData(data);
	}

	@PutMapping("/mmfbr501/{id}")
	public ResponseEntity<?> updateData501(@PathVariable int id, @RequestBody sheet501DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet501Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr501/{id}")
	public ResponseEntity<?> deleteData501(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet501Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	

	//########################## MMFBR642 ##########################
	@GetMapping("/mmfbr642")
	public ResponseEntity<?> getAllData642() {
		return sheet642Svc.fetchAllData();
	}

	@GetMapping("/mmfbr642/{id}")
	public ResponseEntity<?> getDataById642(@PathVariable int id) throws ResourceNotFoundException {
		return sheet642Svc.getDataById(id);
	}

	@PostMapping("/mmfbr642")
	public ResponseEntity<?> createData642(@RequestBody sheet642DAO data) throws ResourceNotFoundException {
		return sheet642Svc.createData(data);
	}

	@PutMapping("/mmfbr642/{id}")
	public ResponseEntity<?> updateData642(@PathVariable int id, @RequestBody sheet642DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet642Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr642/{id}")
	public ResponseEntity<?> deleteData642(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet642Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	

	//########################## MMFBR651 ##########################
	@GetMapping("/mmfbr651")
	public ResponseEntity<?> getAllData651() {
		return sheet651Svc.fetchAllData();
	}

	@GetMapping("/mmfbr651/{id}")
	public ResponseEntity<?> getDataById651(@PathVariable int id) throws ResourceNotFoundException {
		return sheet651Svc.getDataById(id);
	}

	@PostMapping("/mmfbr651")
	public ResponseEntity<?> createData651(@RequestBody sheet651DAO data) throws ResourceNotFoundException {
		return sheet651Svc.createData(data);
	}

	@PutMapping("/mmfbr651/{id}")
	public ResponseEntity<?> updateData651(@PathVariable int id, @RequestBody sheet651DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet651Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr651/{id}")
	public ResponseEntity<?> deleteData651(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet651Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	

	//########################## MMFBR933 ##########################
	@GetMapping("/mmfbr933")
	public ResponseEntity<?> getAllData933() {
		return sheet933Svc.fetchAllData();
	}

	@GetMapping("/mmfbr933/{id}")
	public ResponseEntity<?> getDataById933(@PathVariable int id) throws ResourceNotFoundException {
		return sheet933Svc.getDataById(id);
	}

	@PostMapping("/mmfbr933")
	public ResponseEntity<?> createData933(@RequestBody sheet933DAO data) throws ResourceNotFoundException {
		return sheet933Svc.createData(data);
	}

	@PutMapping("/mmfbr933/{id}")
	public ResponseEntity<?> updateData933(@PathVariable int id, @RequestBody sheet933DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		return sheet933Svc.updateData(id, Data);
	}

	@DeleteMapping("/mmfbr933/{id}")
	public ResponseEntity<?> deleteData933(@PathVariable int id) throws ResourceNotFoundException {
		
		return sheet933Svc.deleteById(id);
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	//########################## MMFBR951 ##########################
		@GetMapping("/mmfbr951")
		public ResponseEntity<?> getAllData951() {
			return sheet951Svc.fetchAllData();
		}

		@GetMapping("/mmfbr951/{id}")
		public ResponseEntity<?> getDataById951(@PathVariable int id) throws ResourceNotFoundException {
			return sheet951Svc.getDataById(id);
		}

		@PostMapping("/mmfbr951")
		public ResponseEntity<?> createData951(@RequestBody sheet951DAO data) throws ResourceNotFoundException {
			return sheet951Svc.createData(data);
		}

		@PutMapping("/mmfbr951/{id}")
		public ResponseEntity<?> updateData951(@PathVariable int id, @RequestBody sheet951DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			return sheet951Svc.updateData(id, Data);
		}

		@DeleteMapping("/mmfbr951/{id}")
		public ResponseEntity<?> deleteData951(@PathVariable int id) throws ResourceNotFoundException {
			
			return sheet951Svc.deleteById(id);
		}
		
		//####################################################################





		//########################## MMFBR996 ##########################
		@GetMapping("/mmfbr996")
		public ResponseEntity<?> getAllData996() {
			return sheet996Svc.fetchAllData();
		}

		@GetMapping("/mmfbr996/{id}")
		public ResponseEntity<?> getDataById996(@PathVariable int id) throws ResourceNotFoundException {
			return sheet996Svc.getDataById(id);
		}

		@PostMapping("/mmfbr996")
		public ResponseEntity<?> createData996(@RequestBody sheet996DAO data) throws ResourceNotFoundException {
			return sheet996Svc.createData(data);
		}

		@PutMapping("/mmfbr996/{id}")
		public ResponseEntity<?> updateData996(@PathVariable int id, @RequestBody sheet996DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			return sheet996Svc.updateData(id, Data);
		}

		@DeleteMapping("/mmfbr996/{id}")
		public ResponseEntity<?> deleteData996(@PathVariable int id) throws ResourceNotFoundException {
			
			return sheet996Svc.deleteById(id);
		}
		
		//####################################################################
		
		
		
		
		
		
		
		

		//########################## MMFBR980 ##########################
		@GetMapping("/mmfbr980")
		public ResponseEntity<?> getAllData980() {
			return sheet980Svc.fetchAllData();
		}

		@GetMapping("/mmfbr980/{id}")
		public ResponseEntity<?> getDataById980(@PathVariable int id) throws ResourceNotFoundException {
			return sheet980Svc.getDataById(id);
		}

		@PostMapping("/mmfbr980")
		public ResponseEntity<?> createData980(@RequestBody sheet980DAO data) throws ResourceNotFoundException {
			return sheet980Svc.createData(data);
		}

		@PutMapping("/mmfbr980/{id}")
		public ResponseEntity<?> updateData980(@PathVariable int id, @RequestBody sheet980DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			return sheet980Svc.updateData(id, Data);
		}

		@DeleteMapping("/mmfbr980/{id}")
		public ResponseEntity<?> deleteData980(@PathVariable int id) throws ResourceNotFoundException {
			
			return sheet980Svc.deleteById(id);
		}
		
		//####################################################################


}
