package com.efass.sheet.mmfbr933;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Service
public class sheet933_impl implements sheet933_Service{

	
	
	@Autowired
	sheet933Repository _933Repository;

	// ############################## MMFBR933 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet933DAO data) {
		_933Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS933Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet933DAO> data = _933Repository.findAll();
		
		  Field[] fields = sheet933DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet933(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet933DAO data = _933Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS933Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet933DAO> data = _933Repository.findById(dataId);

		if (data.isPresent()) {
			_933Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet933DAO Data) throws ResourceNotFoundException {

		Optional<sheet933DAO> DataDb = _933Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet933DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount_transferred_to_general_reserves(Data.getAmount_transferred_to_general_reserves());
			DataUpdate.setCountry(Data.getCountry());
			DataUpdate.setInstitution_name(Data.getInstitution_name());
			DataUpdate.setOutstanding_deferred_grants_amount(Data.getOutstanding_deferred_grants_amount());
			DataUpdate.setPurpose(Data.getOutstanding_deferred_grants_amount());
			
			_933Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS933Data(DataUpdate);
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
