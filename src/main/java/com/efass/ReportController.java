package com.efass;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

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
import com.efass.report.ReportService;
import com.efass.sheet.mmfbr1000.sheet1000DAO;
import com.efass.sheet.mmfbr1000.sheet1000_Service;
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr141.sheet141_Service;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr201.sheet201_Service;
import com.efass.sheet.mmfbr202.sheet202DAO;
import com.efass.sheet.mmfbr202.sheet202_Service;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr221.sheet221_Service;
import com.efass.sheet.mmfbr300.sheet300DAO;
import com.efass.sheet.mmfbr300.sheet300_Service;
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
	
	
	@Autowired
	private sheet1000_Service sheet1000Svc;
	
	
	@Autowired
	private ReportService reportSvc;
	
	@Autowired
	private sheet300_Service sheet300Svc;
	
	
	@Autowired
	private sheet1000_Service sheet001Svc;
	
	// CHOOSE REPORT DATE
	// You can consume the path .../report/date/2019-04-25
	@RequestMapping("/report/date/{date}")
	public ResponseEntity<?> userAddedSince2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		
		return reportSvc.selectDate(date);
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


		
	@GetMapping("/mmfbr221/{date}")
	public ResponseEntity<?> getAllData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
			return sheet221Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
		
	}

	@GetMapping("/mmfbr221/{date}/{id}")
	public ResponseEntity<?> getDataById221(@PathVariable int id,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet221Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
		
	}

	@PostMapping("/mmfbr221/{date}")
	public ResponseEntity<?> createData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestBody sheet221DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet221Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
		
	}

	@PutMapping("/mmfbr221/{date}/{id}")
	public ResponseEntity<?> updateData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet221DAO data) throws ResourceNotFoundException {
		data.setId(id);
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet221Svc.updateData(id, data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr221/{date}/{id}")
	public ResponseEntity<?> deleteData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable int id) throws ResourceNotFoundException {
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet221Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	// #################################################################################
	
	
	// ########################## MMFBR300 ##########################################


	
	@GetMapping("/mmfbr300/{date}")
	public ResponseEntity<?> getAllData300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
			return sheet300Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
		
	}

	@GetMapping("/mmfbr300/{date}/{code}")
	public ResponseEntity<?> getDataByCode300(@PathVariable String code , @PathVariable   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {
		
//		string codedata2 = data
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
//			String _code =Integer.toString(Code);
		return sheet300Svc.getDataByCode(code);
		}else {
			return reportSvc.NoDateFound();
		}
		
	}



	@PutMapping("/mmfbr300/{date}/{code}")
	public ResponseEntity<?> updateData300(@PathVariable String code, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestBody sheet300DAO Data) throws ResourceNotFoundException {
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet300Svc.updateData(code, Data);

		}else {
			return reportSvc.NoDateFound();
		}
	}


	// #################################################################################
	
	
	
	
	
	// ########################## MMFBR311 ##########################################
	

	@GetMapping("/mmfbr311/{date}")
	public ResponseEntity<?> getAllData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet311Svc.fetchAllData();
	}else {
		return reportSvc.NoDateFound();
	}
	}

	@GetMapping("/mmfbr311/{date}/{id}")
	public ResponseEntity<?> getDataById311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet311Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr311/{date}")
	public ResponseEntity<?> createData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestBody sheet311DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet311Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr311/{date}/{id}")
	public ResponseEntity<?> updateData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet311DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet311Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr311/{date}/{id}")
	public ResponseEntity<?> deleteData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet311Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	
	
	//###########################################################################
	
	
	
	
	//########################## MMFBR 321 ################################
	
	@GetMapping("/mmfbr321/{date}")
	public ResponseEntity<?> getAllData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet321Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr321/{date}/{id}")
	public ResponseEntity<?> getDataById321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet321Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr321/{date}")
	public ResponseEntity<?> createData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet321DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet321Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr321/{date}/{id}")
	public ResponseEntity<?> updateData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet321DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet321Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr321/{date}/{id}")
	public ResponseEntity<?> deleteData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet321Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	
	//##################################################################
	
	
	
	
	
	//################################ MMFBR 641 #########################################
	
	
	@GetMapping("/mmfbr641/{date}")
	public ResponseEntity<?> getAllData641() {
		return sheet641Svc.fetchAllData();
	}

	@GetMapping("/mmfbr641/{date}/{id}")
	public ResponseEntity<?> getDataById641(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet641Svc.getDataById(id);
	}else {
		return reportSvc.NoDateFound();
	}
	}

	@PostMapping("/mmfbr641/{date}")
	public ResponseEntity<?> createData641(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet641DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet641Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr641/{date}/{id}")
	public ResponseEntity<?> updateData641(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet641DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet641Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr641/{date}/{id}")
	public ResponseEntity<?> deleteData641(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet641Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	
	
	
	//#####################################  MMFBR 711  ##############
	

	@GetMapping("/mmfbr711/{date}")
	public ResponseEntity<?> getAllData711(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet711Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr711/{date}/{id}")
	public ResponseEntity<?> getDataById711(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet711Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr711/{date}")
	public ResponseEntity<?> createData711(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet711DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet711Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr711/{date}/{id}")
	public ResponseEntity<?> updateData711(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet711DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet711Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr711/{date}/{id}")
	public ResponseEntity<?> deleteData711(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet711Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	
	
	
	//########################## MMFBR746 ##########################
	
	@GetMapping("/mmfbr746/{date}")
	public ResponseEntity<?> getAllData746(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet746Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr746/{date}/{id}")
	public ResponseEntity<?> getDataById746(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet746Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr746/{date}")
	public ResponseEntity<?> createData746(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet746DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet746Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr746/{date}/{id}")
	public ResponseEntity<?> updateData746(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet746DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet746Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr746/{date}/{id}")
	public ResponseEntity<?> deleteData746(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet746Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	
	
	
	//#############################################################
	
	
	
	
	
	//########################## MMFBR761 ##########################
	@GetMapping("/mmfbr761/{date}")
	public ResponseEntity<?> getAllData761(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet761Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr761/{date}/{id}")
	public ResponseEntity<?> getDataById761(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet761Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr761/{date}")
	public ResponseEntity<?> createData761(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet761DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet761Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr761/{date}/{id}")
	public ResponseEntity<?> updateData761(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet761DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet761Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr761/{date}/{id}")
	public ResponseEntity<?> deleteData761(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet761Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	//########################## MMFBR771 ##########################
	@GetMapping("/mmfbr771/{date}")
	public ResponseEntity<?> getAllData771(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet771Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr771/{date}/{id}")
	public ResponseEntity<?> getDataById771(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet771Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr771/{date}")
	public ResponseEntity<?> createData771(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet771DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet771Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr771/{date}/{id}")
	public ResponseEntity<?> updateData771(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet771DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet771Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
		
	}

	@DeleteMapping("/mmfbr771/{date}/{id}")
	public ResponseEntity<?> deleteData771(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet771Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	
	//########################## MMFBR762 ##########################
	@GetMapping("/mmfbr762/{date}")
	public ResponseEntity<?> getAllData762(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet762Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr762/{date}/{id}")
	public ResponseEntity<?> getDataById762(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet762Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr762/{date}")
	public ResponseEntity<?> createData762(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet762DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet762Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr762/{date}/{id}")
	public ResponseEntity<?> updateData762(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet762DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet762Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr762/{date}/{id}")
	public ResponseEntity<?> deleteData762(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet762Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	//########################## MMFBR763 ##########################
	@GetMapping("/mmfbr763/{date}")
	public ResponseEntity<?> getAllData763(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet763Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr763/{date}/{id}")
	public ResponseEntity<?> getDataById763(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet763Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr763/{date}")
	public ResponseEntity<?> createData763(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet763DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet763Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr763/{date}/{id}")
	public ResponseEntity<?> updateData763(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet763DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet763Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr763/{date}/{id}")
	public ResponseEntity<?> deleteData763(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet763Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	//########################## MMFBR764 ##########################
	@GetMapping("/mmfbr764/{date}")
	public ResponseEntity<?> getAllData764(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet764Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr764/{date}/{id}")
	public ResponseEntity<?> getDataById764(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet764Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr764/{date}")
	public ResponseEntity<?> createData764(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet764DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet764Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr764/{date}/{id}")
	public ResponseEntity<?> updateData764(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet764DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet764Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr764/{date}/{id}")
	public ResponseEntity<?> deleteData764(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet764Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	//########################## MMFBR811 ##########################
	@GetMapping("/mmfbr811/{date}")
	public ResponseEntity<?> getAllData811(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet811Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr811/{date}/{id}")
	public ResponseEntity<?> getDataById811(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet811Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr811/{date}")
	public ResponseEntity<?> createData811(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet811DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet811Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr811/{date}/{id}")
	public ResponseEntity<?> updateData811(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet811DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet811Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr811/{date}/{id}")
	public ResponseEntity<?> deleteData811(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet811Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	

	
	
	
	
	
	//########################## MMFBR141 ##########################
	@GetMapping("/mmfbr141/{date}")
	public ResponseEntity<?> getAllData141(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet141Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr141/{date}/{id}")
	public ResponseEntity<?> getDataById141(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet141Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr141/{date}")
	public ResponseEntity<?> createData141(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet141DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet141Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr141/{date}/{id}")
	public ResponseEntity<?> updateData141(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet141DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet141Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr141/{date}/{id}")
	public ResponseEntity<?> deleteData141(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet141Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	
	//########################## MMFBR201 ##########################
	@GetMapping("/mmfbr201/{date}")
	public ResponseEntity<?> getAllData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet201Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr201/{date}/{id}")
	public ResponseEntity<?> getDataById201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet201Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr201/{date}")
	public ResponseEntity<?> createData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet201DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet201Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr201/{date}/{id}")
	public ResponseEntity<?> updateData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet201DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet201Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr201/{date}/{id}")
	public ResponseEntity<?> deleteData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet201Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	//########################## MMFBR202 ##########################
	@GetMapping("/mmfbr202/{date}")
	public ResponseEntity<?> getAllData202(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet202Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr202/{date}/{id}")
	public ResponseEntity<?> getDataById202(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		return sheet202Svc.getDataById(id);
	}

	@PostMapping("/mmfbr202/{date}")
	public ResponseEntity<?> createData202(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet202DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet202Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr202/{date}/{id}")
	public ResponseEntity<?> updateData202(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet202DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet202Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr202/{date}/{id}")
	public ResponseEntity<?> deleteData202(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet202Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	//########################## MMFBR312 ##########################
	@GetMapping("/mmfbr312/{date}")
	public ResponseEntity<?> getAllData312(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet312Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr312/{date}/{id}")
	public ResponseEntity<?> getDataById312(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet312Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr312/{date}")
	public ResponseEntity<?> createData312(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet312DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet312Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr312/{date}/{id}")
	public ResponseEntity<?> updateData312(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet312DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet312Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr312/{date}/{id}")
	public ResponseEntity<?> deleteData312(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet312Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	//########################## MMFBR322 ##########################
	@GetMapping("/mmfbr322/{date}")
	public ResponseEntity<?> getAllData322(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet322Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr322/{date}/{id}")
	public ResponseEntity<?> getDataById322(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet322Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr322/{date}")
	public ResponseEntity<?> createData322(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet322DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet322Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr322/{date}/{id}")
	public ResponseEntity<?> updateData322(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet322DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet322Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr322/{date}/{id}")
	public ResponseEntity<?> deleteData322(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet322Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	//########################## MMFBR451 ##########################
	@GetMapping("/mmfbr451/{date}")
	public ResponseEntity<?> getAllData451(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet451Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr451/{date}/{id}")
	public ResponseEntity<?> getDataById451(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet451Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr451/{date}")
	public ResponseEntity<?> createData451(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet451DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet451Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr451/{date}/{id}")
	public ResponseEntity<?> updateData451(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet451DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet451Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr451/{date}/{id}")
	public ResponseEntity<?> deleteData451(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet451Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	

	//########################## MMFBR501 ##########################
	@GetMapping("/mmfbr501/{date}")
	public ResponseEntity<?> getAllData501(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet501Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr501/{date}/{id}")
	public ResponseEntity<?> getDataById501(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet501Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr501/{date}")
	public ResponseEntity<?> createData501(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet501DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet501Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr501/{date}/{id}")
	public ResponseEntity<?> updateData501(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet501DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet501Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr501/{date}/{id}")
	public ResponseEntity<?> deleteData501(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet501Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	

	//########################## MMFBR642 ##########################
	@GetMapping("/mmfbr642/{date}")
	public ResponseEntity<?> getAllData642(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet642Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr642/{date}/{id}")
	public ResponseEntity<?> getDataById642(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet642Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr642/{date}")
	public ResponseEntity<?> createData642(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet642DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet642Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr642/{date}/{id}")
	public ResponseEntity<?> updateData642(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet642DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet642Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr642/{date}/{id}")
	public ResponseEntity<?> deleteData642(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet642Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	

	//########################## MMFBR651 ##########################
	@GetMapping("/mmfbr651/{date}")
	public ResponseEntity<?> getAllData651(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet651Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr651/{date}/{id}")
	public ResponseEntity<?> getDataById651(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet651Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr651/{date}")
	public ResponseEntity<?> createData651(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet651DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet651Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr651/{date}/{id}")
	public ResponseEntity<?> updateData651(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet651DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet651Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr651/{date}/{id}")
	public ResponseEntity<?> deleteData651(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet651Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	

	//########################## MMFBR933 ##########################
	@GetMapping("/mmfbr933/{date}")
	public ResponseEntity<?> getAllData933(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet933Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mmfbr933/{date}/{id}")
	public ResponseEntity<?> getDataById933(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet933Svc.getDataById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mmfbr933/{date}")
	public ResponseEntity<?> createData933(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet933DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet933Svc.createData(data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mmfbr933/{date}/{id}")
	public ResponseEntity<?> updateData933(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet933DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet933Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mmfbr933/{date}/{id}")
	public ResponseEntity<?> deleteData933(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if(evt== true) {
		return sheet933Svc.deleteById(id);
		}else {
			return reportSvc.NoDateFound();
		}
	}
	
	//####################################################################
	
	
	
	
	
	
	
	
	
	
	//########################## MMFBR951 ##########################
		@GetMapping("/mmfbr951/{date}")
		public ResponseEntity<?> getAllData951(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet951Svc.fetchAllData();
		}else {
			return reportSvc.NoDateFound();
		}
		}

		@GetMapping("/mmfbr951/{date}/{id}")
		public ResponseEntity<?> getDataById951(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet951Svc.getDataById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/mmfbr951/{date}")
		public ResponseEntity<?> createData951(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet951DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			
			return sheet951Svc.createData(data);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/mmfbr951/{date}/{id}")
		public ResponseEntity<?> updateData951(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet951DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet951Svc.updateData(id, Data);
		}else {
			return reportSvc.NoDateFound();
		}
		}

		@DeleteMapping("/mmfbr951/{date}/{id}")
		public ResponseEntity<?> deleteData951(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet951Svc.deleteById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}
		
		//####################################################################





		//########################## MMFBR996 ##########################
		@GetMapping("/mmfbr996/{date}")
		public ResponseEntity<?> getAllData996(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet996Svc.fetchAllData();
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/mmfbr996/{date}/{id}")
		public ResponseEntity<?> getDataById996(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet996Svc.getDataById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/mmfbr996/{date}")
		public ResponseEntity<?> createData996(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet996DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet996Svc.createData(data);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/mmfbr996/{date}/{id}")
		public ResponseEntity<?> updateData996(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet996DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet996Svc.updateData(id, Data);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/mmfbr996/{date}/{id}")
		public ResponseEntity<?> deleteData996(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet996Svc.deleteById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}
		
		//####################################################################
		
		
		
		
		
		
		
		

		//########################## MMFBR980 ##########################
		@GetMapping("/mmfbr980/{date}")
		public ResponseEntity<?> getAllData980(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet980Svc.fetchAllData();
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/mmfbr980/{date}/{id}")
		public ResponseEntity<?> getDataById980(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet980Svc.getDataById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/mmfbr980/{date}")
		public ResponseEntity<?> createData980(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@RequestBody sheet980DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet980Svc.createData(data);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/mmfbr980/{date}/{id}")
		public ResponseEntity<?> updateData980(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet980DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet980Svc.updateData(id, Data);
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/mmfbr980/{date}/{id}")
		public ResponseEntity<?> deleteData980(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet980Svc.deleteById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}
		
		//####################################################################

		
		
		
		
		
		
		
		
		
		
		
		
		//########################## MMFBR1000 ##########################
		@GetMapping("/mmfbr1000/{date}")
		public ResponseEntity<?> getAllData1000(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet1000Svc.fetchAllData();
			}else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/mmfbr1000/{date}/{id}")
		public ResponseEntity<?> getDataById1000(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet1000Svc.getDataById(id);
			}else {
				return reportSvc.NoDateFound();
			}
		}

	

		@PutMapping("/mmfbr1000/{date}/{id}")
		public ResponseEntity<?> updateData1000(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable int id, @RequestBody sheet1000DAO Data) throws ResourceNotFoundException {
	
		
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet1000Svc.updateData(id, Data);
			}else {
				return reportSvc.NoDateFound();
			}
		}

	
		//####################################################################

		
		
		
		
		

		//########################## MMFBR1000 ##########################
		@GetMapping("/mmfbr001/{date}")
		public ResponseEntity<?> getAllData001(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if(evt== true) {
			return sheet001Svc.fetchAllData();
			}else {
				return reportSvc.NoDateFound();
			}
		}
		
		
		

		//####################################################################

		
		

	

}
