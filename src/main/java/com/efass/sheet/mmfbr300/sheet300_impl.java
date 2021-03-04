package com.efass.sheet.mmfbr300;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.payload.Response;
import com.efass.sheet.mmfbr202.sheet202DAO;
import com.efass.sheet.mmfbr202.sheet202Repository;

@Service
public class sheet300_impl {
	

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
		//res.setSheet202(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
	
	

}
