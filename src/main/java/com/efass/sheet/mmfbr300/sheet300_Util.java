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





public void insertDueFrom(String Path, Workbook wb,FileInputStream fsIP, String code, int amount) throws IOException {

	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object
	
	
	
	
	//Insert Formula
	Cell cell23 = null;
	cell23 = worksheet.getRow(20).getCell(4);
	String formula2= "'221'!D48";
	cell23.setCellType(CellType.FORMULA);
	cell23.setCellFormula(formula2);
	
	
	Cell cell24 = null;
	cell24 = worksheet.getRow(20).getCell(5);
	String formula24= "D20";
	cell24.setCellType(CellType.FORMULA);
	cell24.setCellFormula(formula24);
	
	Cell cell25 = null;
	cell25 = worksheet.getRow(22).getCell(4);
	String formula25= "'311'!F39";
	cell25.setCellType(CellType.FORMULA);
	cell25.setCellFormula(formula25);
	
	Cell cell26 = null;
	cell26 = worksheet.getRow(23).getCell(4);
	String formula26= "'321'!F32";
	cell26.setCellType(CellType.FORMULA);
	cell26.setCellFormula(formula25);
	
	
	Cell cell27 = null;
	cell27 = worksheet.getRow(24).getCell(5);
	String formula27= "SUM(D22:D23)";
	cell27.setCellType(CellType.FORMULA);
	cell27.setCellFormula(formula27);
	
	
	
	Cell cell28 = null;
	cell28 = worksheet.getRow(25).getCell(6);
	String formula28= "SUM(E20:E24)";
	cell28.setCellType(CellType.FORMULA);
	cell28.setCellFormula(formula28);
	
	
	
	
	Cell cell29 = null;
	cell29 = worksheet.getRow(27).getCell(5);
	String formula29= "D27";
	cell28.setCellType(CellType.FORMULA);
	cell28.setCellFormula(formula29);
	
	
	Cell cell30 = null;
	cell30 = worksheet.getRow(32).getCell(4);
	String formula30= "'641'!D42";
	cell30.setCellType(CellType.FORMULA);
	cell30.setCellFormula(formula30);
	
	
	Cell cell31 = null;
	cell31 = worksheet.getRow(33).getCell(5);
	String formula31= "SUM(D29:D32)";
	cell31.setCellType(CellType.FORMULA);
	cell31.setCellFormula(formula31);
	
	
	Cell cell32 = null;
	cell32 = worksheet.getRow(33).getCell(6);
	String formula32= "E33";
	cell32.setCellType(CellType.FORMULA);
	cell32.setCellFormula(formula32);
	
	
	
	
	
	//insert value
	
	if(code.equals("10610")) {
		insertValue( wb, worksheet, amount,29,4);  
	}else if(code.equals("10620")) {
		insertValue( wb, worksheet, amount,30,4);  
	} else if(code.equals("10630")) {
		insertValue( wb, worksheet, amount,31,4);  
	} else if(code.equals("10720")) {
		insertValue( wb, worksheet, amount,36,4);  
	} else if(code.equals("10725")) {
		insertValue( wb, worksheet, amount,37,4);  
	} else if(code.equals("10730")) {
		insertValue( wb, worksheet, amount,38,4);  
	} else if(code.equals("10740")) {
		insertValue( wb, worksheet, amount,39,4);  
	} else if(code.equals("10750")) {
		insertValue( wb, worksheet, amount,41,4);  
	} else if(code.equals("10880")) {
		insertValue( wb, worksheet, amount,49,4);  
	} 
	 
	//Ended at no. 49, begins at no.10890
	
	

	
	
	
	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();

	
}


public void insertValue(Workbook wb,Sheet worksheet,int amount,int rowNum,int cellNum  ) {
	
	Cell cell = null;
	cell = worksheet.getRow(rowNum).getCell(cellNum);
	cell.setCellValue(amount);
}
}
