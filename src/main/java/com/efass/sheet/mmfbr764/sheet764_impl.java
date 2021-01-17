package com.efass.sheet.mmfbr764;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

public class sheet764_impl implements sheet764_Service {

	

	@Autowired
	sheet764Repository _764Repository;

	// ############################## MMFBR746 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet764DAO data) {
		_764Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS764Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet764DAO> data = _764Repository.findAll();
		Response res = new Response();
		res.setSheet764(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet764DAO data = _764Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS764Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet764DAO> data = _764Repository.findById(dataId);

		if (data.isPresent()) {
			_764Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet764DAO Data) throws ResourceNotFoundException {

		Optional<sheet764DAO> DataDb = _764Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet764DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setNintyOneTo180Days(Data.getNintyOneTo180Days());
			DataUpdate.setOneEightyTo180Days(Data.getOneEightyTo180Days());
			DataUpdate.setOver360Days(Data.getOver360Days());
			DataUpdate.setSixtyOneTo90Days(Data.getSixtyOneTo90Days());
			DataUpdate.setThirtyOneTo60Days(Data.getThirtyOneTo60Days());
			DataUpdate.setTypeOfAccount(Data.getTypeOfAccount());
			DataUpdate.setZeroTo30Days(Data.getZeroTo30Days());
			_764Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS764Data(DataUpdate);
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
