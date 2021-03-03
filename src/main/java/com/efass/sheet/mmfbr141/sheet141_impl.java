package com.efass.sheet.mmfbr141;

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

@Service
public class sheet141_impl implements sheet141_Service{

	

	@Autowired
	sheet141Repository _141Repository;
	
	@Autowired
	sheet141_Util sheet141Util;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR141 CRUD OPERATIONS
	// #################################

	public void validate(sheet141DAO data) throws ResourceNotFoundException {
	String total = validation.checkDataType(data.getTotal().toString());
	String depositType = validation.checkDataType(data.getTypeOfDeposit().toString());
		if( !total.equalsIgnoreCase("Num")) {
			throw new ResourceNotFoundException("Total must be a numeric value  " );	
		}else if(!depositType.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("typeOfDeposit  must be an alphabetic value  " );
			
		}
		
	}
	
	public ResponseEntity<?> createData(sheet141DAO data) throws ResourceNotFoundException {
		
			//Validation
		validate(data);
		_141Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS141Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet141DAO> data = _141Repository.findAll();
		  Field[] fields = sheet141DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
	       		
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet141(data);
		res.setResponseMessage("Success");
		
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet141DAO data = _141Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS141Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet141DAO> data = _141Repository.findById(dataId);

		if (data.isPresent()) {
			_141Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet141DAO Data) throws ResourceNotFoundException {

		Optional<sheet141DAO> DataDb = _141Repository.findById(id);

		//Validation
		validate(Data);
		
		if (DataDb.isPresent()) {
			sheet141DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setTotal(Data.getTotal());
			DataUpdate.setTypeOfDeposit(Data.getTypeOfDeposit());
			_141Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS141Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet141(LocalDate date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList<sheet141DAO> sheetdata  = new ArrayList<>();
		
		sheetdata = (ArrayList<sheet141DAO>) _141Repository.findAll();
		
		List<List<Object>> listofLists = new ArrayList<List<Object>>();
		
		
		for (int i = 0; i <sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			data.clear();
			
			data.add(sheetdata.get(i).getTypeOfDeposit());
			data.add(sheetdata.get(i).getTotal());
			
			listofLists.add(data);
			
			System.out.println("THis is the lists of inputs"+listofLists);
			
		}
			
		
		Boolean status = sheet141Util.writeSpecificList(listofLists, date, folderPath);
		if(status == true) {
			return true;
		} else {
			return false;
		}

	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################
	
	
}
