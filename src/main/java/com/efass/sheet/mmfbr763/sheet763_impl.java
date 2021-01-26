package com.efass.sheet.mmfbr763;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr771.sheet771Repository;

@Service
public class sheet763_impl implements sheet763_Service {

	@Autowired
	sheet763Repository _763Repository;

	// ############################## MMFBR763 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet763DAO data) {
		_763Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS763Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet763DAO> data = _763Repository.findAll();
		Response res = new Response();
		res.setSheet763(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet763DAO data = _763Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS763Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet763DAO> data = _763Repository.findById(dataId);

		if (data.isPresent()) {
			_763Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet763DAO Data) throws ResourceNotFoundException {

		Optional<sheet763DAO> DataDb = _763Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet763DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAbove_360_days(Data.getAbove_360_days());
			DataUpdate.setNinty_one_to_180_days(Data.getNinty_one_to_180_days());
			DataUpdate.setOne_eighty_one_to_360_days(Data.getOne_eighty_one_to_360_days());
			DataUpdate.setOne_to_30_Days(Data.getOne_to_30_Days());
			DataUpdate.setSixty_one_to_90_days(Data.getSixty_one_to_90_days());
			DataUpdate.setThirty_one_to_60_Days(Data.getThirty_one_to_60_Days());
			DataUpdate.setTypeOfLoans(Data.getTypeOfLoans());

			_763Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS763Data(DataUpdate);
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
