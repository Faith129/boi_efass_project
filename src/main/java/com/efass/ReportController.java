package com.efass;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efass.payload.Response;

@CrossOrigin()
@RestController
@RequestMapping("api/v1")
public class ReportController {

	Response res = new Response();
	
	
	//CHOOSE REPORT DATE
	//You can consume the path .../report/date/2019-04-25
	@RequestMapping("/report/date/{from}")
	public ResponseEntity<?> userAddedSince2(@PathVariable("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since) {
	    String selectedDate =  "Date: " + since.toString(); 
	
	    //Run Procedure to populate the tables on DB
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
}
