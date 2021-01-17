package com.efass.sheet.mmfbr312;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Service
public class sheet312_impl implements sheet312_Service{

	
	

	@Autowired
	sheet312Repository _312Repository;

	// ############################## MMFBR312 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet312DAO data) {
		_312Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS312Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet312DAO> data = _312Repository.findAll();
		Response res = new Response();
		res.setSheet312(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet312DAO data = _312Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS312Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet312DAO> data = _312Repository.findById(dataId);

		if (data.isPresent()) {
			_312Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet312DAO Data) throws ResourceNotFoundException {

		Optional<sheet312DAO> DataDb = _312Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet312DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setEffectiveDate(Data.getEffectiveDate());
			DataUpdate.setMaturityDate(Data.getMaturityDate());
			DataUpdate.setNameOfBanks(Data.getNameOfBanks());
			DataUpdate.setRate(Data.getRate());
			DataUpdate.setTenor(Data.getTenor());
			
			_312Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS312Data(DataUpdate);
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
