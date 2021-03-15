package com.efass.sheet.mmfbr451;

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
import com.efass.sheet.mmfbr322.sheet322DAO;

@Service
public class sheet451_Impl implements sheet451_Service {

	
	@Autowired
	sheet451_Util sheet451Util;
	

	@Autowired
	sheet451Repository _451Repository;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR451 CRUD OPERATIONS
	// #################################
	
	public void validate(sheet451DAO data) throws ResourceNotFoundException {
		String bankCode = validation.checkDataType(data.getBankCode().toString());
		String NameOfInstitution = validation.checkDataType(data.getNameOfInstitution().toString());
		String rate = validation.checkDataType(data.getRate().toString());
		String tenor = validation.checkDataType(data.getTenor().toString());
		String maturityDate = validation.checkDataType(data.getMaturityDate().toString());
		String amount = validation.checkDataType(data.getAmount().toString());
		
			if(!bankCode.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("Bank Code  must be an alphabetic value  " );
			}
			
			if(!NameOfInstitution.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("Name of Institution must be an alphabetic value  " );
		
			}
			
			if(!rate.equalsIgnoreCase("Num")) {	
				throw new ResourceNotFoundException("Rate must be an numeric value  " );
			
			}
		
			
			if(!tenor.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("Tenor must be an alphabetic value  " );
			
			}
			
			if(!maturityDate.equalsIgnoreCase("Date")) {	
				throw new ResourceNotFoundException("Maturity Date must be in a Date value format " );
			
			}
			
			else if(!amount.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );
			}
			
		}


	public ResponseEntity<?> createData(sheet451DAO data) throws ResourceNotFoundException {
		
		//validate(data);
		
		_451Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS451Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet451DAO> data = _451Repository.findAll();
		

		  Field[] fields = sheet451DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet451(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet451DAO data = _451Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS451Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet451DAO> data = _451Repository.findById(dataId);

		if (data.isPresent()) {
			_451Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet451DAO Data) throws ResourceNotFoundException {
		

		//validate(Data);


		Optional<sheet451DAO> DataDb = _451Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet451DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setMaturityDate(Data.getMaturityDate());
			DataUpdate.setNameOfInstitution(Data.getNameOfInstitution());
			DataUpdate.setRate(Data.getRate());
			DataUpdate.setTenor(Data.getTenor());
			_451Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS451Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet451(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
	
		ArrayList <sheet451DAO> sheetdata = new ArrayList<>();
		sheetdata = (ArrayList<sheet451DAO>) _451Repository.findAll();
		
		List<List<Object>> listOflists = new ArrayList<List<Object>>();
		
		for(int i = 0; i < sheetdata.size(); i++) {
			
			ArrayList <Object> data = new ArrayList<>();
			
			data.add(sheetdata.get(i).getBankCode());
			data.add(sheetdata.get(i).getNameOfInstitution());
			data.add(sheetdata.get(i).getRate());
			data.add(sheetdata.get(i).getTenor());
			data.add(sheetdata.get(i).getMaturityDate());
			data.add(sheetdata.get(i).getAmount());
			
			listOflists.add(data);
			
			System.out.println(">>>>>>>>>>>>This is the list" +listOflists);
			
			
			
		}
		
		Boolean status = sheet451Util.writeSpecificList(listOflists, Date, folderPath);
		
		if (status == true) {
			return true;
		}else
		{
			return false;
		}
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################

	
	
	
	
}
