
package com.efass.sheet.mmfbr202;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
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
import com.efass.sheet.mmfbr141.sheet141DAO;

@Service
public class sheet202_impl implements sheet202_Service{


	@Autowired
	sheet202Repository _202Repository;
	
	@Autowired
	Validation validation;
	
	

	public void validate(sheet202DAO data) throws ResourceNotFoundException {

	String depositType = validation.checkDataType(data.getTypeOfDeposit().toString());
		
		 if(!depositType.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("typeOfDeposit  must be an alphabetic value  " );
			
		}
		
	}
	
	

	// ############################## MMFBR202 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet202DAO data) throws ResourceNotFoundException {
		
		validate(data);
		
		_202Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS202Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet202DAO> data = _202Repository.findAll();
		
		  Field[] fields = sheet202DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet202(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet202DAO data = _202Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS202Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet202DAO> data = _202Repository.findById(dataId);

		if (data.isPresent()) {
			_202Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet202DAO Data) throws ResourceNotFoundException {
		
		validate(Data);
		

		Optional<sheet202DAO> DataDb = _202Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet202DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setHundredAndOneNaira(Data.getHundredAndOneNaira());
			DataUpdate.setOneToHundredNaira(Data.getOneToHundredNaira());
			DataUpdate.setTypeOfDeposit(Data.getTypeOfDeposit());
			_202Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS202Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet201(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################
	
	

	
	

	// ##################################################################################

}

package com.efass.sheet.mmfbr202;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
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
import com.efass.sheet.mmfbr141.sheet141DAO;

@Service
public class sheet202_impl implements sheet202_Service{


	@Autowired
	sheet202Repository _202Repository;
	
	@Autowired
	Validation validation;
	
	

	public void validate(sheet202DAO data) throws ResourceNotFoundException {

	String depositType = validation.checkDataType(data.getTypeOfDeposit().toString());
		
		 if(!depositType.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("typeOfDeposit  must be an alphabetic value  " );
			
		}
		
	}
	
	

	// ############################## MMFBR202 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet202DAO data) throws ResourceNotFoundException {
		
		validate(data);
		
		_202Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS202Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet202DAO> data = _202Repository.findAll();
		
		  Field[] fields = sheet202DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet202(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet202DAO data = _202Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS202Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet202DAO> data = _202Repository.findById(dataId);

		if (data.isPresent()) {
			_202Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet202DAO Data) throws ResourceNotFoundException {
		
		validate(Data);
		

		Optional<sheet202DAO> DataDb = _202Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet202DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setHundredAndOneNaira(Data.getHundredAndOneNaira());
			DataUpdate.setOneToHundredNaira(Data.getOneToHundredNaira());
			DataUpdate.setTypeOfDeposit(Data.getTypeOfDeposit());
			_202Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS202Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet201(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################
	
	

	
	

	// ##################################################################################

}

