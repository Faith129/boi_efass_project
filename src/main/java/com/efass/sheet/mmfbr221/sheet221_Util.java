package com.efass.sheet.mmfbr221;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;


public class sheet221_Util {
	
	//writeSpecific(15,3,419);
	
	
	//Working---------------------------
		public void writeSpecific(int rowNum, int cellNum, int valString)  throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException{
			//Read the spreadsheet that needs to be updated
			FileInputStream fsIP= new FileInputStream(new File(".\\datafiles\\cbn_MFB_rpt_12345m052087.xlsx"));  
			//Access the workbook                  
			//HSSFWorkbook wb = new HSSFWorkbook(fsIP);
		    Workbook wb = WorkbookFactory.create(fsIP);
			//Access the worksheet, so that we can update / modify it. 
		    
		    
		    
		    Sheet worksheet = wb.getSheet("221"); 
			// declare a Cell object
			Cell cell = null; 
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(cellNum);   
			// Get current cell value value and overwrite the value
		//	cell.setCellValue(valString);
			cell.setCellValue((Integer)valString);
			
			
			
			
			
			
			
	
			
			Cell cell2 = null; 
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(16).getCell(3);   
			// Get current cell value value and overwrite the value
		//	cell.setCellValue(valString);
			cell2.setCellValue(800);
			
			
			
			
			//Close the InputStream  
			fsIP.close(); 
			//Open FileOutputStream to write updates
			FileOutputStream output_file =new FileOutputStream(new File(".\\datafiles\\export\\cbn_MFB_rpt_12345m052087.xlsx"));  
			 //write changes
			wb.write(output_file);
			//close the stream
			output_file.close();
			System.out.println("works");
		}
		
		
		
		
		
		
		
		
		
		
		

		public void writeSpecificList(List<List<Object>> listOfLists) throws EncryptedDocumentException, InvalidFormatException, IOException {
			
			//Read the spreadsheet that needs to be updated
			FileInputStream fsIP= new FileInputStream(new File(".\\datafiles\\cbn_MFB_rpt_12345m052087.xlsx"));  
			//Access the workbook                  
		    Workbook wb = WorkbookFactory.create(fsIP);
			//Access the worksheet, so that we can update / modify it. 
		    
		    
			  for(int i = 0; i < listOfLists.size(); i++){
			        List<Object> listAtI = listOfLists.get(i);
			        
			        Excelsheet4_Data data = new Excelsheet4_Data();
			        
			      
			        int rowNum = (int) listAtI.get(0);
			        int cellNum = (int) listAtI.get(1);
			        int amount = (int) listAtI.get(2);
			        String bankName = (String) listAtI.get(3);
			        
			        System.out.println("rowNum ="+rowNum+ "   cellNum="+cellNum+ "  amount="+amount+ " BankName="+ bankName);

			 
			    
			  
			  
		
		    
		    
		    
		    Sheet worksheet = wb.getSheet("221"); 
			// declare a Cell object
		    
		    
	    
		    
			Cell cell = null; 
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(cellNum);   
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);
			
			
			
			Cell cell2 = null; 
			int cellNum2 =cellNum-2;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(cellNum2);   
			// Get current cell value value and overwrite the value
			cell2.setCellValue(bankName);
			
	
		
			
			
			//Close the InputStream  
			fsIP.close(); 
			//Open FileOutputStream to write updates
			FileOutputStream output_file =new FileOutputStream(new File(".\\datafiles\\export\\cbn_MFB_rpt_12345m052087.xlsx"));  
			 //write changes
			wb.write(output_file);
			//close the stream
			output_file.close();
			System.out.println("works");
			  }
		}
			
		}

