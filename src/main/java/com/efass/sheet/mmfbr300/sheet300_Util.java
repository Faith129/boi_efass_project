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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.specials.SpecialData;

@Service
public class sheet300_Util {

	
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

		int rowNum = 12;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			
//			String amount = (String) listAtI.get(0);
		
			String _amount = ((listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());


			double __amount = Double.parseDouble(_amount);
			
			int amount = validation.roundUP(__amount);
			String code = listAtI.get(1).toString();


			
			
			Sheet worksheet = wb.getSheet("300");
			// declare a Cell object


			
			
			if (code.equals("10110") || code.equals("10120") || code.equals("10130")) {
				insertAssets(Path, wb, fsIP,code , amount);
			}
		

				rowNum++;
				
				
			
		
			
		
		}

		return true;
	}
	
	
	
	
public void insertAssets(String Path, Workbook wb,FileInputStream fsIP, String code, int amount) throws IOException {

	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object


//	
	
	Cell cell = null;
	cell = worksheet.getRow(15).getCell(4);
	cell.setCellValue(amount);

	
	Cell cell11 = null;
	cell11 = worksheet.getRow(16).getCell(4);
	cell11.setCellValue(amount);
	
	
	Cell cell22 = null;
	cell22 = worksheet.getRow(17).getCell(5);
	String formula= "SUM(D15:D16)";
	cell22.setCellType(CellType.FORMULA);
	cell22.setCellFormula(formula);
	
	
	Cell cell23 = null;
	cell23 = worksheet.getRow(17).getCell(6);
	String formula2= "E17";
	cell23.setCellType(CellType.FORMULA);
	cell23.setCellFormula(formula2);
	
	
	
	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();


	}


}
