package com.efass.sheet.mmfbr951;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet951_Service {

	 public ResponseEntity<?> createData(sheet951DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet951DAO Data) throws ResourceNotFoundException;
		
}
