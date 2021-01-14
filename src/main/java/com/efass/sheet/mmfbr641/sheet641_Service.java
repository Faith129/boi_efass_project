package com.efass.sheet.mmfbr641;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet641_Service {

	
	
	 public ResponseEntity<?> createData(sheet641DAO data);
	 
	 
		public ResponseEntity<?> fetchAllData();
		
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		
		
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		
		public ResponseEntity<?> updateData(int id , sheet641DAO Data) throws ResourceNotFoundException;
		
}
