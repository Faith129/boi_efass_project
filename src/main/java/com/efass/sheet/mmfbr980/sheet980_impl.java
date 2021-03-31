package com.efass.sheet.mmfbr980;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.efass.sheet.mmfbr951.sheet951DAO;
import com.efass.sheet.mmfbr980.sheet980DAO;

@Service
public class sheet980_impl implements sheet980_Service {

	
	@Autowired
	sheet980Repository _980Repository;

	
	@Autowired
	sheet980_Util sheet980Util;

	// ############################## MMFBR980 CRUD OPERATIONS
	// #################################
	


	public ResponseEntity<?> createData(sheet980DAO data) throws ResourceNotFoundException {

		//_980Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("You Cannot Create Data");
		res.setResponseCode(-1001);
		res.setS980Data(data);
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet980DAO> data = _980Repository.findAll();
		
		  Field[] fields = sheet980DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setSheet980(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet980DAO data = _980Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS980Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet980DAO> data = _980Repository.findById(dataId);

		if (data.isPresent()) {
			_980Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	
	
	
	public ResponseEntity<?> updateData(int id, sheet980DAO Data) throws ResourceNotFoundException {

		Optional<sheet980DAO> DataDb = _980Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet980DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setDuration(Data.getDuration());
			DataUpdate.setItems(Data.getItems());
			DataUpdate.setAmount(Data.getAmount());

			
			_980Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS980Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	
	
	
	// #####################SHEET OPERATIONS
	// ############################################
	
	
	
	@Override
	public Boolean writesheet980(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
	
		ArrayList<sheet980DAO> sheetData = new ArrayList<>();
		
		//sheetdata = (ArrayList<sheet980DAO>) _980Repository.findAll();
		
		ArrayList<String> DurationArr = new ArrayList<String> (
				Arrays.asList(  "1-30 Days","31-60 Days", "61-90 Days", "91-180 Days","181-360 Days","Above 360 Days")
				
				);
		
		
		
		Boolean status = null ;
		for(String duration : DurationArr)
		{
   
		    sheetData = fetchDataByDuration( duration); 
		    
		
		    
			List<List<Object>> listOfLists = new ArrayList<List<Object>>();
			for (int i = 0; i < sheetData.size(); i++) {
				ArrayList<Object> data = new ArrayList<>();
				data.clear();

//				data.add(sheetData.get(i).getDuration());
//				data.add(sheetData.get(i).getItems());
				data.add(sheetData.get(i).getAmount());
				
			
				listOfLists.add(data);
			
			}
			
			

			
			
			 status = sheet980Util.writeSpecificList(listOfLists,Date,folderPath, duration);
				if (status == true) {
					status =  true;
				} else {
					status =  false;
				}

		}
		
		return status;
		
		
//		List<List<Object>> listofLists = new ArrayList<List<Object>>();
//		
//		for (int i = 0; i<sheetdata.size(); i++) {
//			
//			ArrayList<Object> data = new ArrayList<>();
//			
//			data.add(sheetdata.get(i).getItems());
//			data.add(sheetdata.get(i).getOne_to_30_days());
//			data.add(sheetdata.get(i).getThirty_one_to_60_days());
//			data.add(sheetdata.get(i).getSixty_one_to_90_days());
//			data.add(sheetdata.get(i).getNinety_one_to_180_days());
//			data.add(sheetdata.get(i).getOne_eighty_one_to_360_days());
//					
//			listofLists.add(data);
//	
//		
//		}
//		
//		Boolean status = sheet980Util.writeSpecificList(listofLists, Date, folderPath);
//		
//		if (status == true) {
//			return true;
//		}else {
//			return false;
//		}
	
	}
	

	// ##################################################################################
	
	
	
	
	
	
	
	public ArrayList<sheet980DAO> fetchDataByDuration(String Duration){
		
		 ArrayList<sheet980DAO> sheetData = new ArrayList<sheet980DAO>();
		 
		sheetData = _980Repository.findByDuration(Duration);
		 
		 return sheetData;
		
	}

}
