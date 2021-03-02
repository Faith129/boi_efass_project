package com.efass.sheet.mmfbr811;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet811_Service {

	
	 public ResponseEntity<?> createData(sheet811DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet811DAO Data) throws ResourceNotFoundException;
		Boolean writesheet811(LocalDate Date, String folderPath)
				throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException;
		
		
}
