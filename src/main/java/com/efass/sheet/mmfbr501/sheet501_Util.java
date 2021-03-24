package com.efass.sheet.mmfbr501;

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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.specials.SpecialData;

@Service
public class sheet501_Util {

@Autowired
Validation validation;
	
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
			int rowNum = 11;
				for (int i = 0; i < listOfLists.size(); i++) {
				List<Object> listAtI = listOfLists.get(i);
				
//			String amount = listAtI.get(0).toString();
				

				String _amount =(( listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());

				
		
		
				Double dblAmount = Double.parseDouble(_amount);
				int   amount = validation.roundUP(dblAmount);
				
				//String bankCode = listAtI.get(1).toString();
				
				
				Sheet worksheet = wb.getSheet("501");
				// declare a Cell object
				
				if (rowNum == 15) {
					//rowNum = rowNum+1;
					Cell cell01 = null;
					cell01 = worksheet.getRow(15).getCell(3);
					String formula= "IF('1000'!F39>0,'1000'!F39,0)";
					cell01.setCellType(CellType.FORMULA);
					cell01.setCellFormula(formula);
					
					
				}else  {
			
			
					Cell cell = null;
					// Access the second cell in second row to update the value
					cell = worksheet.getRow(rowNum).getCell(3);
					// Get current cell value value and overwrite the value
					cell.setCellValue(amount);
				
				}
			
			
				
				Cell cell02 = null;
				cell02 = worksheet.getRow(25).getCell(3);
				String formula1= "SUM(D12:D25)";
				cell02.setCellType(CellType.FORMULA);
				cell02.setCellFormula(formula1);

				

			


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
				System.out.println("sheet 501works");

				rowNum++;
			}

			return true;
		}
}
