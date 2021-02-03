package com.efass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.payload.Response;
import com.efass.report.ReportService;
import com.efass.sheet.mmfbr221.sheet221_Service;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class SheetController {

	@Autowired
	sheet221_Service _221Svc;
	
	@Autowired
	private ReportService reportSvc;
	
	Response res = new Response();
	
	@RequestMapping(value ="/generate/{date}")
	public ResponseEntity<?> loadData( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException {
		
		
	
		
		
		//Generation for Sheet 221
		Boolean evt = reportSvc.checkDate(date);
		Boolean status ;
		if(evt== true) {
			 status = _221Svc.writesheet221(date);
		}else {
			return reportSvc.NoDateFound();
		}
		
		
		
		
		//Create a Subfolder
		
		//Store Subfolder in db 
		
		
		
		

		
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
