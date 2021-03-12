
package com.efass.sheet.mmfbr300;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.efass.sheet.mmfbr300.sheet300DAO;



@Service
public class sheet300_impl implements sheet300_Service{
	

	@Autowired
	sheet300Repository _300Repository;
	
	
	@Autowired
	sheet300_Util sheet300Util;

	// ############################## MMFBR300 CRUD OPERATIONS
	// #################################
	
	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet300DAO> data = _300Repository.findAll();
			
		
		  Field[] fields = sheet300DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
			ArrayList<String> codes = new ArrayList<String>();
			codes.add("10110");	
			codes.add("10120");
			codes.add("10610");
			codes.add("10620");
			codes.add("10630");
			codes.add("10720");
			codes.add("10725");
			codes.add("10730");
			codes.add("10740");
			codes.add("10750");
			codes.add("10880");
			codes.add("10910");
			codes.add("10920");
			codes.add("10930");
			codes.add("10940");
			codes.add("10950");
			codes.add("10960");
			codes.add("10980");	
			codes.add("20110");
			codes.add("20120");
			codes.add("20125");
			codes.add("20130");
			codes.add("20610");
			codes.add("20620");
			codes.add("20630");
			codes.add("20710");
			codes.add("20720");
			codes.add("20810");
			codes.add("20830");
			codes.add("20840");
			codes.add("20910");
			codes.add("20920");
			codes.add("20930");
			codes.add("20935");
			codes.add("20940");
			codes.add("20960");
			
			
			
			ArrayList  arrList = new ArrayList();
			for (String code: codes){
				
			try {
				
				sheet300DAO dataValue = _300Repository.findColumnsByCode(code);
				
				ArrayList<String>  amountList = new ArrayList<String>( );
				amountList.add("col1-"+ dataValue.getCol_1());
				amountList.add("col2-"+ dataValue.getCol_2());
				amountList.add("col3-"+dataValue.getCol_3());
				
				codeData _codeData = new codeData();
				_codeData.setValue(amountList);
				_codeData.setCode(code);
				_codeData.setId(dataValue.getId());
				
				arrList.add(_codeData);
			} 	
			catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
	       		
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet300(arrList);
		res.setResponseMessage("Success");
		
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	
	
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet300DAO data = _300Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS300Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	
	
	public ResponseEntity<?> updateData(int id, sheet300DAO Data) throws ResourceNotFoundException {

		//Validation
//		validate(Data);
		Optional<sheet300DAO> DataDb = _300Repository.findByCode(Data.getCode());

		
		if (DataDb.isPresent()) {
			sheet300DAO DataUpdate = DataDb.get();
			
			DataUpdate.setCol_1(Data.getCol_1());
			
			_300Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	public Boolean writesheet300(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
	EncryptedDocumentException, InvalidFormatException, ParseException {

		ArrayList<sheet300DAO> sheetdata = new ArrayList<>();
		sheetdata = (ArrayList<sheet300DAO>) _300Repository.findAll();

List<List<Object>> listofLists = new ArrayList<List<Object>>();

for(int i =0; i < sheetdata.size(); i++) {
	
	ArrayList<Object> data = new ArrayList<>();
	data.add(sheetdata.get(i).getCol_1());

	
	listofLists.add(data);
	
	System.out.println(">>>>>>>>>>>>>"+listofLists);
}

Boolean status = sheet300Util.writeSpecificList(listofLists, Date, folderPath);
if(status == true) {
	return true;
}
else {
	return false;
}



}

	
	
}
