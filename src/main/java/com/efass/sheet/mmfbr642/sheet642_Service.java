package com.efass.sheet.mmfbr642;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sun.el.parser.ParseException;

public interface sheet642_Service {

	
	 public ResponseEntity<?> createData(sheet642DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet642DAO Data) throws ResourceNotFoundException;
		
		
//		public boolean writeSheet642(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
//				EncryptedDocumentException, InvalidFormatException, ParseException;
		public boolean writesheet642(LocalDate Date, String folderPath)
				throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException, Throwable;
		
}
