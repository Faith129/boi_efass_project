package com.efass.sheet.mmfbr763;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet763_Service {

	 public ResponseEntity<?> createData(sheet763DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet763DAO Data) throws ResourceNotFoundException;
		
		Boolean writesheet763(LocalDate date, String folderPath)
				throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;
		
		
		
}
