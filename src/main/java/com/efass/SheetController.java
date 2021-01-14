package com.efass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.payload.Response;
import com.efass.sheet.mmfbr221.sheet221_Service;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class SheetController {

	@Autowired
	sheet221_Service _221Svc;
	
	Response res = new Response();
	
	@RequestMapping(value ="/sheet/write/221")
	public ResponseEntity<?> loadData() throws EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException {
		
		
		
		Boolean status = _221Svc.writesheet221();
		
		if(status == true) {
			res.setResponseMessage("Sheet 221 Updated");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}else {
			res.setResponseMessage("Failed");
			res.setResponseCode(-1001);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
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

		
		
	}
	
	
 
}
