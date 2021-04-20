
package com.efass.sheet.mmfbr300;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr300.sheet300DAO;

@Service
public class sheet300_impl implements sheet300_Service {

	@Autowired
	sheet300Repository _300Repository;

	
	
	@Autowired
	sheet300TemporaryRepository _300TemporaryRepository;
	
	
	@Autowired
	sheet300_Util sheet300Util;

	// ############################## MMFBR300 CRUD OPERATIONS
	// #################################

	@SuppressWarnings("unchecked")
	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet300DAO> data = _300Repository.findAll();

		Field[] fields = sheet300DAO.class.getFields();
		ArrayList<String> colname = new ArrayList<String>();
		for (Field f : fields) {
			colname.add(f.getName());
		}

		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("10110", "10120","10510", "10610", "10620", "10630",
				"10720", "10725", "10730", "10740", "10750", "10880", "10910", "10920", "10930", "10940", "10950",
				"10960", "10980", "20110", "20120", "20125", "20130", "20610", "20620", "20630", "20710", "20720",
				"20810", "20830", "20840", "20910", "20920", "20930", "20935", "20940", "20960"));

		ArrayList arrList = new ArrayList();

		try {
			for (String code : codes) {
				HashMap<String, CodeColData> sheet300Map = new HashMap<String, CodeColData>();// Creating HashMap.


				sheet300DAO dataValue = _300Repository.findColumnsByCode(code);

				System.out.println("codes = " + code);
				if (dataValue != null) {

					ArrayList<String> amountList = new ArrayList<String>();
					amountList.add("col1-" + dataValue.getCol_1());
					amountList.add("col2-" + dataValue.getCol_2());
					amountList.add("col3-" + dataValue.getCol_3());

					CodeColData _codeData = new CodeColData();
					_codeData.setValue(amountList);
					_codeData.setCode(code);
					
					System.out.println(amountList + "*****");
					System.out.println(code + "*****");
					
					_codeData.setId(dataValue.getId());


					// sheet300Map.put(code, _codeData);
					arrList.add(_codeData);

				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
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

		Optional<sheet300DAO> DataDb = _300Repository.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheet300DAO DataUpdate = DataDb.get();

			DataUpdate.setCol_1(Data.getCol_1());
			DataUpdate.setCol_2(Data.getCol_2());
			DataUpdate.setCol_3(Data.getCol_3());
			_300Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS300Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getCode());
		}
	}

	public Boolean writesheet300(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {

		ArrayList<sheet300DAO> sheetdata = new ArrayList<>();
		sheetdata = (ArrayList<sheet300DAO>) _300Repository.findAllOrderByCode();

		System.out.println("*************************** I'm here"+sheetdata);
//		List<List<Object>> listofLists = new ArrayList<List<Object>>(); 





			for (int i = 0; i < sheetdata.size(); i++) {
				

				System.out.println("*************************** Entered here again "+sheetdata);
				ArrayList<sheet300TemporaryDAO> data = new ArrayList<>();

				
				String sheetCode = sheetdata.get(i).getCode();
				String col1 = sheetdata.get(i).getCol_1();
				String col2 = sheetdata.get(i).getCol_2();
				String col3 =sheetdata.get(i).getCol_3();
				
				sheet300TemporaryDAO dt = new sheet300TemporaryDAO();
				dt.setCode(sheetCode);
				dt.setCol_1(col1);
				dt.setCol_2(col2);
				dt.setCol_3(col3);
				_300TemporaryRepository.save(dt);
			}
			FetchAndSaveStaticCodes();
		
			
			
			
			//Fetch Values from temporary table and save in arraylist
			ArrayList<sheet300TemporaryDAO> sheetData = new ArrayList<sheet300TemporaryDAO>();
			 sheetData = _300TemporaryRepository.findAllOrderByCode(); 
			 
				List<List<Object>> listOfLists = new ArrayList<List<Object>>();
				
				for (int i = 0; i < sheetData.size(); i++) {
					ArrayList<Object> data = new ArrayList<>();
					data.clear();

					data.add(sheetData.get(i).getCol_1());
					data.add(sheetData.get(i).getCode());
					data.add(sheetData.get(i).getCol_2());
					data.add(sheetData.get(i).getCol_3());
					
				
					listOfLists.add(data);
				
				}
				

		Boolean status = sheet300Util.writeSpecificList(listOfLists, Date, folderPath);
		if (status == true) {
			return true;
		} else {
			return false;
		}

	}


	public void FetchAndSaveStaticCodes() {
		
		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("10100","10130","10220","10310","10320","10330","10400","10500","10600","10640","10650","10700","10710","10745","10760","10770","10780","10790","10795","10800","10810","10890","10900","10970","10990","11000","20100","20140","20200","20300","20310","20320","20450","20500","20600","20640","20650","20660","20700","20750","20800","20810","20820","20860","20900","20930","20932","20950","20965","20970","20980","20990","20995"));


		for (String code : codes) {
			sheet300TemporaryDAO data300 = SaveStaticCodes(code);
		}
		

	}

	public sheet300TemporaryDAO SaveStaticCodes(String code) {
		sheet300TemporaryDAO data = new sheet300TemporaryDAO();
		data.setCode(code);
		data.setCol_1(null);
		//add to repository 
		_300TemporaryRepository.save(data);
		return data;

	}

// 	public Boolean writesheet300(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
// 			EncryptedDocumentException, InvalidFormatException, ParseException {

// 		ArrayList<sheet300DAO> sheetdata = new ArrayList<>();
// 				sheetdata = (ArrayList<sheet300DAO>) _300Repository.findAll();

// 		List<List<Object>> listofLists = new ArrayList<List<Object>>();

// 		for(int i =0; i < sheetdata.size(); i++) {

// 			ArrayList<Object> data = new ArrayList<>();
// 			//data.add(sheetdata.get(i).getCol_1());

// 			String amount  = sheetdata.get(i).getCol_1(); 

// 			String[] amountList = amount.split("-");
// 			String _amount  = amountList[1];

// 			if ( _amount.equals("null")) {
// 				_amount = null;

// 			}

// 			data.add(_amount);

// 			listofLists.add(data);

// 			System.out.println(">>>>>>>>>>>>>"+listofLists);
// 		}

// 		Boolean status = sheet300Util.writeSpecificList(listofLists, Date, folderPath);
// 		if(status == true) {
// 			return true;
// 		}
// 		else {
// 			return false;
// 		}

// 	}

}
