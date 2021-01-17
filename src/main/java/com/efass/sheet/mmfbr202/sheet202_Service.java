package com.efass.sheet.mmfbr202;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet202_Service {

	 public ResponseEntity<?> createData(sheet202DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet202DAO Data) throws ResourceNotFoundException;
		
		
}
