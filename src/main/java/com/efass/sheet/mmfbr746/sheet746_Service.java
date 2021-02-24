package com.efass.sheet.mmfbr746;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import com.efass.exceptions.ResourceNotFoundException;


public interface sheet746_Service  {

	
		public ResponseEntity<?> createData(sheet746DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet746DAO Data) throws ResourceNotFoundException;
		
		public Boolean writesheet746 (LocalDate Date, String folderPath) throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException;
}
