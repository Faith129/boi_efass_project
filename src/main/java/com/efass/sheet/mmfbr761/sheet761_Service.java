package com.efass.sheet.mmfbr761;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet761_Service {

	
	
	 public ResponseEntity<?> createData(sheet761DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet761DAO Data) throws ResourceNotFoundException;
		public Boolean writesheet761(LocalDate Date, String folderPath) 
				throws FileNotFoundException, IOException, EncryptedDocumentException, ParseException, InvalidFormatException;
		
}
