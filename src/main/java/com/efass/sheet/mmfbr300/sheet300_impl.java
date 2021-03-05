
package com.efass.sheet.mmfbr300;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr141.sheet141DAO;


@Service
public class sheet300_impl implements sheet300_Service{
	

	@Autowired
	sheet300Repository _300Repository;
	
	
	

	// ############################## MMFBR300 CRUD OPERATIONS
	// #################################
	
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet300DAO> data = _300Repository.findAll();
		  Field[] fields = sheet300DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
	       		
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet300(data);
		res.setResponseMessage("Success");
		
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet300DAO data = _300Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS300Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	
	public ResponseEntity<?> updateData(String code, sheet300DAO Data) throws ResourceNotFoundException {

		Optional<sheet300DAO> DataDb = _300Repository.findByCode(code);

		//Validation
//		validate(Data);
		
		if (DataDb.isPresent()) {
			sheet300DAO DataUpdate = DataDb.get();
			
			DataUpdate.setAmount1(Data.getAmount1());
			
			_300Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	
	
	
}
