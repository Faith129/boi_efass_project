package com.efass.sheet.mmfbr201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet201_Service {
	 public ResponseEntity<?> createData(sheet201DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet201DAO Data) throws ResourceNotFoundException;
		Boolean writesheet201(LocalDate Date, String folderPath)
				throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;
		
}
