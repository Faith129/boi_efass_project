package com.efass.sheet.mmfbr763;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr311.sheet311Repository;
import com.efass.specials.SpecialData;
import com.efass.specials.SpecialFunction;


@Service
public class sheet763_Util {

	
	@Autowired
	 static ReportRepository ReportRepo ;


	@Autowired
	 static sheet763Repository _763Repo;

	
	SpecialData specialData = new SpecialData();
	
	
	
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {


		
		
	

	
		
		
		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
		SpecialData sb = new SpecialData();
		sb.setChildFolderPath(Path);
		
	

		// Read the spreadsheet that needs to be updated
		FileInputStream fsIP = new FileInputStream(new File(Path));
		// Access the workbook
		Workbook wb = WorkbookFactory.create(fsIP);
		// Access the worksheet, so that we can update / modify it.

		int rowNum = 13;
		for (int i = 0; i < listOfLists.size(); i++) {
			
			List<Object> listAtI = listOfLists.get(i);
			
			
			int onetoThirty = Integer.parseInt(listAtI.get(0).toString());
			
			int thirty0netoSixty = Integer.parseInt(listAtI.get(1).toString());
			
			int sixtyOnetoNinety = Integer.parseInt(listAtI.get(2).toString());
			
			int ninetyOnetoOneEighty = Integer.parseInt(listAtI.get(3).toString());
			
			int OneEightyOnetoThreeSixty = Integer.parseInt(listAtI.get(4).toString());
			
			int aboveThreeSixty = Integer.parseInt(listAtI.get(5).toString());

			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>This is after cast" +listOfLists.size());
			
			Sheet worksheet = wb.getSheet("763");
			// declare a Cell object

			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(7);
			// Get current cell value value and overwrite the value
			cell.setCellValue(aboveThreeSixty);

			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(6);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(OneEightyOnetoThreeSixty);

			Cell cell3 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell3 = worksheet.getRow(rowNum).getCell(5);
			// Get current cell value value and overwrite the value
			cell3.setCellValue(ninetyOnetoOneEighty);
			
			
			
			Cell cell4 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell4 = worksheet.getRow(rowNum).getCell(4);
			// Get current cell value value and overwrite the value
			cell4.setCellValue(sixtyOnetoNinety);
			
			
			
			Cell cell5 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell5 = worksheet.getRow(rowNum).getCell(3);
			// Get current cell value value and overwrite the value
			cell5.setCellValue(thirty0netoSixty);
			
			
			
			
			Cell cell6 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell6 = worksheet.getRow(rowNum).getCell(2);
			// Get current cell value value and overwrite the value
			cell6.setCellValue(onetoThirty);
			
			
			
			

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
			System.out.println("works");

			rowNum++;
		}

		return true;
	}
	
	
}
