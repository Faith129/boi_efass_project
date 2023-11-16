package com.efass.sheet.mmfbr996;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.efass.sheet.mmfbr951.sheet951DAO;
import com.efass.sheet.mmfbr980.sheet980DAO;

@Service
public class sheet996_impl implements sheet996_Service {
	
	@Autowired
	sheet996_Util sheet996Util;
	
	@Autowired
	sheet996Repository _996Repository;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR996 CRUD OPERATIONS
	// #################################
	
	public void validate(sheet996DAO data) throws ResourceNotFoundException {
	String item = validation.checkDataType(data.getItem().toString());
	String amount = validation.checkDataType(data.getAmount().toString());
	
		if( !item.equalsIgnoreCase("Alpha")) {
			throw new ResourceNotFoundException("item must be an alphabetic value " );	
		}else if(!amount.equalsIgnoreCase("Num")) {
			throw new ResourceNotFoundException("amount must be a numeric value " );	
	 }
	}
	
	public ResponseEntity<?> createData(sheet996DAO data) throws ResourceNotFoundException {
		validate(data);
		
		_996Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS996Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet996DAO> data = _996Repository.findAll();
		
		  Field[] fields = sheet996DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet996(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet996DAO data = _996Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS996Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet996DAO> data = _996Repository.findById(dataId);

		if (data.isPresent()) {
			_996Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet996DAO Data) throws ResourceNotFoundException {

		validate(Data);
		Optional<sheet996DAO> DataDb = _996Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet996DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setItem(Data.getItem());
			_996Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS996Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet996(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
		ArrayList<sheet996DAO> sheetdata = new ArrayList<>();
		sheetdata =  (ArrayList<sheet996DAO>) _996Repository.findAll();
		
		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		
		for(int i = 0; i < sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			
			data.add(sheetdata.get(i).getItem());
			data.add(sheetdata.get(i).getAmount());
			
			listOfLists.add(data);
			
			 System.out.println(">>>>>>>>>>>>This is the list" +listOfLists);
			
		}
		
		Boolean status = sheet996Util.writeSpecificList(listOfLists, Date, folderPath);
		
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
