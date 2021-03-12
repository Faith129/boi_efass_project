package com.efass.sheet.mmfbr711;

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
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr321.sheet321Repository;

@Service
public class sheet711_impl implements sheet711_Service {

	@Autowired
	sheet711Repository _711Repository;
	
	@Autowired
	sheet711_Util sheet711Util;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR311 CRUD OPERATION  #################################
	
	public void validate(sheet711DAO data) throws ResourceNotFoundException {
	String number = validation.checkDataType(data.getNumbers().toString());
	String lendingModel = validation.checkDataType(data.getLendingModel().toString());
	String amount = validation.checkDataType(data.getAmount().toString());
	
		if( !number.equalsIgnoreCase("Num")) {
			throw new ResourceNotFoundException("Number must be a numeric value  " );	
		}else if(!lendingModel.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("lendingModel  must be an alphabetic value  " );
			}
		 else if( !amount.equalsIgnoreCase("Num")) {
			throw new ResourceNotFoundException("Amount must be a numeric value  " );	
		 }
	}

	public ResponseEntity<?> createData(sheet711DAO data) throws ResourceNotFoundException {
//		_711Repository.save(data);
		
		//validate(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS711Data(data);
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<?> fetchAllData() {
		
		  Field[] fields = sheet711DAO.class.getFields();
				ArrayList<String> colname = new ArrayList<String>();
				for(Field f: fields){
				   colname.add(f.getName()) ;
				}
		Iterable<sheet711DAO> data = _711Repository.findAll();
		Response res = new Response();
		res.setSheet711(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet711DAO data = _711Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS711Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet711DAO> data = _711Repository.findById(dataId);

		if (data.isPresent()) {
			_711Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet711DAO Data) throws ResourceNotFoundException {

		//validate(Data);
		Optional<sheet711DAO> DataDb = _711Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet711DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setLendingModel(Data.getLendingModel());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setNumbers(Data.getNumbers());
			DataUpdate.setPercentage(Data.getPercentage());
			_711Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS711Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	
	
	
	//#####################SHEET OPERATIONS ############################################
	

	@Override
	
	
	public Boolean writesheet711(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {

		ArrayList<sheet711DAO> sheetData = new ArrayList<sheet711DAO>();
		sheetData = (ArrayList<sheet711DAO>) _711Repository.findAll();

		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		for (int i = 0; i < sheetData.size(); i++) {
			ArrayList<Object> data = new ArrayList<>();
			data.clear();
			//data.add(sheetData.get(i).getLendingModel());
			data.add(sheetData.get(i).getNumbers());
			data.add(sheetData.get(i).getAmount());
			
			listOfLists.add(data);

		}
	
	
		Boolean status = sheet711Util.writeSpecificList(listOfLists,Date,folderPath);
		if (status == true) {
			return true;
		} else {
			return false;
		}

	}

	// ####################################################################################
	
	
	
	
	

}
