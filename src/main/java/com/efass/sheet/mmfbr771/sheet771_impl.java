package com.efass.sheet.mmfbr771;

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
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr746.sheet746_Util;
import com.efass.sheet.mmfbr764.sheet764DAO;


@Service
public class sheet771_impl implements sheet771_Service {

	@Autowired
	sheet771Repository _771Repository;
	
	@Autowired 
	sheet771_Util sheet771Util;
	
	@Autowired
	Validation validation;
	

	// ############################## MMFBR746 CRUD OPERATIONS
	// #################################
	
	public void validate(sheet771DAO data) throws ResourceNotFoundException {
	String customerCode = validation.checkDataType(data.getCustomerCode().toString());
	String customerName = validation.checkDataType(data.getCustomerName().toString());
	String pastDueDate = validation.checkDataType(data.getPastDueDate().toString());
	String lastDateRepayment = validation.checkDataType(data.getLastRepaymentDate().toString());
	String amountGranted = validation.checkDataType(data.getAmountGranted().toString());
	String principalPaymentDue = validation.checkDataType(data.getPrincipalPaymentDueUnpaid().toString());
	String accruedInterest = validation.checkDataType(data.getAccruedInterestUnpaid().toString());
	String totalNonPerformingCredit = validation.checkDataType(data.getTotalNonPerformingCredit().toString());
//	String bankProvision = validation.checkDataType(data.get.toString());
	String remarks = validation.checkDataType(data.getRemarks().toString());
	
		if( !customerCode.equalsIgnoreCase("Alpha")) {
			throw new ResourceNotFoundException("customerCode must be an alphabetic value  " );	
		}else if(!customerName.equalsIgnoreCase("Alpha")) {	
			throw new ResourceNotFoundException("customerName  must be an alphabetic value   " );
			}
		 else if( !pastDueDate.equalsIgnoreCase("Date")) {
			throw new ResourceNotFoundException("pastDueDate  must be a date value " );	
		 }
		 else if( !lastDateRepayment.equalsIgnoreCase("Date")) {
				throw new ResourceNotFoundException("lastDateRepayment must be a date value  " );	
			 }
		 else if( !amountGranted.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("amountGranted must be a numeric value  " );	
			 }
		 else if( !principalPaymentDue.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("principalPaymentDue  must be a numeric value " );	
			 }
		 else if( !accruedInterest.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("accruedInterest Of Facility  must be a numeric value " );	
			 }
		 else if( !totalNonPerformingCredit.equalsIgnoreCase("Num")) {
				throw new ResourceNotFoundException("totalNonPerformingCredit  must be a numeric value " );	
			 }
		 else if( !remarks.equalsIgnoreCase("Alpha")) {
				throw new ResourceNotFoundException("remarks  must be an alphabetic value " );	
			 }
	}


	public ResponseEntity<?> createData(sheet771DAO data) throws ResourceNotFoundException {
		//validate(data);
		
		_771Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS771Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet771DAO> data = _771Repository.findAll();
		
		  Field[] fields = sheet771DAO.class.getFields();
			ArrayList<String> colname = new ArrayList<String>();
			for(Field f: fields){
			   colname.add(f.getName()) ;
			}
			
		Response res = new Response();
		res.setSheet771(data);
		res.setColumnNames(colname);
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet771DAO data = _771Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS771Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet771DAO> data = _771Repository.findById(dataId);

		if (data.isPresent()) {
			_771Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	public ResponseEntity<?> updateData(int id, sheet771DAO Data) throws ResourceNotFoundException {

	//	validate(Data);
		
		Optional<sheet771DAO> DataDb = _771Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet771DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setAccruedInterestUnpaid(Data.getAccruedInterestUnpaid());
			DataUpdate.setAmountGranted(Data.getAmountGranted());
			DataUpdate.setCustomerCode(Data.getCustomerCode());
			DataUpdate.setCustomerName(Data.getCustomerName());
			DataUpdate.setLastRepaymentDate(Data.getLastRepaymentDate());
			DataUpdate.setNintyOneToModeDays(Data.getNintyOneToModeDays());
			DataUpdate.setOneToThirtyDays(Data.getOneToThirtyDays());
			DataUpdate.setPastDueDate(Data.getPastDueDate());
			DataUpdate.setPrincipalPaymentDueUnpaid(Data.getPrincipalPaymentDueUnpaid());
			DataUpdate.setRemarks(Data.getRemarks());
			DataUpdate.setSixyOneToNintyDays(Data.getSixyOneToNintyDays());
			DataUpdate.setThirtyOneToSixtyDays(Data.getThirtyOneToSixtyDays());
			DataUpdate.setTotalNonPerformingCredit(Data.getTotalNonPerformingCredit());
			_771Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS771Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public Boolean writesheet771(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
			EncryptedDocumentException, InvalidFormatException, ParseException {
	
		ArrayList<sheet771DAO> sheetdata = new ArrayList<>();
		
		sheetdata = (ArrayList<sheet771DAO>) _771Repository.findAll();
		
		List<List<Object>> listofLists = new ArrayList<List<Object>>();
		
		for (int i = 0; i<sheetdata.size(); i++) {
			
			ArrayList<Object> data = new ArrayList<>();
			
			data.add(sheetdata.get(i).getCustomerCode());
			data.add(sheetdata.get(i).getCustomerName());
			data.add(sheetdata.get(i).getPastDueDate());
			data.add(sheetdata.get(i).getLastRepaymentDate());
			data.add(sheetdata.get(i).getAmountGranted());
			data.add(sheetdata.get(i).getPrincipalPaymentDueUnpaid());
			data.add(sheetdata.get(i).getAccruedInterestUnpaid());
//			data.add(sheetdata.get(i).getTotalNonPerformingCredit());
			data.add(sheetdata.get(i).getOneToThirtyDays());
			data.add(sheetdata.get(i).getThirtyOneToSixtyDays());
			data.add(sheetdata.get(i).getSixyOneToNintyDays());
			data.add(sheetdata.get(i).getNintyOneToModeDays());
			data.add(sheetdata.get(i).getRemarks());
			
			listofLists.add(data);
			
			System.out.println(">>>>>>>" +listofLists);
		
		}
		
		Boolean status = sheet771Util.writeSpecificList(listofLists, Date, folderPath);
		
		if (status == true) {
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
