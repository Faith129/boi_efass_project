package com.efass.sheet.mmfbr202;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet202_Service {

	 public ResponseEntity<?> createData(sheet202DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet202DAO Data) throws ResourceNotFoundException;
		
		//public Boolean writesheet202(LocalDate Date, String folderPath)
			//	throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException ;
		
}
