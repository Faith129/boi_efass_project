package com.efass.sheet.mmfbr311;
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

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr221.sheet221DAO;



@Service
public class sheet311_impl implements sheet311_Service {

	
	
	@Autowired
	sheet311Repository _311Repository;
	
	
	@Autowired
	ReportRepository ReportRepo;

	
	@Autowired 
	sheet311_Util sheet311Util;
	
	@Autowired 
	Validation validation;
	
	// ############################## MMFBR311 CRUD OPERATIONS #################################
	
	public void validate(sheet311DAO data) throws ResourceNotFoundException {
		String bankCode = validation.checkDataType(data.getBankCode().toString());
		String bankName = validation.checkDataType(data.getBankName().toString());
		String tenor = validation.checkDataType(data.getTenor().toString());
		String maturityDate = validation.checkDataType(data.getMaturity_Date().toString());
		String amount = validation.checkDataType(data.getAmount().toString());
		
			if(!bankCode.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("Bank Code  must be an alphabetic value  " );
			}
			
			if(!bankName.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("Bank Name must be an alphabetic value  " );
		
			}
			
			if(!tenor.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("Tenor must be an alphabetic value  " );
			
			}
			
			if(!maturityDate.equalsIgnoreCase("Alpha")) {	
				throw new ResourceNotFoundException("Maturity Date must be an alphabetic value  " );
			
			}
			
			else if( !amount.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount must be a numeric value  " );
			}
			
		}

	
	
	 public ResponseEntity<?> createData(sheet311DAO data) throws ResourceNotFoundException {
		 
		 validate(data);
		 
	     _311Repository.save(data);
	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS311Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		 Field[] fields = sheet311DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
		Iterable<sheet311DAO> data = _311Repository.findAll();
		Response res = new Response();
		res.setSheet311(data);
		res.setColumnNames(colname);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet311DAO data = _311Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS311Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet311DAO> data = _311Repository.findById(dataId);

		if (data.isPresent()) {
			_311Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet311DAO Data) throws ResourceNotFoundException {
		
		validate(Data);
		
		Optional<sheet311DAO> DataDb = _311Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet311DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setMaturity_Date(Data.getMaturity_Date());
			DataUpdate.setTenor(Data.getTenor());
			_311Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS311Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	// ####################################################################################

	
	
	
	
	
	
	//#####################SHEET OPERATIONS ############################################
	

	

	@Override
	public Boolean writesheet311(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {

		ArrayList<sheet311DAO> sheetData = new ArrayList<sheet311DAO>();
		sheetData = (ArrayList<sheet311DAO>) _311Repository.findAll();

		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		for (int i = 0; i < sheetData.size(); i++) {
			ArrayList<Object> data = new ArrayList<>();
			data.clear();
			data.add(sheetData.get(i).getBankCode());
			data.add(sheetData.get(i).getBankName());
			data.add(sheetData.get(i).getTenor());
			data.add(sheetData.get(i).getMaturity_Date());
			data.add(sheetData.get(i).getAmount());
			listOfLists.add(data);

		}
	
	
		Boolean status = sheet311Util.writeSpecificList(listOfLists,Date,folderPath);
		if (status == true) {
			return true;
		} else {
			return false;
		}

	}


	
	
	public String getFolderPathWithDate(LocalDate date) {

		ReportDAO Data = ReportRepo.findByPathDate(date.toString());
		String folderPath = Data.getFile_path();

		System.out.println("Folder Path:" + folderPath);
		return folderPath;
	}
	
	
	
	
	
	//##################################################################################
	
	
	
}
