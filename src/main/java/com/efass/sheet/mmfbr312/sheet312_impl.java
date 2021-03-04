package com.efass.sheet.mmfbr312;

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
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr321.sheet321_Util;

@Service
public class sheet312_impl implements sheet312_Service{

	
	@Autowired
	sheet312_Util sheet312Util;

	@Autowired
	sheet312Repository _312Repository;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR312 CRUD OPERATIONS
	// #################################
	
	public void validate(sheet312DAO data) throws ResourceNotFoundException {
		String bankCode = validation.checkDataType(data.getBankCode().toString());
		String bankName = validation.checkDataType(data.getNameOfBanks().toString());
		String rate = validation.checkDataType(data.getRate().toString());
		String tenor = validation.checkDataType(data.getTenor().toString());
		String effectiveDate = validation.checkDataType(data.getEffectiveDate().toString());
		String maturityDate = validation.checkDataType(data.getMaturityDate().toString());
		String amount = validation.checkDataType(data.getAmount().toString());
		
			if(!bankCode.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("Bank Code  must be an alphabetic value  " );
			}
			
			if(!bankName.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("Bank Name must be an alphabetic value  " );
		
			}
			
			if(!rate.equalsIgnoreCase("Num")) {	
				throw new ResourceNotFoundException("Rate must be a numeric value  " );
			
			}
			
			if(!tenor.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("Tenor must be an alphabetic value  " );
			
			}
			
			if(!effectiveDate.equalsIgnoreCase("Date")) {	
				throw new ResourceNotFoundException("Effective Date must be an Date value format  " );
			
			}
			
			
			if(!maturityDate.equalsIgnoreCase("Date")) {	
				throw new ResourceNotFoundException("Maturity Date must be an Date value format  " );
			
			}
			
			else if(!amount.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );
			}
			
		}

	

	public ResponseEntity<?> createData(sheet312DAO data) throws ResourceNotFoundException {
		
		validate(data);
		_312Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS312Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet312DAO> data = _312Repository.findAll();

		  Field[] fields = sheet312DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			 
			}
		Response res = new Response();
		res.setSheet312(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
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
		
		validate(Data);

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

	@Override
	public Boolean writesheet312(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList<sheet312DAO> sheetdata = new ArrayList<>();
		
		sheetdata = (ArrayList<sheet312DAO>) _312Repository.findAll();
		
		List<List<Object>> listofLists = new ArrayList<List<Object>>();
		
		for(int i =0; i < sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			data.add(sheetdata.get(i).getBankCode());
			data.add(sheetdata.get(i).getNameOfBanks());
			data.add(sheetdata.get(i).getRate());
			data.add(sheetdata.get(i).getTenor());
			data.add(sheetdata.get(i).getEffectiveDate());
			data.add(sheetdata.get(i).getMaturityDate());
			data.add(sheetdata.get(i).getAmount());
			
			listofLists.add(data);
			
			System.out.println(">>>>>>>>>>>>>"+listofLists);
		}
		
		Boolean status = sheet312Util.writeSpecificList(listofLists, Date, folderPath);
		if(status == true) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################
	
	// ##################################################################################

}
