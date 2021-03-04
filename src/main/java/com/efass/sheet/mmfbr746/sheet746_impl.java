package com.efass.sheet.mmfbr746;

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

import com.efass.Validation;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr221.sheet221_Util;
import com.efass.sheet.mmfbr641.sheet641Repository;
import com.efass.sheet.mmfbr711.sheet711DAO;

@Service
public class sheet746_impl   implements sheet746_Service{

	
	
	@Autowired
	sheet746Repository _746Repository;
	
	@Autowired 
	sheet746_Util sheet746Util;
	
	@Autowired
	ReportRepository ReportRepo;
	
	@Autowired
	Validation validation;
	
	// ############################## MMFBR746 CRUD OPERATIONS #################################
	
	public void validate(sheet746DAO data) throws ResourceNotFoundException {
	String namesOfBeneficiary = validation.checkDataType(data.getNameOfBen().toString());
	String dateFacilityGranted = validation.checkDataType(data.getDateGranted().toString());
	String tenor = validation.checkDataType(data.getTenor().toString());
	String amountApproved = validation.checkDataType(data.getAmountApproved().toString());
	String outstandingBalance = validation.checkDataType(data.getOutstandingBalance().toString());
	String statusOfFacility = validation.checkDataType(data.getStatus().toString());
	
		if( !namesOfBeneficiary.equalsIgnoreCase("Alpha")) {
			throw new ResourceNotFoundException("Names Of Beneficiary must be an alphabetic value  " );	
		}else if(!dateFacilityGranted.equalsIgnoreCase("Date")) {	
			throw new ResourceNotFoundException("Date Facility Granted  must be a date value  " );
			}
		 else if( !tenor.equalsIgnoreCase("Alpha")) {
			throw new ResourceNotFoundException("tenor  must be an alphabetic value " );	
		 }
		 else if( !amountApproved.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Amount Approved must be a numeric value  " );	
			 }
		 else if( !outstandingBalance.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("Outstanding Balance must be a numeric value  " );	
			 }
		 else if( !statusOfFacility.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("Status Of Facility  must be an alphabetic value " );	
			 }
	}

	 public ResponseEntity<?> createData(sheet746DAO data) throws ResourceNotFoundException {
		 
		 validate(data);
		 
	     _746Repository.save(data);
	 	Response res = new Response();
	 	res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS746Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	    }
	 
	 
	public ResponseEntity<?> fetchAllData() {
		
		 Field[] fields = sheet746DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
		Iterable<sheet746DAO> data = _746Repository.findAll();
		Response res = new Response();
		res.setSheet746(data);
		res.setResponseMessage("Success");
		res.setColumnNames(colname);
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet746DAO data = _746Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS746Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet746DAO> data = _746Repository.findById(dataId);

		if (data.isPresent()) {
			_746Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id , sheet746DAO Data) throws ResourceNotFoundException {
		
		validate(Data);
		
		Optional<sheet746DAO> DataDb = _746Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet746DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAmountApproved(Data.getAmountApproved());
			DataUpdate.setDateGranted(Data.getDateGranted());
			DataUpdate.setNameOfBen(Data.getNameOfBen());
			DataUpdate.setOutstandingBalance(Data.getOutstandingBalance());
			DataUpdate.setStatus(Data.getStatus());
			DataUpdate.setTenor(Data.getTenor());
			_746Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS746Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}


	
//	public String getFolderPathWithDate(LocalDate date) {
//
//		ReportDAO Data = ReportRepo.findByPathDate(date.toString());
//		String folderPath = Data.getFile_path();
//
//		System.out.println("Folder Path:" + folderPath);
//		return folderPath;
//	}
			
			

	// ####################################################################################

	
	
	
	//#####################SHEET OPERATIONS ############################################
	
	
	@Override
	public Boolean writesheet746(LocalDate Date, String folderPath) 
			throws FileNotFoundException, IOException, EncryptedDocumentException, ParseException, InvalidFormatException {
		
		ArrayList<sheet746DAO> sheetData = new ArrayList<sheet746DAO>();
		sheetData = (ArrayList<sheet746DAO>) _746Repository.findAll();
		
		List<List<Object>> listOfLists = new ArrayList<List<Object>>();
		
			for(int i = 0; i < sheetData.size(); i++) {
				ArrayList<Object> data = new ArrayList<>();
				data.clear();
				data.add(sheetData.get(i).getStatus());
				data.add(sheetData.get(i).getOutstandingBalance());
				data.add(sheetData.get(i).getAmountApproved());
				data.add(sheetData.get(i).getTenor());
				data.add(sheetData.get(i).getDateGranted());
				data.add(sheetData.get(i).getNameOfBen());
				
				listOfLists.add(data);
				
				System.out.println("This are the values written in the sheets for 746" +listOfLists);
				
				}
			
			Boolean status = sheet746Util.writeSpecificList(listOfLists,Date,folderPath);
			if (status == true) {
				return true;
			} else {
				return false;
			}

		}
	
	
	
	//##################################################################################
	
	
	}
	

