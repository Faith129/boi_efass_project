package com.efass.sheet.mmfbr311;

import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet311_Service {

	public ResponseEntity<?> createData(sheet311DAO data);

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet311DAO Data) throws ResourceNotFoundException;

}
