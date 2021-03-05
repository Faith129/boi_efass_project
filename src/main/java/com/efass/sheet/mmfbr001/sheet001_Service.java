package com.efass.sheet.mmfbr001;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet001_Service {
	
	public ResponseEntity<?> fetchAllData();
	public ResponseEntity<?> updateData(int id, sheet001DAO Data) throws ResourceNotFoundException;
}



