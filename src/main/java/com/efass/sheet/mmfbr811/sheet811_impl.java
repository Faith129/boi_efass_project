package com.efass.sheet.mmfbr811;

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
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr771.sheet771DAO;
import com.efass.sheet.mmfbr933.sheet933DAO;
import com.efass.sheet.mmfbr933.sheet933_Util;

@Service
public class sheet811_impl implements sheet811_Service{

	@Autowired
	sheet811_Util sheet811Util;

	@Autowired
	sheet811Repository _811Repository;
	
	@Autowired
	Validation validation;

	// ############################## MMFBR811 CRUD OPERATIONS
	// #################################

	public void validate(sheet811DAO data) throws ResourceNotFoundException {
		
		String code = validation.checkDataType(data.getCode().toString());
		String item = validation.checkDataType(data.getItem().toString());
		String perfoming = validation.checkDataType(data.getPerforming().toString());
		String nonPerforming = validation.checkDataType(data.getNonPerforming().toString());
//		String total = validation.checkDataType(data.ge.toString()); 
		
		if( !code.equalsIgnoreCase("num")) {
			throw new ResourceNotFoundException("code must be a numeric value  " );	
		}
		else if( !item.equalsIgnoreCase("Alpha")) {
			throw new ResourceNotFoundException("item must be an alphabetic value  " );	
		}else if(!perfoming.equalsIgnoreCase("num")) {	
			throw new ResourceNotFoundException("perfoming must be a numeric value  " );
			}
		 else if( !nonPerforming.equalsIgnoreCase("num")) {
			throw new ResourceNotFoundException("nonPerforming  must be an numeric value " );	
		 }
		
	}
	public ResponseEntity<?> createData(sheet811DAO data) throws ResourceNotFoundException {
		
		validate(data);
		
		//_811Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Failed");
		res.setResponseCode(-1001);
		res.setS811Data(data);
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<?> fetchAllData() {
		
		 Field[] fields = sheet811DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Iterable<sheet811DAO> data = _811Repository.findAll();
		Response res = new Response();
		res.setSheet811(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet811DAO data = _811Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS811Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet811DAO> data = _811Repository.findById(dataId);

		if (data.isPresent()) {
			//_811Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Failed");
		res.setResponseCode(-1001);
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);

	}

	public ResponseEntity<?> updateData(int id, sheet811DAO Data) throws ResourceNotFoundException {

		validate(Data);
		
		Optional<sheet811DAO> DataDb = _811Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet811DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCode(Data.getCode());
			DataUpdate.setItem(Data.getNonPerforming());
			DataUpdate.setNonPerforming(Data.getNonPerforming());
			DataUpdate.setPerforming(Data.getPerforming());
			
			_811Repository.save(DataUpdate);
			
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS811Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet811(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList<sheet811DAO> sheetdata = new ArrayList<>();
		sheetdata =  (ArrayList<sheet811DAO>) _811Repository.findAll();
		
		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		
		for(int i = 0; i < sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			
			data.add(sheetdata.get(i).getPerforming());
			data.add(sheetdata.get(i).getNonPerforming());
		
			
			
			
			listOfLists.add(data);
			
			 System.out.println(">>>>>>>>>>>>This is the list" +listOfLists);
			
		}
		
		Boolean status = sheet811Util.writeSpecificList(listOfLists, Date, folderPath);
		
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
