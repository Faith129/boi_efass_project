

package com.efass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.model.ThemesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.payload.Response;
import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.report.ReportService;
import com.efass.sheet.mmfbr001.sheet001_Service;
import com.efass.sheet.mmfbr1000.sheet1000_Service;
import com.efass.sheet.mmfbr141.sheet141_Service;
import com.efass.sheet.mmfbr201.sheet201_Service;
import com.efass.sheet.mmfbr202.sheet202_Service;
import com.efass.sheet.mmfbr221.sheet221_Service;
import com.efass.sheet.mmfbr300.sheet300_Service;
import com.efass.sheet.mmfbr311.sheet311_Service;
import com.efass.sheet.mmfbr312.sheet312_Service;
import com.efass.sheet.mmfbr321.sheet321_Service;
import com.efass.sheet.mmfbr322.sheet322_Service;
import com.efass.sheet.mmfbr451.sheet451_Service;
import com.efass.sheet.mmfbr501.sheet501_Service;
import com.efass.sheet.mmfbr641.sheet641_Service;
import com.efass.sheet.mmfbr642.sheet642_Service;
import com.efass.sheet.mmfbr651.sheet651_Service;
import com.efass.sheet.mmfbr711.sheet711_Service;
import com.efass.sheet.mmfbr746.sheet746_Service;
import com.efass.sheet.mmfbr761.sheet761_Service;
import com.efass.sheet.mmfbr762.sheet762_Service;
import com.efass.sheet.mmfbr763.sheet763_Service;
import com.efass.sheet.mmfbr764.sheet764_Service;
import com.efass.sheet.mmfbr771.sheet771_Service;
import com.efass.sheet.mmfbr811.sheet811_Service;
import com.efass.sheet.mmfbr933.sheet933_Service;
import com.efass.sheet.mmfbr951.sheet951_Service;
import com.efass.sheet.mmfbr980.sheet980_Service;
import com.efass.sheet.mmfbr996.sheet996_Service;
import com.efass.sheet.table.TableService;
import com.efass.specials.SpecialData;
import com.efass.specials.SpecialFunction;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class SheetController {

	@Autowired
	private sheet221_Service sheet221Svc;
	@Autowired
	private sheet311_Service sheet311Svc;
	@Autowired
	private sheet641_Service sheet641Svc;

	@Autowired
	private sheet321_Service sheet321Svc;

	@Autowired
	private sheet711_Service sheet711Svc;

	@Autowired
	private sheet746_Service sheet746Svc;

	@Autowired
	private sheet761_Service sheet761Svc;

	@Autowired
	private sheet771_Service sheet771Svc;

	@Autowired
	private sheet762_Service sheet762Svc;

	@Autowired
	private sheet811_Service sheet811Svc;

	@Autowired
	private sheet141_Service sheet141Svc;

	@Autowired
	private sheet201_Service sheet201Svc;

	@Autowired
	private sheet202_Service sheet202Svc;

	@Autowired
	private sheet312_Service sheet312Svc;

	@Autowired
	private sheet322_Service sheet322Svc;

	@Autowired
	private sheet451_Service sheet451Svc;

	@Autowired
	private TableService tableSvc;

	@Autowired
	private sheet763_Service sheet763Svc;

	@Autowired
	private sheet764_Service sheet764Svc;

	@Autowired
	private sheet501_Service sheet501Svc;

	@Autowired
	private sheet642_Service sheet642Svc;

	@Autowired
	private sheet651_Service sheet651Svc;

	@Autowired
	private sheet933_Service sheet933Svc;

	@Autowired
	private sheet951_Service sheet951Svc;

	@Autowired
	private sheet996_Service sheet996Svc;

	@Autowired
	private sheet980_Service sheet980Svc;
	
	@Autowired
	private sheet1000_Service sheet1000Svc;

	
	@Autowired
	private sheet300_Service sheet300Svc;
	
	@Autowired
	private sheet001_Service sheet001Svc;
	
	
	@Autowired
	private ReportService reportSvc;
	
	@Autowired
	private ReportRepository reportRepo;
	
	


	Response res = new Response();

	@RequestMapping(value = "/generate/{date}/{fileId}")
	public ResponseEntity<?> loadData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable int fileId)
			throws EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException, ParseException, Throwable {

		// Generation for Sheet 221
		Boolean evt = reportSvc.checkByFileId(fileId);
		Boolean status = null;

		if (evt == true) {
			

			// Clock with the system's default timezone
			long time = System.currentTimeMillis();
			String _time =String.valueOf(time);
			
			
			//Generate Folder with unique reference Number
			SpecialFunction sp = new SpecialFunction();
			String folderPath = sp.createFolderDirectory(date.toString(), _time);
			
//			SpecialData sd = new SpecialData();
//			sd.setFolderPath(folderPath);
	
			


			
			//Write On Excel Sheets
//        sheet300Svc.writesheet300(date, folderPath);  not working **************

//works			sheet980Svc.writesheet980(date, folderPath);
			
			
//        sheet501Svc.writesheet501(date, folderPath);
			




			

//			Date Format not working
			
//			 sheet762Svc.writesheet762(date, folderPath);   // not computing excel check rules nd percentage column not computing
			
//			 sheet763Svc.writesheet763(date, folderPath);   //	sheet works !!! procedure error Percentage calculation & check rules      	
//			 sheet201Svc.writesheet201(date, folderPath); 	 //sheet works !!! procedure error Percentage calculation & check rules
					
			 sheet202Svc.writesheet202(date, folderPath); 	 //********Missing Utils
					
		        
//			 sheet1000Svc.writesheet1000(date, folderPath);  //sheet works !!!  computation error
			 
			 
//	************************************************************************************************		
			 sheet764Svc.writesheet764(date, folderPath); 	//sheet works !!!
//			sheet321Svc.writesheet321(date,folderPath);  	//sheet works !!!		
		
//			sheet312Svc.writesheet312(date, folderPath);  	//sheet works !!!			
//			sheet501Svc.writesheet501(date, folderPath);  	//sheet works !!!
	
//			sheet221Svc.writesheet221(date,folderPath);		//sheet works !!!
//			sheet311Svc.writesheet311(date,folderPath);		//sheet works !!!
//			sheet711Svc.writesheet711(date,folderPath); 	//sheet works !!!
//			sheet321Svc.writesheet321(date,folderPath); 	//sheet works !!!
//		    sheet746Svc.writesheet746(date, folderPath);   	//sheet works !!!
//			sheet641Svc.writesheet641(date,folderPath);		//sheet works !!!
//			sheet141Svc.writesheet141(date, folderPath); 	//sheet works !!!
//			sheet322Svc.writesheet322(date, folderPath);	//sheet works !!!
	
//			sheet451Svc.writesheet451(date, folderPath);	//sheet works !!!
//			sheet642Svc.writesheet642(date,folderPath);		//sheet works !!!
//			sheet651Svc.writesheet651(date, folderPath);	//sheet works !!!
//			sheet951Svc.writesheet951(date, folderPath);	//sheet works !!!
//			sheet996Svc.writesheet996(date, folderPath);	//sheet works !!!
//			sheet933Svc.writesheet933(date, folderPath);	//sheet works !!!
//			sheet811Svc.writesheet811(date, folderPath); 	//sheet works !!!					
//			sheet761Svc.writesheet761(date, folderPath);  	//sheet works !!!




			
	        String path=sheet001Svc.writesheet001(date, folderPath);     
	        


	        String pattern = "dd-MM-yyyy";
			String dateInString =new SimpleDateFormat(pattern).format(new Date());
			
	        String filename = "file~"+ dateInString +"~"+_time;
	        reportSvc.saveReportActivity(date.toString(),path, filename, fileId);;
	        
	        
	
	        
			status = true;
		} else if (evt == false) {
		
			return reportSvc.NoDateFound();
		}


		try {reportRepo.deleteByStatus("none");}catch(Exception ex) {
			
		}
		if (status == true) {
			
			res.setResponseMessage("Sheet  Updated");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} else {
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

