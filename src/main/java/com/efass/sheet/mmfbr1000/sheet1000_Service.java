package com.efass.sheet.mmfbr1000;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet1000_Service {
	
	public ResponseEntity<?> fetchAllData();
	
	public ResponseEntity<?> updateData(String code, sheet1000DAO Data) throws ResourceNotFoundException;
	public Boolean writesheet1000(LocalDate Date, String folderPath) throws FileNotFoundException, IOException,
	EncryptedDocumentException, InvalidFormatException, ParseException;
	
	
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;



}
