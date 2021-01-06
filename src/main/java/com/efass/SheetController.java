package com.efass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.sheet.mmfbr221.sheet221_Service;



@CrossOrigin()
@RestController
@RequestMapping("api/v1")
public class SheetController {

	@Autowired
	sheet221_Service _221Svc;
	

	
	@RequestMapping(value ="/sheet/write/221")
	public String loadData() throws EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException {
		
		
		
		_221Svc.writesheet221();
		
		
		
//		ArrayList<Object> data = new ArrayList<>();
//		data.add(15);
//		data.add(3);
//		data.add(80000);
//		data.add("Telle Bank");
//		
//		
//		ArrayList<Object> data2 = new ArrayList<>();
//		data2.add(16);
//		data2.add(3);
//		data2.add(70000);
//		data2.add("James Bank");
//		
//		
//		
//		
//			
//		List<List<Object>> listOfLists = new ArrayList <List<Object>>();
//		listOfLists.add(data);
//		listOfLists.add(data2);
//		sheet4Svc.updateSheetList(listOfLists);

		return "success";
		
	}
	
	
 
}
