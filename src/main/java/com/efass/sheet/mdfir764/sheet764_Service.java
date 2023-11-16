package com.efass.sheet.mmfbr764;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet764_Service {

	 public ResponseEntity<?> createData(sheet764DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet764DAO Data) throws ResourceNotFoundException;
		public Boolean writesheet764(LocalDate Date, String folderPath) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException;
		
}
