package com.efass.sheet.mmfbr312;

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

import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr312.sheet312Repository;
import com.efass.specials.DateConverter;
import com.efass.specials.SpecialData;



@Service
public class sheet312_Util {

	
	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet312Repository _312Repo;
	
	@Autowired
	DateConverter convert;

	
	SpecialData specialData = new SpecialData();
	
	
	
	
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
			List<Object> listAtI = listOfLists.get(i);
			
			
			String bankCode = (String) listAtI.get(0);
			String bankName = (String) listAtI.get(1);
			String rate = (String) listAtI.get(2);
			String tenor = (String) listAtI.get(3);
			String _effectiveDate = (String) listAtI.get(4);
			
			String _maturityDate = (String) listAtI.get(5);
			
	
			String effectiveDate =convert.changeDateToGregorian2(_effectiveDate, "dd/mm/yyyy");  
			
			String maturityDate =convert.changeDateToGregorian2(_maturityDate, "dd/mm/yyyy");  
	
			int amount = Integer.parseInt(listAtI.get(6).toString());
		
			
			Sheet worksheet = wb.getSheet("312");
			// declare a Cell object

			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(7);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);

			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(6);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(maturityDate);

			Cell cell3 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell3 = worksheet.getRow(rowNum).getCell(5);
			// Get current cell value value and overwrite the value
			cell3.setCellValue(effectiveDate);
			
			
			
			Cell cell4 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell4 = worksheet.getRow(rowNum).getCell(4);
			// Get current cell value value and overwrite the value
			cell4.setCellValue(tenor);
			
			
			
			Cell cell5 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell5 = worksheet.getRow(rowNum).getCell(3);
			// Get current cell value value and overwrite the value
			cell5.setCellValue(rate);
			
			Cell cell6 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell6 = worksheet.getRow(rowNum).getCell(1);
			// Get current cell value value and overwrite the value
			cell6.setCellValue(bankName);
			
			
			
			
			Cell cell7 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell7 = worksheet.getRow(rowNum).getCell(0);
			// Get current cell value value and overwrite the value
			cell7.setCellValue(bankCode);
			
			
			Cell cell01 = null;
			cell01 = worksheet.getRow(34).getCell(7);
			String formula= "SUM(H13:H34)";
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
			System.out.println("sheet 312 works");

			rowNum++;
		}

		return true;
	}
	
	
}
