package com.efass.sheet.mmfbr642;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet642_Service {

	
	 public ResponseEntity<?> createData(sheet642DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet642DAO Data) throws ResourceNotFoundException;
		
}
