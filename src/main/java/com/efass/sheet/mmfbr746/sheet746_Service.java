package com.efass.sheet.mmfbr746;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.efass.exceptions.ResourceNotFoundException;


public interface sheet746_Service  {

	
		public ResponseEntity<?> createData(sheet746DAO data);
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet746DAO Data) throws ResourceNotFoundException;
}
