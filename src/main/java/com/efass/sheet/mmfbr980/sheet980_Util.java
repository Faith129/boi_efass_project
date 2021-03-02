package com.efass.sheet.mmfbr980;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.report.ReportRepository;
import com.efass.specials.SpecialData;

@Service
public class sheet980_Util {

	@Autowired
	  ReportRepository ReportRepo ;
	
	
	
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		
		
	
    		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
			SpecialData sb = new SpecialData();
			sb.setChildFolderPath(Path);
			
		

		// Read the spreadsheet that needs to be updated
			FileInputStream fsIP = new FileInputStream(new File(Path));
			// Access the workbook
			Workbook wb = WorkbookFactory.create(fsIP);
			// Access the worksheet, so that we can update / modify it.
	
			int rowNum = 12;
			
		
			
				for (int i = 0; i < listOfLists.size(); i++) {
					
					
					
					
//					data.add(sheetdata.get(i).getItems());
//					data.add(sheetdata.get(i).getOne_to_30_days());
//					data.add(sheetdata.get(i).getThirty_one_to_60_days());
//					data.add(sheetdata.get(i).getSixty_one_to_90_days());
//					data.add(sheetdata.get(i).getNinety_one_to_180_days());
//					data.add(sheetdata.get(i).getOne_eighty_one_to_360_days());
//					
					
					
      
				List<Object> listAtI = listOfLists.get(i);
				
				
				
				String _1 =(( listAtI.get(1)== null) ? "0" : listAtI.get(1).toString());
				
				String _2 =(( listAtI.get(2) == null) ? "0" : listAtI.get(2).toString());
				
				String _3 =(( listAtI.get(3) == null) ? "0" : listAtI.get(3).toString());
				
				String _4 =(( listAtI.get(4) == null) ? "0" : listAtI.get(4).toString());
				String _5 =(( listAtI.get(5) == null) ? "0" : listAtI.get(5).toString());
				
				String _6 =(( listAtI.get(6) == null) ? "0" : listAtI.get(6).toString());
				
			
				
				
				
		
			    
			    
			    
			    
			   CellStyle cellStyle = wb.createCellStyle();
			   CreationHelper createHelper = wb.getCreationHelper();
			   cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/mm/dd"));
//			   Date lastRepayment = new SimpleDateFormat("yyyy/MM/dd").parse(_lastRepaymentDate);
//			   Date pastDueDate = new SimpleDateFormat("yyyy/MM/dd").parse(_pastDueDate);
			   
			 
			   
//			   String startDateString = "08-12-2017";
//			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//			    
//			    String lastRepaymentDate = LocalDate.parse(_lastRepaymentDate, formatter).format(formatter2);
//			    String pastDueDate = LocalDate.parse(_pastDueDate, formatter).format(formatter2);
			 
			   
			   
			   
				
				Sheet worksheet = wb.getSheet("771");
				// declare a Cell object

			
				
//				
//				Cell cell13 = null;
//				// int cellNum3 =cellNum-3;
//				cell13 = worksheet.getRow(rowNum).getCell(1);
//				// Get current cell value value and overwrite the value
//				cell13.setCellValue(customerCode);
				
				
				
				

				// Close the InputStream
				fsIP.close();
				// Open FileOutputStream to write updates

				
				FileOutputStream output_file = new FileOutputStream(new File(Path));
				// FileOutputStream output_file =new FileOutputStream(new
				// File(".\\datafiles\\export\\cbn_MFB_rpt_12345m052087.xlsx"));
				// write changes
				wb.write(output_file);
				// close the stream
				output_file.close();
				System.out.println("sheet 771works");

				rowNum++;
			}

			return true;
		}
}
