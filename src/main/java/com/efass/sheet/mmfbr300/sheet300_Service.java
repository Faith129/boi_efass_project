package com.efass.sheet.mmfbr300;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;


public interface sheet300_Service {

		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(String code , sheet300DAO Data) throws ResourceNotFoundException;
				
	
}
