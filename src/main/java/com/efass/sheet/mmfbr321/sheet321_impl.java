
package com.efass.sheet.mmfbr321;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr311.sheet311Repository;
import com.efass.sheet.mmfbr312.sheet312DAO;

@Service
public class sheet321_impl implements sheet321_Service {

	
	@Autowired
	sheet321Repository _321Repository;
	
	
	@Autowired
	sheet321_Util sheet321Util;
	
	@Autowired
	Validation validation;
	// ############################## MMFBR311 CRUD OPERATIONS #################################

	
	
	 public ResponseEntity<?> createData(sheet321DAO data) throws ResourceNotFoundException {
		 

	     _321Repository.save(data);
	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS321Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet321DAO> data = _321Repository.findAll();
		
		  Field[] fields = sheet321DAO.class.getFields();
				ArrayList<String> colname = new ArrayList<String>();
				for(Field f: fields){
				   colname.add(f.getName()) ;
				}
				
		Response res = new Response();
		res.setSheet321(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet321DAO data = _321Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS321Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet321DAO> data = _321Repository.findById(dataId);

		if (data.isPresent()) {
			_321Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet321DAO Data) throws ResourceNotFoundException {
	
		Optional<sheet321DAO> DataDb = _321Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet321DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setMaturity(Data.getMaturity());
			DataUpdate.setTenor(Data.getTenor());
			_321Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS321Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}


	


	// ####################################################################################

	
	
	
	//#####################SHEET OPERATIONS ############################################
	
	
	

	public Boolean writesheet321(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException {

		ArrayList<sheet321DAO> sheetData = new ArrayList<sheet321DAO>();
		sheetData = (ArrayList<sheet321DAO>) _321Repository.findAll();

		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		for (int i = 0; i < sheetData.size(); i++) {
			ArrayList<Object> data = new ArrayList<>();
			data.clear();
			data.add(sheetData.get(i).getBankCode());
			data.add(sheetData.get(i).getBankName());
			data.add(sheetData.get(i).getTenor());
			data.add(sheetData.get(i).getMaturity());
			data.add(sheetData.get(i).getAmount());
			listOfLists.add(data);
			
			System.out.println("This are the values written in the sheets" +listOfLists);

		}
	
	
		Boolean status = sheet321Util.writeSpecificList(listOfLists,Date,folderPath);
		if (status == true) {
			return true;
		} else {
			return false;
		}

	}
 

	
	//##################################################################################
	
}


