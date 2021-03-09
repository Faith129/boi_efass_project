package com.efass.sheet.mmfbr300;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.efass.specials.SpecialData;

@Service
public class sheet300_Util {

	
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
			
			
//			String amount = (String) listAtI.get(0);
		
			String amount = ((listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());

			
			int _amount = Integer.parseInt(amount);

			
			
			if(_amount != 0) {
				
			
				
				Sheet worksheet = wb.getSheet("300");
				// declare a Cell object

				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(rowNum).getCell(4);
				// Get current cell value value and overwrite the value
				cell.setCellValue(amount);

				
				
				

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
				System.out.println("sheet 300 works");

				rowNum++;
				
				
			}
		
			
		
		}

		return true;
	}

}
