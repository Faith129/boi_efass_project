package com.efass.sheet.mmfbr501;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.sheet.mmfbr501.sheet501DAO;

public interface sheet501_Service {
	
	

	 public ResponseEntity<?> createData(sheet501DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet501DAO Data) throws ResourceNotFoundException;
		

}
