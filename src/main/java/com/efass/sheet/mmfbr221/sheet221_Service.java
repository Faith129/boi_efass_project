package com.efass.sheet.mmfbr221;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface sheet221_Service {

	

	
	
	public void updateSheetList(List<List<Object>> listOfLists )  throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;
	
	
	
	public Boolean writesheet221()throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException;
	
	
}
