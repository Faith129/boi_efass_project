package com.efass.sheet.mmfbr201;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Service
public class sheet201_impl implements sheet201_Service{

	

	@Autowired
	sheet201Repository _201Repository;

	// ############################## MMFBR201 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet201DAO data) {
		_201Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS201Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet201DAO> data = _201Repository.findAll();
		Response res = new Response();
		res.setSheet201(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet201DAO data = _201Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS201Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet201DAO> data = _201Repository.findById(dataId);

		if (data.isPresent()) {
			_201Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet201DAO Data) throws ResourceNotFoundException {

		Optional<sheet201DAO> DataDb = _201Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet201DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setNintyOneTo180Days(Data.getNintyOneTo180Days());
			DataUpdate.setOneEightyOneTo360Days(Data.getOneEightyOneTo360Days());
			DataUpdate.setOneToThirtyDays(Data.getOneToThirtyDays());
			DataUpdate.setSixyOneToNintyDays(Data.getSixyOneToNintyDays());
			DataUpdate.setThirtyOneToSixtyDays(Data.getThirtyOneToSixtyDays());
			DataUpdate.setTypeOfDeposit(Data.getTypeOfDeposit());
			_201Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS201Data(DataUpdate);
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
