package com.efass.sheet.mmfbr642;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr451.sheet451DAO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sun.el.parser.ParseException;

@Service
public class sheet642_Impl implements sheet642_Service{
	
	@Autowired
	sheet642_Util sheet642Util;
	
	

	@Autowired
	sheet642Repository _642Repository;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR642 CRUD OPERATIONS
	// #################################
	
	public void validate(sheet642DAO data) throws ResourceNotFoundException {
		
		String nameOfInstitution = validation.checkDataType(data.getName_of_lending_institution().toString());
		String country = validation.checkDataType(data.getCountry().toString());
		String dateFacility = validation.checkDataType(data.getDate_facility_granted().toString());
		String effectiveDate = validation.checkDataType(data.getEffective_date().toString());
		String tenor = validation.checkDataType(data.getTenor().toString());
		String amount = validation.checkDataType(data.getAmount_granted().toString());
		
			if(!nameOfInstitution.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("Name of Institution must be an alphabetic value  " );
			}
			
			if(!country.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("Country must be an alphabetic value  " );
		
			}
			
			if(!dateFacility.equalsIgnoreCase("Date")) {	
				throw new ResourceNotFoundException("Date Facility must be a date value format  " );
			
			}
			
			if(!effectiveDate.equalsIgnoreCase("Date")) {	
				throw new ResourceNotFoundException("Effective Date must be an date value format  " );
			
			}
		
			
			if(!tenor.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("Tenor must be an alphabetic value  " );
			
			}
			
			
			
			else if(!amount.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );
			}
			
		}

	public ResponseEntity<?> createData(sheet642DAO data) throws ResourceNotFoundException {
		
		validate(data);
		_642Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS642Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet642DAO> data = _642Repository.findAll();
		
		  Field[] fields = sheet642DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet642(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet642DAO data = _642Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS642Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet642DAO> data = _642Repository.findById(dataId);

		if (data.isPresent()) {
			_642Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet642DAO Data) throws ResourceNotFoundException {
		
		validate(Data);

		Optional<sheet642DAO> DataDb = _642Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet642DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount_granted(Data.getAmount_granted());
			DataUpdate.setCountry(Data.getCountry());
			DataUpdate.setDate_facility_granted(Data.getDate_facility_granted());
			DataUpdate.setEffective_date(Data.getEffective_date());
			DataUpdate.setName_of_lending_institution(Data.getName_of_lending_institution());
			DataUpdate.setTenor(Data.getTenor());
			_642Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS642Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public boolean writesheet642(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException,ParseException, Throwable{
		
		ArrayList<sheet642DAO> sheetdata = new ArrayList<>();
		
		sheetdata = (ArrayList<sheet642DAO>) _642Repository.findAll();
		
		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		 
		for(int i = 0; i < sheetdata.size(); i++) {
			 ArrayList <Object> data = new ArrayList<>();
			 
			 data.add(sheetdata.get(i).getName_of_lending_institution());
			 data.add(sheetdata.get(i).getCountry());
			 data.add(sheetdata.get(i).getDate_facility_granted());
			 data.add(sheetdata.get(i).getEffective_date());
			 data.add(sheetdata.get(i).getTenor());
			 data.add(sheetdata.get(i).getAmount_granted());
			 
			 listOfLists.add(data);
			 System.out.println(">>>>>>>>>>>>This is the list" +listOfLists);
		}
	
		Boolean status = sheet642Util.writeSpecificList(listOfLists,Date,folderPath);
		
		if(status == true) {
			return true;
		}else {
			return false;
		}
		

	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################


}

