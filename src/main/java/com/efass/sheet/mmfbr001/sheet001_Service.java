package com.efass.sheet.mmfbr001;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mmfbr1000.sheet1000DAO;

public interface sheet001_Service {
	
	public ResponseEntity<?> fetchAllData();
	public ResponseEntity<?> updateData(int id, sheet001DAO Data) throws ResourceNotFoundException;


	public String writesheet001(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
	EncryptedDocumentException, InvalidFormatException, ParseException ;
}



