package com.efass.sheet.mmfbr711;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet711_Service {

	
	public ResponseEntity<?> createData(sheet711DAO data) ;
	
	public ResponseEntity<?> fetchAllData();
	
	
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
	
	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
	
	
	public ResponseEntity<?> updateData(int id, sheet711DAO Data) throws ResourceNotFoundException;
	
	
}
