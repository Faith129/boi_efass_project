package com.efass.sheet.mmfbr202;

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

import com.efass.Validation;
import com.efass.specials.SpecialData;

@Service
public class sheet202_Util {

	
	@Autowired
	Validation validation;
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate date, String folderPath) throws EncryptedDocumentException, InvalidFormatException, IOException {



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
				
			
				String typeOfDeposit = (String) listAtI.get(0);
				String _oneToHundredNaira = 	(( listAtI.get(1)== null) ? "0" : listAtI.get(1).toString());
				String _HundredToOneNaira = 	(( listAtI.get(2)== null) ? "0" : listAtI.get(2).toString());
		
				Double __oneToHundredNaira= Double.parseDouble(_oneToHundredNaira);
				Double __HundredToOneNaira = Double.parseDouble(_HundredToOneNaira);
				
				int oneToHundredNaira = validation.roundUP(__oneToHundredNaira);
				int HundredToOneNaira = validation.roundUP(__HundredToOneNaira);
			
				
		
			
				
				Sheet worksheet = wb.getSheet("202");
				// declare a Cell object

//				Cell cell = null;
//				// Access the second cell in second row to update the value
//				cell = worksheet.getRow(rowNum).getCell(6);
//				// Get current cell value value and overwrite the value
//				cell.setCellValue(amount);

				
				
				

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
		
		
	


