package com.efass.sheet.mmfbr761;

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
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.sheet.mmfbr761.sheet761Repository;

@Service
public class sheet761_impl implements sheet761_Service{

	
	@Autowired
	sheet761Repository _761Repository;
	
	@Autowired
	sheet761_Util sheet761Util;
	
	
	
	// ############################## MMFBR761 CRUD OPERATIONS #################################

	

				
		 public ResponseEntity<?> createData(sheet761DAO data) {
		  //   _761Repository.save(data);
		 	Response res = new Response();
		 	res.setResponseMessage("Success");
			res.setResponseCode(00);
			res.setS761Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		    }
		 
		 
		public ResponseEntity<?> fetchAllData() {

			 Field[] fields = sheet761DAO.class.getFields();
				ArrayList<String> colname = new ArrayList<String>();
				for(Field f: fields){
				   colname.add(f.getName()) ;
				}
				
			Iterable<sheet761DAO> data = _761Repository.findAll();
			Response res = new Response();
			res.setSheet761(data);
			res.setResponseMessage("Success");
			res.setColumnNames(colname);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
			sheet761DAO data = _761Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS761Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

			Optional<sheet761DAO> data = _761Repository.findById(dataId);

			if (data.isPresent()) {
				_761Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}

		public ResponseEntity<?> updateData(int id , sheet761DAO Data) throws ResourceNotFoundException {
			
			Optional<sheet761DAO> DataDb = _761Repository.findById(id);

			String serialNo = "10762";
			if (!serialNo.equals(DataDb.get().getSerialNo().toString())){
				
				throw new ResourceNotFoundException("You can only make change on  S/N:10762 : " + Data.getId());
			}
		
			
			if (DataDb.isPresent()) {
				sheet761DAO DataUpdate = DataDb.get();
				DataUpdate.setId(Data.getId());
				DataUpdate.setAmount(Data.getAmount());
				DataUpdate.setDescription(Data.getDescription());
				DataUpdate.setSerialNo(Data.getSerialNo());
				_761Repository.save(DataUpdate);
				Response res = new Response();
				res.setResponseMessage("Record Updated");
				res.setResponseCode(00);
				res.setS761Data(DataUpdate);
				return new ResponseEntity<>(res, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
			}
		}

		// ####################################################################################

		
		
		
		//#####################SHEET OPERATIONS ############################################
		
		
		@Override
		public Boolean writesheet761(LocalDate Date, String folderPath) 
				throws FileNotFoundException, IOException, EncryptedDocumentException, ParseException, InvalidFormatException {
			
			ArrayList<sheet761DAO> sheetData = new ArrayList<sheet761DAO>();
			sheetData = (ArrayList<sheet761DAO>) _761Repository.findAll();
			
			List<List<Object>> listOfLists = new ArrayList<List<Object>>();
			
				for(int i = 0; i < sheetData.size(); i++) {
					ArrayList<Object> data = new ArrayList<>();
					data.clear();
					data.add(sheetData.get(i).getDescription());
				
					
					listOfLists.add(data);
					
					
					}
				
				Boolean status = sheet761Util.writeSpecificList(listOfLists,Date,folderPath);
				if (status == true) {
					return true;
				} else {
					return false;
				}

			}
		
		
		
		//##################################################################################
		
		
	
}
