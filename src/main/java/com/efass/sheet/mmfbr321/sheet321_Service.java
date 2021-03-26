package com.efass.sheet.mmfbr321;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr312.sheet312DAO;

public interface sheet321_Service {

	public ResponseEntity<?> createData(sheet321DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet312DAO Data) throws ResourceNotFoundException, ParseException;


	public Boolean writesheet321(LocalDate Date, String folderPath)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, ParseException;
	
}
