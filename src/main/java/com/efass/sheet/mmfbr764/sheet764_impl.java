package com.efass.sheet.mmfbr764;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr764.sheet764DAO;
import com.efass.sheet.mmfbr771.sheet771_Util;

@Service
public class sheet764_impl implements sheet764_Service {

	

	@Autowired
	sheet764Repository _764Repository;
	
	@Autowired

	Validation validation;

	sheet771_Util sheet764Util; 


	// ############################## MMFBR746 CRUD OPERATIONS
	// #################################

	public void validate(sheet764DAO data) throws ResourceNotFoundException {
		String typeOfAccount = validation.checkDataType(data.getAccount_type().toString());
		
		 if(!typeOfAccount.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("typeOfDeposit  must be an alphabetic value  " );	
			}
		 
	}
	
	public ResponseEntity<?> createData(sheet764DAO data) throws ResourceNotFoundException {
		
		validate(data);
		
		_764Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS764Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		
		  Field[] fields = sheet764DAO.class.getFields();
				ArrayList<String> colname = new ArrayList<String>();
				for(Field f: fields){
				   colname.add(f.getName()) ;
				}
				
		Iterable<sheet764DAO> data = _764Repository.findAll();
		Response res = new Response();
		res.setSheet764(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
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

		validate(Data);
		
		Optional<sheet764DAO> DataDb = _764Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet764DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAbove_360_days(Data.getAbove_360_days());
			DataUpdate.setAccount_type(Data.getAccount_type());
			DataUpdate.setNinety_one_to_180_days(Data.getNinety_one_to_180_days());
			DataUpdate.setOne_eighty_one_to_360_days(Data.getOne_eighty_one_to_360_days());
			DataUpdate.setOne_to_30_days(Data.getOne_to_30_days());
			DataUpdate.setSixty_one_to_90_days(Data.getSixty_one_to_90_days());
			DataUpdate.setThirtyOneTo60Days(Data.getThirtyOneTo60Days());
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
	
	
	
	
	public Boolean writesheet764(LocalDate Date, String folderPath) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {

		ArrayList<sheet764DAO> sheetdata = new ArrayList<>();
		
		sheetdata = (ArrayList<sheet764DAO>) _764Repository.findAll();
		
		List<List<Object>> listofLists = new ArrayList<List<Object>>();
		
		for(int i = 0; i < sheetdata.size(); i++ ) {
			
			ArrayList<Object> data = new ArrayList<>();
			data.add(sheetdata.get(i).getAccount_type());
			data.add(sheetdata.get(i).getOne_to_30_days());
			data.add(sheetdata.get(i).getThirtyOneTo60Days());
			data.add(sheetdata.get(i).getSixty_one_to_90_days());
			data.add(sheetdata.get(i).getNinety_one_to_180_days());
			data.add(sheetdata.get(i).getOne_eighty_one_to_360_days());
			data.add(sheetdata.get(i).getAbove_360_days());
			
		
			listofLists.add(data);
	
		}
			
		Boolean status = sheet764Util.writeSpecificList(listofLists, Date, folderPath);
		
		if(status == true) {
			return true;
		}else {
			return false;
		}
			
			
		
}
	
	

	// ##################################################################################

}
