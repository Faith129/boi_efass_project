package com.efass.sheet.mmfbr201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
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
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr221.sheet221_Util;

@Service
public class sheet201_impl implements sheet201_Service{

	

	@Autowired
	sheet201Repository _201Repository;

	
	
	@Autowired 
	sheet201_Util sheet201Util;
	
	
	// ############################## MMFBR201 CRUD OPERATIONS
	// #################################

	

	
	
	public ResponseEntity<?> createData(sheet201DAO data) throws ResourceNotFoundException {
		
		
//		_201Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Failed");
		res.setResponseCode(-1001);
//		res.setS201Data(data);
		
		
		return new ResponseEntity<>(res, HttpStatus.METHOD_NOT_ALLOWED);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet201DAO> data = _201Repository.findAll();
		
		
		  Field[] fields = sheet201DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet201(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet201DAO data = _201Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS201Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet201DAO> data = _201Repository.findById(dataId);

		if (data.isPresent()) {
			_201Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet201DAO Data) throws ResourceNotFoundException {

		Optional<sheet201DAO> DataDb = _201Repository.findById(id);

				
		if (DataDb.isPresent()) {
			sheet201DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setDuration(Data.getDuration());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setNumberofAccounts(Data.getNumberofAccounts());
			DataUpdate.setTypeOfDeposit(Data.getTypeOfDeposit());
			_201Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS201Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################
	
	

	
	@Override
	public Boolean writesheet201(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {

		ArrayList<sheet201DAO> sheetData = new ArrayList<sheet201DAO>();
		
		
		//sheetData = (ArrayList<sheet201DAO>) _201Repository.findAll();
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

				data.add(sheetData.get(i).getDuration());
				data.add(sheetData.get(i).getTypeOfDeposit());
				data.add(sheetData.get(i).getNumberofAccounts());
				data.add(sheetData.get(i).getAmount());
				
			
				listOfLists.add(data);
			
			}
			
			 status = sheet201Util.writeSpecificList(listOfLists,Date,folderPath, duration);
				if (status == true) {
					status =  true;
				} else {
					status =  false;
				}

		}
		return status;
		
	}


	
	
	
	public ArrayList<sheet201DAO> fetchDataByDuration(String Duration){
		
		 ArrayList<sheet201DAO> sheetData = new ArrayList<sheet201DAO>();
		sheetData = _201Repository.findByDuration(Duration);
		 
		 return sheetData;
		
	}
	// ##################################################################################

}
