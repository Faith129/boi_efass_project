package com.efass.sheet.mmfbr1000;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet1000_Service {
	
	public ResponseEntity<?> fetchAllData();
	
	public ResponseEntity<?> updateData(String code, sheet1000DAO Data) throws ResourceNotFoundException;

}
