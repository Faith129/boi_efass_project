
package com.efass.sheet.mmfbr1000;

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
import com.efass.sheet.mmfbr1000.sheet1000DAO;


@Service
public class sheet1000_impl implements sheet1000_Service{

	@Autowired
	sheet1000Repository sheet1000Repo;
	
	
	@Autowired
	sheet1000_Util sheet1000Util;
	
	@Autowired
	Validation validation;
	
	public void validate(sheet1000DAO data) throws ResourceNotFoundException {
		
	String amount1 = validation.checkDataType(data.getCol_1().toString());
	
		if (amount1.equalsIgnoreCase("Null")) {
			throw new ResourceNotFoundException("Amount cannot take a null value " );	
		}
	
		if( !amount1.equalsIgnoreCase("Num") ) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );	
		}
		
	
	
	}
	
	
	public ResponseEntity<?> fetchAllData() {
	
		  Field[] fields = sheet1000DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
			ArrayList<String> codes = new ArrayList<String>();
	        codes.add("30000");	
			codes.add("30100");
			codes.add("30210");
			codes.add("30220");
			codes.add("30230");
			codes.add("30240");
			codes.add("31100");
			codes.add("31110");
			codes.add("31120");
			codes.add("31130");
			codes.add("31140");
			codes.add("31150");
			codes.add("31160");
			codes.add("31190");
			codes.add("31210");
			codes.add("31220");
			
			sheet1000Data data = new sheet1000Data();
			
			
			
			ArrayList  arrList = new ArrayList();
			for (String code: codes){
				HashMap<String,sheetCodeData> sheet1000Map=new HashMap<String,sheetCodeData>();//Creating HashMap.
				
				
				sheet1000DAO dataValue = sheet1000Repo.findColumnsByCode(code);
				
				ArrayList<String>  amountList = new ArrayList<String>( );
				amountList.add("col1-"+ dataValue.getCol_1());
				amountList.add("col2-"+ dataValue.getCol_2());
				amountList.add("col3-"+dataValue.getCol_3());
				
				sheetCodeData _codeData = new sheetCodeData();
				_codeData.setValue(amountList);
				_codeData.setCode(code);
				_codeData.setId(dataValue.getId());
		
			
				arrList.add(_codeData);
		
			}
			Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet1000(arrList);
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
	
	
	
	
	
	
	
	public ResponseEntity<?> updateData(int id, sheet1000DAO Data) throws ResourceNotFoundException {

		validate(Data);
	//	Optional<sheet1000DAO> DataDb = sheet1000Repo.findById(id);

		Optional<sheet1000DAO> DataDb = sheet1000Repo.findByCode(Data.getCode());
		
		if (DataDb.isPresent()) {
			sheet1000DAO DataUpdate = DataDb.get();
			DataUpdate.setCol_1(Data.getCol_1());
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
			data.add(sheetdata.get(i).getCol_1());
		
			
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

