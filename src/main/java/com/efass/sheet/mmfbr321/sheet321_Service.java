package com.efass.sheet.mmfbr321;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mmfbr311.sheet311DAO;

public interface sheet321_Service {

	public ResponseEntity<?> createData(sheet321DAO data);

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet321DAO Data) throws ResourceNotFoundException;
	
}
