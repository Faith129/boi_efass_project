package com.efass.sheet.mmfbr501;

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

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;

import com.efass.sheet.mmfbr451.sheet451DAO;

import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr501.sheet501DAO;


@Service
public class sheet501_Impl implements sheet501_Service {

	
	@Autowired
	sheet501Repository _501Repository;
	
	@Autowired
	Validation validation; 

	@Autowired
	 sheet501_Util sheet501Util;


	// ############################## MMFBR501 CRUD OPERATIONS
	// #################################
	public void validate(sheet501DAO data) throws ResourceNotFoundException {
		String code = validation.checkDataType(data.getBank_code().toString());
		String item = validation.checkDataType(data.getItem().toString());
		String amount = validation.checkDataType(data.getAmount().toString());
		
			if(!code.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Bank Code  must be an alphabetic value  " );
			}
			
			if(!item.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("Item must be an alphabetic value  " );
		
			}
			
			else if(!amount.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );
			}
			
		}



	public ResponseEntity<?> createData(sheet501DAO data) throws ResourceNotFoundException {
		

		Response res = new Response();
		res.setResponseMessage("Failed");
		res.setResponseCode(-1001);
		res.setS501Data(data);
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet501DAO> data = _501Repository.findAll();
		
		  Field[] fields = sheet501DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet501(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet501DAO data = _501Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS501Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet501DAO> data = _501Repository.findById(dataId);

//		if (data.isPresent()) {
//			_501Repository.delete(data.get());
//		} else {
//			throw new ResourceNotFoundException("Record not found with id : " + dataId);
//		}
		Response res = new Response();
		res.setResponseMessage("Failed");
		res.setResponseCode(-1001);
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);

	}

	public ResponseEntity<?> updateData(int id, sheet501DAO Data) throws ResourceNotFoundException {
		
		//validate(Data);

		Optional<sheet501DAO> DataDb = _501Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet501DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setItem(Data.getItem());
			_501Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS501Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	
	
	
	// #####################SHEET OPERATIONS
	// ############################################
	
	
	public Boolean writesheet501(LocalDate Date, String folderPath) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {

			ArrayList<sheet501DAO> sheetdata = new ArrayList<>();
			
			sheetdata = (ArrayList<sheet501DAO>) _501Repository.findAllByBankCode();
			
			List<List<Object>> listofLists = new ArrayList<List<Object>>();
			
			for(int i = 0; i < sheetdata.size(); i++ ) {
				System.out.println("This is amount "+sheetdata.get(i).getAmount());
				System.out.println("This is bank code "+sheetdata.get(i).getBank_code());
				ArrayList<Object> data = new ArrayList<>();
				
				data.add(sheetdata.get(i).getAmount());
				data.add(sheetdata.get(i).getBank_code());
				listofLists.add(data);
		
			}
			Boolean status=null;
			try {

				
				if(!listofLists.isEmpty()) {
			 status= sheet501Util.writeSpecificList(listofLists, Date, folderPath);
				}else {
				
					System.out.println("MMFBR501 Has No Value");
					return false; 
				}

			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			if(status == true) {
				return true;
			}else {
				return false;
			}
				
				
			
	}
	

	// ##################################################################################

	
}
