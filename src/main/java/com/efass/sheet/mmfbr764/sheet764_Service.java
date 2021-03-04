package com.efass.sheet.mmfbr764;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet764_Service {

	 public ResponseEntity<?> createData(sheet764DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet764DAO Data) throws ResourceNotFoundException;
		
}
