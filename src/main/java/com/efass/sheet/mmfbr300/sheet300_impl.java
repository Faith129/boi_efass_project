
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
import com.efass.sheet.mmfbr300.sheet300DAO;

@Service
public class sheet300_impl implements sheet300_Service {

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
		for (Field f : fields) {
			colname.add(f.getName());
		}

		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("10110", "10120", "10610", "10620", "10630",
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

		List<List<Object>> listofLists = new ArrayList<List<Object>>();

		ArrayList<sheet300DAO> outerCodes = FetchAllCodes();

		for (int k = 0; k < outerCodes.size(); k++) {

			String outCode = outerCodes.get(k).getCode();
			for (int i = 0; i < sheetdata.size(); i++) {
				ArrayList<Object> data = new ArrayList<>();
				
//				if (sheetdata.get(i).getCode().contains(outerCodes.get(k).getCode())) {
//					data.add(sheetdata.get(i).getCol_1());
//					data.add(sheetdata.get(i).getCode());
//					
//	
//			
//				} 
				
				String sheetCode = sheetdata.get(i).getCode();
				String outerCode = outerCodes.get(k).getCode();
				
			
				if(sheetCode.equals(outerCode)) {
				
					outerCodes.remove(k);

				}
				else {

					data.add(sheetdata.get(i).getCode());
					data.add(sheetdata.get(i).getCol_1());
				
				}

			

				listofLists.add(data);

			}
		}
		
		
		//loop through outerArraylist and perform insert
//		for(int i = 0; i < outerCodes.size(); i++) {
//			
//			data.add(sheetdata.get(i).getCode());
//			data.add(null);
//			
//		}
		

		Boolean status = sheet300Util.writeSpecificList(listofLists, Date, folderPath);
		if (status == true) {
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<sheet300DAO> FetchAllCodes() {

		ArrayList<String> codes = new ArrayList<String>(Arrays.asList("10000", "10100", "10110", "10120", "10130",
				"10200", "10210", "10220", "10300", "10310", "10320", "10330", "10400", "10500", "10510", "10600",
				"10610", "10620", "10630", "10640", "10650", "10700", "10710", "10720", "10725", "10730", "10740",
				"10745", "10750", "10760", "10770", "10780", "10790", "10795", "10800", "10810", "10880", "10890",
				"10900", "10910", "10920", "10930", "10940", "10950", "10960", "10970", "10980", "10990", "11000",
				"20100", "20110", "20120", "20125", "20130", "20140", "20200", "20300", "20310", "20320", "20330",
				"20450", "20500", "20600", "20610", "20620", "20630", "20640", "20650", "20660", "20700", "20710",
				"20720", "20750", "20800", "20810", "20820", "20830", "20840", "20860", "20900", "20910", "20920",
				"20930", "20932", "20935", "20940", "20950", "20960", "20965", "20970", "20980", "20990", "20995"));
		ArrayList<sheet300DAO> data = new ArrayList<sheet300DAO>();

		for (String code : codes) {

			sheet300DAO data300 = getAssets(code);
			data.add(data300);
		}
		return data;

	}

	public sheet300DAO getAssets(String code) {
		sheet300DAO data = new sheet300DAO();
		data.setCode(code);
		data.setCol_1(null);
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
