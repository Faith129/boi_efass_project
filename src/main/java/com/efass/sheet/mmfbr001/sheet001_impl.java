package com.efass.sheet.mmfbr001;

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

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr001.sheet001DAO;
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr001.sheet001DAO;


@Service
public class sheet001_impl implements sheet001_Service {

	@Autowired
	sheet001Repository sheet001Repo;
	
	@Autowired
	sheet001_Util sheet001Util;
	
	@Autowired
	Validation validation;
	

	public void validate(sheet001DAO data) throws ResourceNotFoundException {
		
		if( data.getNUMBER_1().equals(null) ||!data.getNUMBER_2().equals(null)||!data.getVALUE_1().equals(null)||!data.getVALUE_1().equals(null) ) {
			throw new ResourceNotFoundException("Input cannot be empty" );	
		}
		
	String number1 = validation.checkDataType(data.getNUMBER_1().toString());
	String number2 = validation.checkDataType(data.getNUMBER_2().toString());
	
	String value1 = validation.checkDataType(data.getVALUE_1().toString());
	String value2 = validation.checkDataType(data.getVALUE_2().toString());
		if( !number1.equalsIgnoreCase("Num") ||!number2.equalsIgnoreCase("Num") ||!value1.equalsIgnoreCase("Num")||!value2.equalsIgnoreCase("Num") ) {
			throw new ResourceNotFoundException("Input must be a numeric value  " );	
		}
		
	}
	
	
	public ResponseEntity<?> fetchAllData() {
		
		  Field[] fields = sheet001DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
			ArrayList<String> codes = new ArrayList<String>();
	        codes.add("21160");	
			codes.add("21111");
			codes.add("21112");
			codes.add("21121");
			codes.add("21122");
			codes.add("21131");
			codes.add("21132");
			codes.add("1");
			codes.add("21141");
			codes.add("21141");
			
		
			
 
			
			
			ArrayList  arrList = new ArrayList();
			for (String code: codes){
			
			
				sheet001DAO dataValue = sheet001Repo.findColumnsByCode(code);
				
				sheetCodeData _codeData = new sheetCodeData();
				ArrayList<String> values = new ArrayList<>();
				_codeData.setCode(dataValue.getCode());
				values.add("col1-"+dataValue.getNUMBER_1());
				values.add("col2-"+dataValue.getNUMBER_2());
				values.add("col3-"+dataValue.getVALUE_1());
				values.add("col4-"+dataValue.getVALUE_2());
				
				
				_codeData.setId(dataValue.getId());
				
				_codeData.setValue(values);
		
		
		
				arrList.add(_codeData);
		
			}
			Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet001(arrList);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ResponseEntity<?> updateData(int id, sheet001DAO Data) throws ResourceNotFoundException {

		validate(Data);
		
		Optional<sheet001DAO> DataDb = sheet001Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheet001DAO DataUpdate = DataDb.get();
			DataUpdate.setNUMBER_1(Data.getNUMBER_1());
			DataUpdate.setNUMBER_2(Data.getNUMBER_2());
			DataUpdate.setVALUE_1(Data.getVALUE_1());
			DataUpdate.setVALUE_2(Data.getVALUE_2());
			sheet001Repo.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS001Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	
	
	
	
	
	
	public String writesheet001(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
	EncryptedDocumentException, InvalidFormatException, ParseException {

ArrayList<sheet001DAO> sheetdata = new ArrayList<>();
		sheetdata = (ArrayList<sheet001DAO>) sheet001Repo.findAll();

List<List<Object>> listofLists = new ArrayList<List<Object>>();

for(int i =0; i < sheetdata.size(); i++) {
	
	ArrayList<Object> data = new ArrayList<>();
	data.add(sheetdata.get(i).getNUMBER_1());
	data.add(sheetdata.get(i).getVALUE_1());
	
	data.add(sheetdata.get(i).getNUMBER_2());
	data.add(sheetdata.get(i).getVALUE_2());
	
	data.add(sheetdata.get(i).getCode());
	listofLists.add(data);

}

String status = sheet001Util.writeSpecificList(listofLists, Date, folderPath);
return status;



}


	
	
	
	
}
