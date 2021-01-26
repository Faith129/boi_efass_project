package com.efass.sheet.mmfbr641;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr221.sheet221DAO;



@Service
public class sheet641_impl implements sheet641_Service {

	
	
	
	@Autowired
	sheet641Repository _641Repository;
	
	// ############################## MMFBR311 CRUD OPERATIONS #################################

	
	
	 public ResponseEntity<?> createData(sheet641DAO data) {
	     _641Repository.save(data);
	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS641Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet641DAO> data = _641Repository.findAll();
		  Field[] fields = sheet221DAO.class.getFields();
				ArrayList<String> colname = new ArrayList<String>();
				for(Field f: fields){
				   colname.add(f.getName()) ;
				}
				
		Response res = new Response();
		res.setSheet641(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet641DAO data = _641Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS641Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet641DAO> data = _641Repository.findById(dataId);

		if (data.isPresent()) {
			_641Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet641DAO Data) throws ResourceNotFoundException {
		
		Optional<sheet641DAO> DataDb = _641Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet641DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setNatureOfInvestment(Data.getNatureOfInvestment());
			_641Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS641Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	
	
	
	//#####################SHEET OPERATIONS ############################################
	
	
	
	
	
	//##################################################################################
	
}
