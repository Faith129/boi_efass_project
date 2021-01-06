package com.efass.sheet.mmfbr221;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sheet221_impl implements sheet221_Service {

	
	@Autowired
	sheet221Repository _221Repository;

	sheet221_Util _221util = new sheet221_Util(); 
	


	@Override
	public void updateSheetList(List<List<Object>> listOfLists)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		_221util.writeSpecificList(listOfLists);
		
	}



	@Override
	public Boolean writesheet221()
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		Iterable<sheet221DAO> _221Data= _221Repository.findAll();
		
		System.out.println("reacvdfgfb");
		return null;
	}



	
	
	
	
	
	
	
	
	
	
		

}
