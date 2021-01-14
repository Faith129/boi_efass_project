package com.efass.sheet.mmfbr221;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;

import com.efass.exceptions.ResourceNotFoundException;

public interface sheet221_Service {
	
	public ResponseEntity<?> createData(sheet221DAO data);

	public ResponseEntity<?> fetchAllData();

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException;

	public ResponseEntity<?> updateData(int id , sheet221DAO Data) throws ResourceNotFoundException;

	public void updateSheetList(List<List<Object>> listOfLists)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;

	public Boolean writesheet221()
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;

}
