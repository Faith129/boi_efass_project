package com.efass.sheet.mdfir333;

import com.efass.exceptions.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface sheet333_Service {
	public ResponseEntity<?> createData(sheet333DAO data) throws ResourceNotFoundException;
	public ResponseEntity<?> createDataQ(sheetQdfir333DAO data) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id, sheet333DAO Data) throws ResourceNotFoundException;
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir333DAO Data) throws ResourceNotFoundException;

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;


	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException;
	public void saveSheet333ToDataBase(MultipartFile file, String sheetNo);

}
