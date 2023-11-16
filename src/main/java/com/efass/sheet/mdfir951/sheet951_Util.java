package com.efass.sheet.mmfbr951;

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
import com.efass.specials.SpecialData;



@Service
public class sheet951_Util {

	
	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet951Repository _651Repo;

	
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
			
			int serial = i;
			
			String Item = (String) listAtI.get(0);	
			int amount = Integer.parseInt(listAtI.get(1).toString());
		
			
	
		
		
			
			Sheet worksheet = wb.getSheet("951");
			// declare a Cell object

			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(0);
			// Get current cell value value and overwrite the value
			cell.setCellValue(serial);

			Cell cell1 = null;
			// Access the second cell in second row to update the value
			cell1 = worksheet.getRow(rowNum).getCell(1);
			// Get current cell value value and overwrite the value
			cell1.setCellValue(Item);

			Cell cell2 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(3);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(amount);
			
			
			Cell cell01 = null;
			cell01 = worksheet.getRow(23).getCell(3);
			String formula= "SUM(D13:D23)";
			cell01.setCellType(CellType.FORMULA);
			cell01.setCellFormula(formula);
			
//			Cell cell02 = null;
//			cell02 = worksheet.getRow(46).getCell(3);
//			String formula2= "SUM(D12:D46)";
//			cell02.setCellType(CellType.FORMULA);
//			cell02.setCellFormula(formula2);
//		

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
			System.out.println("sheet 651 works");

			rowNum++;
		}

		return true;
	}
	
	
}
