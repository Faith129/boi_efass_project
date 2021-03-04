package com.efass.sheet.mmfbr1000;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr1000.sheet1000DAO;

@Service
public class sheet1000_impl implements sheet1000_Service{

	@Autowired
	sheet1000Repository sheet1000Repo;
	
	
	
	
	public ResponseEntity<?> fetchAllData() {
	Iterable<sheet1000DAO> data = sheet1000Repo.findAll();
		
		  Field[] fields = sheet1000DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet1000(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
	
	
	public ResponseEntity<?> updateData(String code, sheet1000DAO Data) throws ResourceNotFoundException {

		Optional<sheet1000DAO> DataDb = sheet1000Repo.findByCode(code);

		if (DataDb.isPresent()) {
			sheet1000DAO DataUpdate = DataDb.get();
			DataUpdate.setAmount_1(Data.getAmount_1());
			sheet1000Repo.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1000Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	
	
	
	
	
}
