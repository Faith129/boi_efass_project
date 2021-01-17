package com.efass.sheet.mmfbr322;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Service
public class sheet322_impl implements sheet322_Service {

	
	
	
	

	@Autowired
	sheet322Repository _322Repository;

	// ############################## MMFBR322 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet322DAO data) {
		_322Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS322Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet322DAO> data = _322Repository.findAll();
		Response res = new Response();
		res.setSheet322(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet322DAO data = _322Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS322Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet322DAO> data = _322Repository.findById(dataId);

		if (data.isPresent()) {
			_322Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet322DAO Data) throws ResourceNotFoundException {

		Optional<sheet322DAO> DataDb = _322Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet322DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setMaturityDate(Data.getMaturityDate());
			DataUpdate.setNameOfInstitution(Data.getNameOfInstitution());
			DataUpdate.setRate(Data.getRate());
			DataUpdate.setTenor(Data.getTenor());
			_322Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS322Data(DataUpdate);
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
