package com.efass.sheet.mmfbr746;

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
import com.efass.sheet.mmfbr641.sheet641Repository;

@Service
public class sheet746_impl   implements sheet746_Service{

	
	
	@Autowired
	sheet746Repository _746Repository;
	
	// ############################## MMFBR746 CRUD OPERATIONS #################################

	 public ResponseEntity<?> createData(sheet746DAO data) {
	     _746Repository.save(data);
	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS746Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		
		 Field[] fields = sheet746DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
		Iterable<sheet746DAO> data = _746Repository.findAll();
		Response res = new Response();
		res.setSheet746(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet746DAO data = _746Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS746Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet746DAO> data = _746Repository.findById(dataId);

		if (data.isPresent()) {
			_746Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet746DAO Data) throws ResourceNotFoundException {
		
		Optional<sheet746DAO> DataDb = _746Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet746DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmountApproved(Data.getAmountApproved());
			DataUpdate.setDateGranted(Data.getDateGranted());
			DataUpdate.setNameOfBen(Data.getNameOfBen());
			DataUpdate.setOutstandingBalance(Data.getOutstandingBalance());
			DataUpdate.setStatus(Data.getStatus());
			DataUpdate.setTenor(Data.getTenor());
			_746Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS746Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	
	
	
	//#####################SHEET OPERATIONS ############################################
	
	
	
	
	
	//##################################################################################
	
	
}
