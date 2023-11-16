package com.efass.sheet.mdfir400_14;

import com.efass.exceptions.ResourceNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

public interface sheet400_14_Service{
	 public ResponseEntity<?> createData(sheet400_14DAO data) throws ResourceNotFoundException;
	 public ResponseEntity<?> createDataQ(sheetQdfir400_14DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet400_14DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir400_14DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

}
