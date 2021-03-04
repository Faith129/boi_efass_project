package com.efass.sheet.mmfbr951;

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
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr651.sheet651DAO;

@Service
public class sheet951_impl  implements sheet951_Service{

	@Autowired
	sheet951_Util sheet951Util;
	
	@Autowired
	sheet951Repository _951Repository;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR951 CRUD OPERATIONS
	// #################################
	
	public void validate(sheet951DAO data) throws ResourceNotFoundException {
	String item = validation.checkDataType(data.getItem().toString());
	String amount = validation.checkDataType(data.getAmount().toString());
	
		if( !item.equalsIgnoreCase("Alpha")) {
			throw new ResourceNotFoundException("item must be an alphabetic value " );	
		}else if(!amount.equalsIgnoreCase("Num")) {	
			throw new ResourceNotFoundException("amount  must be a numeric value  " );
			
		}
		
	}

	public ResponseEntity<?> createData(sheet951DAO data) throws ResourceNotFoundException {
		validate(data);
		
		_951Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS951Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet951DAO> data = _951Repository.findAll();
		
		  Field[] fields = sheet951DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet951(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet951DAO data = _951Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS951Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet951DAO> data = _951Repository.findById(dataId);

		if (data.isPresent()) {
			_951Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet951DAO Data) throws ResourceNotFoundException {

		validate(Data);
		
		Optional<sheet951DAO> DataDb = _951Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet951DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setItem(Data.getItem());
			_951Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS951Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet951(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList<sheet951DAO> sheetdata = new ArrayList<>();
		sheetdata =  (ArrayList<sheet951DAO>)  _951Repository.findAll();
		
		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		
		for(int i = 0; i < sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			
			data.add(sheetdata.get(i).getItem());
			data.add(sheetdata.get(i).getAmount());
			
			listOfLists.add(data);
			
			 System.out.println(">>>>>>>>>>>>This is the list" +listOfLists);
			
		}
		
		Boolean status = sheet951Util.writeSpecificList(listOfLists, Date, folderPath);
		
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
