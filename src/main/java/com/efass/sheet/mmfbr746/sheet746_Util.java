package com.efass.sheet.mmfbr746;

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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr321.sheet321Repository;
import com.efass.specials.DateConverter;
import com.efass.specials.SpecialData;

@Service
public class sheet746_Util {
	
	
	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet746Repository _746Repo;
	
	@Autowired
	DateConverter convert;
	
	SpecialData specialData = new SpecialData();
	
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		
		
			System.out.print ("inside 746");
    		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
			SpecialData sb = new SpecialData();
			sb.setChildFolderPath(Path);
			
		

		// Read the spreadsheet that needs to be updated
			FileInputStream fsIP = new FileInputStream(new File(Path));
			// Access the workbook
			Workbook wb = WorkbookFactory.create(fsIP);
			// Access the worksheet, so that we can update / modify it.
			System.out.print("inside 746 2");
			int rowNum = 17;
			
			System.out.println(">>>>>>>>>"+listOfLists.size());
			
				for (int i = 0; i < listOfLists.size(); i++) {
      				System.out.print("inside 746 3");
				List<Object> listAtI = listOfLists.get(i);
				
				String nameOfBen = (String) listAtI.get(5);
				String _dateGranted = (String) listAtI.get(4);
				
			    String  dateGranted=convert.changeDateToGregorian2(_dateGranted, "dd/mm/yyyy");  
				
				String tenor = (String) listAtI.get(3);
				int amountApproved =  Integer.parseInt(listAtI.get(2).toString());
				int outstandingBal = Integer.parseInt(listAtI.get(1).toString());
				String status = (String) listAtI.get(0);
			
				
				Sheet worksheet = wb.getSheet("746");
				// declare a Cell object

				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(rowNum).getCell(6);
				// Get current cell value value and overwrite the value
				cell.setCellValue(status);

				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(rowNum).getCell(5);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(outstandingBal);

				Cell cell3 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell3 = worksheet.getRow(rowNum).getCell(4);
				// Get current cell value value and overwrite the value
				cell3.setCellValue(amountApproved);
				
				
				
				Cell cell4 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell4 = worksheet.getRow(rowNum).getCell(3);
				// Get current cell value value and overwrite the value
				cell4.setCellValue(tenor);
				
				
				
				Cell cell5 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell5 = worksheet.getRow(rowNum).getCell(2);
				// Get current cell value value and overwrite the value
				cell5.setCellValue(dateGranted);
				
				
				
				
				Cell cell6 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell6 = worksheet.getRow(rowNum).getCell(1);
				// Get current cell value value and overwrite the value
				cell6.setCellValue(nameOfBen);
				
				
				Cell cell01 = null;
				cell01 = worksheet.getRow(15).getCell(5);
				String formula= "SUM(F18:F65536)";
				cell01.setCellType(CellType.FORMULA);
				cell01.setCellFormula(formula);
				
				
				
				
				

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
				System.out.println("sheet 746works");

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


