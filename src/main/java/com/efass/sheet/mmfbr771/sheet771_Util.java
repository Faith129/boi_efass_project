package com.efass.sheet.mmfbr771;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr321.sheet321Repository;
import com.efass.specials.SpecialData;

@Service
public class sheet771_Util {
	
	
	@Autowired
	 static ReportRepository ReportRepo ;


	@Autowired
	 static sheet771Repository _771Repo;
	
	SpecialData specialData = new SpecialData();
	
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		
		
			System.out.print ("inside 771");
    		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
			SpecialData sb = new SpecialData();
			sb.setChildFolderPath(Path);
			
		

		// Read the spreadsheet that needs to be updated
			FileInputStream fsIP = new FileInputStream(new File(Path));
			// Access the workbook
			Workbook wb = WorkbookFactory.create(fsIP);
			// Access the worksheet, so that we can update / modify it.
			System.out.print("inside 771 2");
			int rowNum = 19;
			
			System.out.println(">>>>>>>>>"+listOfLists.size());
			
				for (int i = 0; i < listOfLists.size(); i++) {
      				System.out.print("inside 771 3");
				List<Object> listAtI = listOfLists.get(i);
				
				String remark = (String) listAtI.get(12);
				String ninetyOnedays = (String) listAtI.get(11);
				String sixtyOneNinety = (String) listAtI.get(10);
				String thirtyOneSix = (String) listAtI.get(9);
				String oneThirty = (String) listAtI.get(8);
				String thotNonPerfCred = (String) listAtI.get(7);
				String accruedIntUnpaid = (String) listAtI.get(6);
				String prinPaymentDueUnpaid = (String) listAtI.get(5);
				String amountGranted = (String) listAtI.get(4);
				String _lastRepaymentDate = (String) listAtI.get(3);
				String _pastDueDate = (String) listAtI.get(2);
				String customerName = (String) listAtI.get(1);
				String customerCode = (String) listAtI.get(0);
				

			    System.out.println(_lastRepaymentDate);
		
			    
			    
			    
			    
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
			    
			    String sDate0=_lastRepaymentDate;
			    Date lastRepaymentDate1=new SimpleDateFormat("yyyy/MM/dd").parse(sDate0);
			   
			    
			    String sDate1 =_pastDueDate;
			    Date pastDueDate1=new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
			   
			   
			   
				
				Sheet worksheet = wb.getSheet("771");
				// declare a Cell object

				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(rowNum).getCell(13);
				// Get current cell value value and overwrite the value
				cell.setCellValue(remark);

				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(rowNum).getCell(12);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(ninetyOnedays);

				Cell cell3 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell3 = worksheet.getRow(rowNum).getCell(11);
				// Get current cell value value and overwrite the value
				cell3.setCellValue(sixtyOneNinety);
				
				
				
				Cell cell4 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell4 = worksheet.getRow(rowNum).getCell(10);
				// Get current cell value value and overwrite the value
				cell4.setCellValue(thirtyOneSix);
				
				
				
				Cell cell5 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell5 = worksheet.getRow(rowNum).getCell(9);
				// Get current cell value value and overwrite the value
				cell5.setCellValue(oneThirty);
				
				

				
				Cell cell6 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell6 = worksheet.getRow(rowNum).getCell(8);
				// Get current cell value value and overwrite the value
				cell6.setCellValue(thotNonPerfCred);
				
				Cell cell7 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell7 = worksheet.getRow(rowNum).getCell(7);
				// Get current cell value value and overwrite the value
				
				
				Cell cell8 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell8 = worksheet.getRow(rowNum).getCell(6);
				// Get current cell value value and overwrite the value
				cell8.setCellValue(prinPaymentDueUnpaid);
				
				
				Cell cell9 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell9 = worksheet.getRow(rowNum).getCell(5);
				// Get current cell value value and overwrite the value
				cell9.setCellValue(amountGranted);
				
				
				Cell cell10 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell10 = worksheet.getRow(rowNum).getCell(4);
				// Get current cell value value and overwrite the value
				
				cell10.setCellValue(lastRepaymentDate1);
				cell10.setCellStyle(cellStyle);
				
				
				Cell cell11 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell11 = worksheet.getRow(rowNum).getCell(3);
				// Get current cell value value and overwrite the value
				cell11.setCellValue(pastDueDate1);
				cell11.setCellStyle(cellStyle);
				
				
				Cell cell12 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell12 = worksheet.getRow(rowNum).getCell(2);
				// Get current cell value value and overwrite the value
				cell12.setCellValue(customerName);
				
				
				Cell cell13 = null;
				// int cellNum3 =cellNum-3;
				cell13 = worksheet.getRow(rowNum).getCell(1);
				// Get current cell value value and overwrite the value
				cell13.setCellValue(customerCode);
				
				
				
				

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
	
	public String getFolderPathWithDate(LocalDate date) {

		ReportDAO Data = ReportRepo.findByPathDate(date.toString());
		String folderPath = Data.getFile_path();

		System.out.println("Folder Path:" + folderPath);
		return folderPath;
	}

}


