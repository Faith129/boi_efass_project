package com.efass.sheet.mmfbr1000;

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

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr1000.sheet1000DAO;
import com.efass.sheet.mmfbr312.sheet312DAO;

@Service
public class sheet1000_impl implements sheet1000_Service{

	@Autowired
	sheet1000Repository sheet1000Repo;
	
	
	@Autowired
	sheet1000_Util sheet1000Util;
	
	
	public ResponseEntity<?> fetchAllData() {
	Iterable<sheet1000DAO> data = sheet1000Repo.findAll();
		
		  Field[] fields = sheet1000DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet1000(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet1000DAO data = sheet1000Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS1000Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	public ResponseEntity<?> updateData(String code, sheet1000DAO Data) throws ResourceNotFoundException {

		Optional<sheet1000DAO> DataDb = sheet1000Repo.findByCode(code);

		if (DataDb.isPresent()) {
			sheet1000DAO DataUpdate = DataDb.get();
			DataUpdate.setAmount_1(Data.getAmount_1());
			sheet1000Repo.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1000Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	
	
	
	
	
	
	
	
	

	public Boolean writesheet1000(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList<sheet1000DAO> sheetdata = new ArrayList<>();
				sheetdata = (ArrayList<sheet1000DAO>) sheet1000Repo.findAll();
		
		List<List<Object>> listofLists = new ArrayList<List<Object>>();
		
		for(int i =0; i < sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			data.add(sheetdata.get(i).getAmount_1());
		
			
			listofLists.add(data);
			
			System.out.println(">>>>>>>>>>>>>"+listofLists);
		}
		
		Boolean status = sheet1000Util.writeSpecificList(listofLists, Date, folderPath);
		if(status == true) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
}
