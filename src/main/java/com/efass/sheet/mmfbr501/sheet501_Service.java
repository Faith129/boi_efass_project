package com.efass.sheet.mmfbr501;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mmfbr501.sheet501DAO;

public interface sheet501_Service {
	
	

	 public ResponseEntity<?> createData(sheet501DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet501DAO Data) throws ResourceNotFoundException;
	
		
		public Boolean writesheet501(LocalDate Date, String folderPath) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException;
		

}
