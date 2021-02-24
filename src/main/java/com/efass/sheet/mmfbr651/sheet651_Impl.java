package com.efass.sheet.mmfbr651;

import java.io.FileNotFoundException;
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

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

@Service
public class sheet651_Impl implements sheet651_Service{
	
	@Autowired
	sheet651_Util sheet651Util;

	@Autowired
	sheet651Repository _651Repository;

	// ############################## MMFBR651 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet651DAO data) {
		_651Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS651Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet651DAO> data = _651Repository.findAll();
		
		  Field[] fields = sheet651DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet651(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet651DAO data = _651Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS651Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet651DAO> data = _651Repository.findById(dataId);

		if (data.isPresent()) {
			_651Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet651DAO Data) throws ResourceNotFoundException {

		Optional<sheet651DAO> DataDb = _651Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet651DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount_granted(Data.getAmount_granted());
			DataUpdate.setCountry(Data.getCountry());
			DataUpdate.setDate_facility_granted(Data.getDate_facility_granted());
			DataUpdate.setName_of_lending_institution(Data.getName_of_lending_institution());
			DataUpdate.setTenor(Data.getTenor());
			_651Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS651Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet651(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList <sheet651DAO> sheetdata = new ArrayList<>();
		sheetdata = (ArrayList<sheet651DAO>) _651Repository.findAll();
		
		List<List<Object>> listOflists = new ArrayList<List<Object>>();
		
		for (int i = 0; i <sheetdata.size(); i++) {
			
			ArrayList <Object> data = new ArrayList<>();
			
			data.add(sheetdata.get(i).getName_of_lending_institution());
			 data.add(sheetdata.get(i).getCountry());
			 data.add(sheetdata.get(i).getDate_facility_granted());
			 data.add(sheetdata.get(i).getTenor());
			 data.add(sheetdata.get(i).getAmount_granted());
			 
			 listOflists.add(data);
			 System.out.println(">>>>>>>>>>>>This is the list" +listOflists);
		}
	
		Boolean status = sheet651Util.writeSpecificList(listOflists,Date,folderPath);
		
		if(status == true) {
			return true;
		}else {
			return false;
		}

	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################


}
