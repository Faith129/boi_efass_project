package com.efass.sheet.mmfbr201;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.report.ReportRepository;
import com.efass.specials.SpecialData;

@Service
public class sheet201_Util {

	
	
	@Autowired
	  ReportRepository ReportRepo ;
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate date, String folderPath, String duration) throws EncryptedDocumentException, InvalidFormatException, IOException {
		int rowNum = 0;
		int cellNum= 0;
		if(duration == "1-30 Days") {
			rowNum = 12;
			cellNum= 2;
		}else if (duration == "31-60 Days") {
			rowNum = 12;
			cellNum= 3;
		}else if (duration == "61-90 Days") {
			rowNum = 12;
			cellNum= 4;
		}else if (duration == "91-180 Days") {
			rowNum = 12;
			cellNum= 5;
		}else if (duration == "181-360 Days") {
			rowNum = 12;
			cellNum= 6;
		}else if(duration == "Above 360 Days") {
			rowNum = 12;
			cellNum= 7;
			
		}else {
			return true;
		}
		
		
		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
		SpecialData sb = new SpecialData();
		sb.setChildFolderPath(Path);
		
	

		// Read the spreadsheet that needs to be updated
		FileInputStream fsIP = new FileInputStream(new File(Path));
		// Access the workbook
		Workbook wb = WorkbookFactory.create(fsIP);
		// Access the worksheet, so that we can update / modify it.
		insertFormulas(Path,  wb, fsIP);

		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			String _noOfAccounts =(( listAtI.get(2)== null) ? "0" : listAtI.get(2).toString());
			
			String _amount =(( listAtI.get(3) == null) ? "0" : listAtI.get(3).toString());
			
	
			
			int noOfAccounts = Integer.parseInt(_noOfAccounts);
			int amount = Integer.parseInt(_amount);
		
			String emptyValue = "";
			
		
	
		
		
			
			Sheet worksheet = wb.getSheet("201");
			// declare a Cell object

				
			
		

			
			
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(cellNum);
			// Get current cell value value and overwrite the value
			cell.setCellValue(emptyValue);
			
			
			
			
			
			rowNum = rowNum + 1;
			
			Cell cell1 = null;
			// Access the second cell in second row to update the value
			cell1 = worksheet.getRow(rowNum).getCell(cellNum);
			// Get current cell value value and overwrite the value
			cell1.setCellValue(noOfAccounts);
			
	
			
			

			
			
			rowNum = rowNum + 1;
			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(cellNum);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(amount);

			
			
			
			

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
			System.out.println("sheet 201 works");

			rowNum++;
		}

		return true;
	
	}
	
	
	
	
	
	
	
	
	
	public void insertFormulas(String Path, Workbook wb,FileInputStream fsIP) throws IOException {

		Sheet worksheet = wb.getSheet("201");
		// declare a Cell object
	

		  int i=13;  
		
		    do{  
		
		    	String total_formulaExpression = "SUM(C"+i+":H"+i+")";
				Cell celldiv2 = null;
				celldiv2 = worksheet.getRow(i).getCell(8);
				String formula2= total_formulaExpression;
				celldiv2.setCellType(CellType.FORMULA);
				celldiv2.setCellFormula(formula2);
		        
		        

				// Close the InputStream
				fsIP.close();
				// Open FileOutputStream to write updates


				FileOutputStream output_file = new FileOutputStream(new File(Path));

				wb.write(output_file);
				// close the stream
				output_file.close();
		        
		    i++;  
		    }while(i<=33);  
		 

	

		    
		    
		    
		    
		    
		    int k=13;  
		    int m=32;
			
		    do{  
		    	String percentage_formulaExpression ="I"+k+"/$I"+m+"*100";
		  
				
				Cell celldiv2 = null;
				celldiv2 = worksheet.getRow(k).getCell(9);
				String formula2= percentage_formulaExpression;
				celldiv2.setCellType(CellType.FORMULA);
				celldiv2.setCellFormula(formula2);
		        
		        

				// Close the InputStream
				fsIP.close();
				// Open FileOutputStream to write updates


				FileOutputStream output_file = new FileOutputStream(new File(Path));

				wb.write(output_file);
				// close the stream
				output_file.close();
		       m++; 
		    k++;  
		    }while(k<=33);  
		 
		







		}



}
