package com.efass.sheet.mmfbr762;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
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
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr746.sheet746Repository;

@Service
public class sheet762_impl implements sheet762_Service{

	
	@Autowired
	sheet762Repository _762Repository;
	
	
	
	
	
	// ############################## MMFBR746 CRUD OPERATIONS #################################

	

				
		 public ResponseEntity<?> createData(sheet762DAO data) {
		     _762Repository.save(data);
		 	Response res = new Response();
		 	res.setResponseMessage("Success");
			res.setResponseCode(00);
			res.setS762Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		    }
		 
		 
		public ResponseEntity<?> fetchAllData() {
			 Field[] fields = sheet762DAO.class.getFields();
				ArrayList<String> colname = new ArrayList<String>();
				for(Field f: fields){
				   colname.add(f.getName()) ;
				}
				
			Iterable<sheet762DAO> data = _762Repository.findAll();
			Response res = new Response();
			res.setSheet762(data);
			res.setResponseMessage("Success");
			res.setColumnNames(colname);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
			sheet762DAO data = _762Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS762Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

			Optional<sheet762DAO> data = _762Repository.findById(dataId);

			if (data.isPresent()) {
				_762Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}

		public ResponseEntity<?> updateData(int id , sheet762DAO Data) throws ResourceNotFoundException {
			
			Optional<sheet762DAO> DataDb = _762Repository.findById(id);

			if (DataDb.isPresent()) {
				sheet762DAO DataUpdate = DataDb.get();
				DataUpdate.setId(Data.getId());
				DataUpdate.setAmountGranted(Data.getAmountGranted());
				DataUpdate.setNoOfLoans(Data.getNoOfLoans());
				DataUpdate.setSector(Data.getSector());
				_762Repository.save(DataUpdate);
				Response res = new Response();
				res.setResponseMessage("Record Updated");
				res.setResponseCode(00);
				res.setS762Data(DataUpdate);
				return new ResponseEntity<>(res, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
			}
		}

		// ####################################################################################

		
		
		
		//#####################SHEET OPERATIONS ############################################
		
		
		

		@Override
		public Boolean writesheet762(LocalDate Date, String folderPath)
				throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {

			ArrayList<sheet762DAO> sheetData = new ArrayList<sheet762DAO>();
			sheetData = (ArrayList<sheet762DAO>) _762Repository.findAll();

			List<List<Object>> listOfLists = new ArrayList<List<Object>>();
			for (int i = 0; i < sheetData.size(); i++) {
				ArrayList<Object> data = new ArrayList<>();
				data.clear();
				data.add(sheetData.get(i).getSector());
				data.add(sheetData.get(i).getNoOfLoans());
				data.add(sheetData.get(i).getAmountGranted());
				listOfLists.add(data);

			}
		
		
			Boolean status = sheet762Util.writeSpecificList(listOfLists,Date,folderPath);
			if (status == true) {
				return true;
			} else {
				return false;
			}

		}


		
		
		//##################################################################################
		
		
	
}

