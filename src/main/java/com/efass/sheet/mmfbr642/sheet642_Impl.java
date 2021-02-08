package com.efass.sheet.mmfbr642;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Service
public class sheet642_Impl implements sheet642_Service{

	@Autowired
	sheet642Repository _642Repository;

	// ############################## MMFBR642 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet642DAO data) {
		_642Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS642Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet642DAO> data = _642Repository.findAll();
		
		  Field[] fields = sheet642DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet642(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet642DAO data = _642Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS642Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet642DAO> data = _642Repository.findById(dataId);

		if (data.isPresent()) {
			_642Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet642DAO Data) throws ResourceNotFoundException {

		Optional<sheet642DAO> DataDb = _642Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet642DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount_granted(Data.getAmount_granted());
			DataUpdate.setCountry(Data.getCountry());
			DataUpdate.setDate_facility_granted(Data.getDate_facility_granted());
			DataUpdate.setEffective_date(Data.getEffective_date());
			DataUpdate.setName_of_lending_institution(Data.getName_of_lending_institution());
			DataUpdate.setTenor(Data.getTenor());
			_642Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS642Data(DataUpdate);
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
