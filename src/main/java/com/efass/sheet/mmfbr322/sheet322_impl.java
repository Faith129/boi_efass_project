package com.efass.sheet.mmfbr322;

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
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr312.sheet312_Util;

@Service
public class sheet322_impl implements sheet322_Service {

	
	
	@Autowired
	sheet322_Util sheet322Util;
	

	@Autowired
	sheet322Repository _322Repository;

	// ############################## MMFBR322 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet322DAO data) {
		_322Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS322Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet322DAO> data = _322Repository.findAll();

		  Field[] fields = sheet322DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
		Response res = new Response();
		res.setColumnNames(colname);
		res.setSheet322(data);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet322DAO data = _322Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS322Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet322DAO> data = _322Repository.findById(dataId);

		if (data.isPresent()) {
			_322Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet322DAO Data) throws ResourceNotFoundException {

		Optional<sheet322DAO> DataDb = _322Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet322DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setMaturityDate(Data.getMaturityDate());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setRate(Data.getRate());
			DataUpdate.setTenor(Data.getTenor());
			
			_322Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS322Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet322(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
		
		ArrayList<sheet322DAO> sheetdata = new ArrayList<sheet322DAO>();
		
		sheetdata = (ArrayList<sheet322DAO>) _322Repository.findAll();
		
		List<List<Object>> listOflists = new ArrayList<List<Object>>();
		
		for (int i = 0; i < sheetdata.size(); i++) {
			ArrayList<Object> data = new ArrayList<Object>();
			
			data.add(sheetdata.get(i).getBank_code());
			data.add(sheetdata.get(i).getBank_name());
			data.add(sheetdata.get(i).getRate());
			data.add(sheetdata.get(i).getTenor());
			data.add(sheetdata.get(i).getMaturityDate());
			data.add(sheetdata.get(i).getAmount());
			
			listOflists.add(data);
			System.out.println(">>>>>>>>>>>>This is the list" +listOflists);
			
			
		}
		
		Boolean status = sheet322Util.writeSpecificList(listOflists, Date, folderPath);
		
		if(status == true) {
			return true;
		}else {
			return false;
		}
		
	}

	// ####################################################################################

	// #####################SHEET OPERATIONS
	// ############################################

	// ##################################################################################

}
