package com.efass.sheet.mmfbr311;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;



@Service
public class sheet311_impl implements sheet311_Service {

	
	
	@Autowired
	sheet311Repository _311Repository;
	
	// ############################## MMFBR311 CRUD OPERATIONS #################################

	
	
	 public ResponseEntity<?> createData(sheet311DAO data) {
	     _311Repository.save(data);
	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS311Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet311DAO> data = _311Repository.findAll();
		Response res = new Response();
		res.setSheet311(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet311DAO data = _311Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS311Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet311DAO> data = _311Repository.findById(dataId);

		if (data.isPresent()) {
			_311Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet311DAO Data) throws ResourceNotFoundException {
		
		Optional<sheet311DAO> DataDb = _311Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet311DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setMaturity(Data.getMaturity());
			DataUpdate.setTenor(Data.getTenor());
			_311Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS311Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	
	
	
	//#####################SHEET OPERATIONS ############################################
	
	
	
	
	
	//##################################################################################
	
	
	
}
