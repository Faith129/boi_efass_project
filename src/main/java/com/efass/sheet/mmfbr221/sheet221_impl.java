package com.efass.sheet.mmfbr221;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
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
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr141.sheet141DAO;

@Service
public class sheet221_impl implements sheet221_Service {

	@Autowired
	sheet221Repository _221Repository;
	
	@Autowired
	ReportRepository ReportRepo;

	
	@Autowired 
	sheet221_Util sheet221Util;
	
	@Autowired
	Validation validation;


	// ############################## MMFBR221 CRUD OPERATIONS #################################
	
	public void validate(sheet221DAO data) throws ResourceNotFoundException {
	String bankCode = validation.checkDataType(data.getBankCode().toString());
	String bankName = validation.checkDataType(data.getBankName().toString());
	String amount = validation.checkDataType(data.getAmount().toString());
	
		if(!bankCode.equalsIgnoreCase("Num")) {
			throw new ResourceNotFoundException("Bank Code  must be an alphabetic value  " );
		}
		if(!bankName.equalsIgnoreCase("Alpha")) {	
		throw new ResourceNotFoundException("Bank Name must be an alphabetic value  " );
	
		}
		else if( !amount.equalsIgnoreCase("Num")) {
			throw new ResourceNotFoundException("Amount must be a numeric value  " );
		}
		
	}

	

	
	
	 public ResponseEntity<?> createData(sheet221DAO data) throws ResourceNotFoundException {
		 
		// validate(data);
		 
	     _221Repository.save(data);     
	   	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS221Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet221DAO> data = _221Repository.findAll();
		
		  Field[] fields = sheet221DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		
		Response res = new Response();
		res.setSheet221(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet221DAO data = _221Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS221Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet221DAO> data = _221Repository.findById(dataId);

		if (data.isPresent()) {
			_221Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet221DAO Data) throws ResourceNotFoundException {
		
		//validate(Data);
		
		Optional<sheet221DAO> DataDb = _221Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet221DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setAmount(Data.getAmount());
			_221Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS221Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}




	// ####################################################################################

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ############################## EXCEL MANIPULATIONS  #################################
	
	
	
	@Override
	public Boolean writesheet221(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {

		ArrayList<sheet221DAO> sheetData = new ArrayList<sheet221DAO>();
		sheetData = (ArrayList<sheet221DAO>) _221Repository.findAll();

		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		for (int i = 0; i < sheetData.size(); i++) {
			ArrayList<Object> data = new ArrayList<>();
			data.clear();
			data.add(sheetData.get(i).getAmount());
			data.add(sheetData.get(i).getBankName());
			data.add(sheetData.get(i).getBankCode());
			listOfLists.add(data);

		}
	
		Boolean status = sheet221Util.writeSpecificList(listOfLists,Date,folderPath);
		if (status == true) {
			return true;
		} else {
			return false;
		}

	}


	
	

	
	


	// ####################################################################################

}
