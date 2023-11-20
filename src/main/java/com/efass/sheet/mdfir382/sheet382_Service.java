package com.efass.sheet.mdfir382;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface sheet382_Service {
	 public ResponseEntity<?> createData(sheet382DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllData();
		public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateData(int id , sheet382DAO Data) throws ResourceNotFoundException;
		public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date) throws ResourceNotFoundException;

		public ResponseEntity<?> createDataQ(sheetQdfir382DAO data) throws ResourceNotFoundException;
		public ResponseEntity<?> fetchAllDataQ();
		public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException;
		public ResponseEntity<?> updateDataQ(int id , sheetQdfir382DAO Data) throws ResourceNotFoundException;
    void saveSheet382ToDataBase(MultipartFile file, String sheetNo);

}
