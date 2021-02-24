package com.efass.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.efass.auth.jwt.JwtRequest;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr221.sheet221Repository;
import com.efass.sheet.mmfbr311.sheet311Repository;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr711.sheet711Repository;
import com.efass.specials.SpecialFunction;

@Service
public class ReportImpl implements ReportService{

	
	@Autowired
	ReportRepository ReportRepo;
	

	@Autowired
	sheet711Repository _711Repository;

	 ReportDAO data = new ReportDAO();
	

	
	
	public ResponseEntity<?> selectDate(LocalDate Date)  {
		
		
		//Check if Date Exists
		Boolean isDate=checkDate(Date);
		if(isDate == true) {
		
		
			Response res = new Response();
			res.setResponseMessage("Success,File Exists");
			res.setResponseCode(00);
			res.setFilePath(data.getFile_path());
			return new ResponseEntity<>(res, HttpStatus.OK);	
		}
		
		
		String selectedDate = Date.toString();

		// Create a folder inside exports
		SpecialFunction special = new SpecialFunction();
		Response res = new Response();
		String rand = special.generateRandomString();
		String filename = selectedDate+"-"+rand;
		//String filepath = special.createFolderDirectory( filename,rand);
		String filepath = "./datafiles/export";
		if (!filepath.equals(null)) {
			
		
			//Get Authenication Details
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalName = authentication.getName();
			
			//Save Data
			ReportDAO data = new ReportDAO();
			data.setFile_name(filename );
			data.setFile_path(filepath);
			data.setReport_date(Date.toString());
			data.setUser_id(currentPrincipalName);
			ReportRepo.save(data);
			
			//Populate data for sheet711
			populateSheet711();
			
			// Run Procedure to populate the tables on DB
			res.setResponseMessage("Success,File Created");
			res.setResponseCode(00);
			res.setFilePath(filepath);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} else {
			res.setResponseMessage("Failed To Prepare For Generation");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}

		// Call Procedure to populate tables
	} 
	
	
	
	
	private void populateSheet711() {
		//Delete all 
		_711Repository.deleteAll();
		
		sheet711DAO data = new sheet711DAO();
		data.setLendingModel("Individuals");
		_711Repository.save(data);
		data.setLendingModel("Solidarity Group");
		_711Repository.save(data);
		data.setLendingModel("Neighborhood and Small Group Revolving Funds");
		_711Repository.save(data);
		data.setLendingModel("Village Banking");
		_711Repository.save(data);
		data.setLendingModel("Wholesale lending");
		_711Repository.save(data);
		data.setLendingModel("Credit Unions");
		_711Repository.save(data);
		data.setLendingModel("Staff");
		_711Repository.save(data);
		data.setLendingModel("Others - Specify");
		_711Repository.save(data);
	
		
		
	}


	
	



	public Boolean checkDate(LocalDate Date) {
		
		 data = ReportRepo.findByDate(Date.toString());
	
		if(data== null) {
			
			return false;
			
		}else {
			System.out.println("Selected Date=" + data.getReport_date());
			return true;
		}
		
	}
	

	
	
	
	public ReportDAO findDate(LocalDate Date) {
		
		 data = ReportRepo.findByDate(Date.toString());
	
		if(data== null) {
			return data;
			
		}else {
			System.out.println("Selected Date=" + data.getReport_date());
			return data;
		}
		
	}
	
	
	public ResponseEntity<?> NoDateFound(){
		Response res = new Response();
		res.setResponseMessage("Failed, Report Date Not Selected");
		res.setResponseCode(-1001);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
}
