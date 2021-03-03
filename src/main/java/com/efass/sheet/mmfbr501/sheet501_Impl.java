package com.efass.sheet.mmfbr501;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr451.sheet451DAO;

@Service
public class sheet501_Impl implements sheet501_Service {

	
	@Autowired
	sheet501Repository _501Repository;
	
	@Autowired
	Validation validation; 

	// ############################## MMFBR501 CRUD OPERATIONS
	// #################################
	public void validate(sheet501DAO data) throws ResourceNotFoundException {
		String code = validation.checkDataType(data.getBank_code().toString());
		String item = validation.checkDataType(data.getItem().toString());
		String amount = validation.checkDataType(data.getAmount().toString());
		
			if(!code.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("Bank Code  must be an alphabetic value  " );
			}
			
			if(!item.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("Item must be an alphabetic value  " );
		
			}
			
			else if(!amount.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );
			}
			
		}


	public ResponseEntity<?> createData(sheet501DAO data) throws ResourceNotFoundException {
		
		validate(data);
		
		_501Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS501Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet501DAO> data = _501Repository.findAll();
		
		  Field[] fields = sheet501DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet501(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet501DAO data = _501Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS501Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet501DAO> data = _501Repository.findById(dataId);

		if (data.isPresent()) {
			_501Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet501DAO Data) throws ResourceNotFoundException {
		
		validate(Data);

		Optional<sheet501DAO> DataDb = _501Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet501DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setItem(Data.getItem());
			_501Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS501Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################

	
}
