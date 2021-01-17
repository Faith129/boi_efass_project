package com.efass.sheet.mmfbr811;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

public class sheet811_impl implements sheet811_Service{


	@Autowired
	sheet811Repository _811Repository;

	// ############################## MMFBR811 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet811DAO data) {
		_811Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS811Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet811DAO> data = _811Repository.findAll();
		Response res = new Response();
		res.setSheet811(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet811DAO data = _811Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS811Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet811DAO> data = _811Repository.findById(dataId);

		if (data.isPresent()) {
			_811Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet811DAO Data) throws ResourceNotFoundException {

		Optional<sheet811DAO> DataDb = _811Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet811DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCode(Data.getCode());
			DataUpdate.setItem(Data.getNonPerforming());
			DataUpdate.setNonPerforming(Data.getNonPerforming());
			DataUpdate.setPerforming(Data.getPerforming());
			
			_811Repository.save(DataUpdate);
			
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS811Data(DataUpdate);
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
