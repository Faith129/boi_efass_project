package com.efass.sheet.mmfbr312;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet312_Service {

	
	 public ResponseEntity<?> createData(sheet312DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet312DAO Data) throws ResourceNotFoundException;
		
		public Boolean writesheet312 (LocalDate Date, String folderPath) throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException;
		
}
