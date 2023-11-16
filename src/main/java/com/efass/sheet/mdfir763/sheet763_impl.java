package com.efass.sheet.mmfbr763;

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
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr763.sheet763DAO;
import com.efass.sheet.mmfbr762.sheet762DAO;
import com.efass.sheet.mmfbr771.sheet771Repository;

@Service
public class sheet763_impl implements sheet763_Service {

	@Autowired
	sheet763Repository _763Repository;
	
	@Autowired
	ReportRepository ReportRepo;
	
	@Autowired
	sheet763_Util sheet763Util;

	

	// ############################## MMFBR763 CRUD OPERATIONS #################################
	


	public ResponseEntity<?> createData(sheet763DAO data) throws ResourceNotFoundException {
	
		
		_763Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS763Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		
		
		Iterable<sheet763DAO> data = _763Repository.findAll();
		
		 Field[] fields = sheet763DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
		Response res = new Response();
		res.setSheet763(data);
		res.setColumnNames(colname);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet763DAO data = _763Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS763Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet763DAO> data = _763Repository.findById(dataId);

		if (data.isPresent()) {
			_763Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet763DAO Data) throws ResourceNotFoundException {

		Optional<sheet763DAO> DataDb = _763Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet763DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setDuration(Data.getDuration());
			DataUpdate.setNo_of_account(Data.getNo_of_account());
			DataUpdate.setType_of_loan(Data.getType_of_loan());
			_763Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS763Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

//	@Override
//	public Boolean writesheet763(LocalDate date, String folderPath)
//			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
//		
//		ArrayList <sheet763DAO> sheetdata = new ArrayList<sheet763DAO>();
//		
//		sheetdata = (ArrayList<sheet763DAO>) _763Repository.findAll();
//		
//		
//		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
//		
//		for (int i = 0; i < sheetdata.size(); i++) {
//			ArrayList<Object> data = new ArrayList<Object>();
//			data.clear();
//			data.add(sheetdata.get(i).getAmount());
//			data.add(sheetdata.get(i).getType_of_loan());
//			data.add(sheetdata.get(i).getDuration());
//			data.add(sheetdata.get(i).getNo_of_account());
//			listOfLists.add(data);
//			
//		
//			
//		}
//		
//		
//		Boolean status = sheet763Util.writeSpecificList(listOfLists, date, folderPath);
//		if (status == true) {
//			return true;
//		} else {
//			return false;
//		}
//		
//	
//	}
//	
	
	
	
	
	
	
	
	@Override
	public Boolean writesheet763(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {

		ArrayList<sheet763DAO> sheetData = new ArrayList<sheet763DAO>();
		
		
		//sheetData = (ArrayList<sheet763DAO>) _763Repository.findAll();
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
				data.add(sheetData.get(i).getNo_of_account());
				data.add(sheetData.get(i).getAmount());
				data.add(sheetData.get(i).getDuration());
				listOfLists.add(data);
			
			}
			
			 status = sheet763Util.writeSpecificList(listOfLists,Date,  folderPath, duration);
				if (status == true) {
					status =  true;
				} else {
					status =  false;
				}

		}
		return status;
		
	}

	
	
	
	
	public ArrayList<sheet763DAO> fetchDataByDuration(String Duration){
		
		 ArrayList<sheet763DAO> sheetData = new ArrayList<sheet763DAO>();
		sheetData = _763Repository.findByDuration(Duration);
		 
		 return sheetData;
		
	}



	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################

}
