package com.efass.sheet.mmfbr201;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.efass.report.ReportRepository;
import com.efass.specials.SpecialData;

@Service
public class sheet201_Util {

	
	
	@Autowired
	  ReportRepository ReportRepo ;
	@Autowired
	Validation validation;
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate date, String folderPath, String duration) throws EncryptedDocumentException, InvalidFormatException, IOException {
		int rowNum = 0;
		int cellNum= 0;
		if(duration == "1-30 Days") {
			rowNum = 12;
			cellNum= 2;
		}else if (duration == "31-60 Days") {
			rowNum = 12;
			cellNum= 3;
		}else if (duration == "61-90 Days") {
			rowNum = 12;
			cellNum= 4;
		}else if (duration == "91-180 Days") {
			rowNum = 12;
			cellNum= 5;
		}else if (duration == "181-360 Days") {
			rowNum = 12;
			cellNum= 6;
		}else if(duration == "Above 360 Days") {
			rowNum = 12;
			cellNum= 7;
			
		}else {
			return true;
		}
		
		
		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
		SpecialData sb = new SpecialData();
		sb.setChildFolderPath(Path);
		
	

		// Read the spreadsheet that needs to be updated
		FileInputStream fsIP = new FileInputStream(new File(Path));
		// Access the workbook
		Workbook wb = WorkbookFactory.create(fsIP);
		// Access the worksheet, so that we can update / modify it.
	

		for (int i = 0; i < listOfLists.size(); i++) {
			
			List<Object> listAtI = listOfLists.get(i);
			
			String _noOfAccounts =(( listAtI.get(2)== null) ? "0" : listAtI.get(2).toString());
			
			String _amount =(( listAtI.get(3) == null) ? "0" : listAtI.get(3).toString());
			
	
			
			int noOfAccounts = Integer.parseInt(_noOfAccounts);
			
			
			Double amt = Double.parseDouble(_amount);
			int amount = validation.roundUP(amt);
		
			String emptyValue = "";
			
		
	
		
		
			
			Sheet worksheet = wb.getSheet("201");
			// declare a Cell object

				
			//Add All Formulas
			insertExcelFormulas( wb,worksheet);

			
			
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(cellNum);
			// Get current cell value value and overwrite the value
			cell.setCellValue(emptyValue);
			
			
			
			
			
			rowNum = rowNum + 1;
			
			Cell cell1 = null;
			// Access the second cell in second row to update the value
			cell1 = worksheet.getRow(rowNum).getCell(cellNum);
			// Get current cell value value and overwrite the value
			cell1.setCellValue(noOfAccounts);
			
	
			
			

			
			
			rowNum = rowNum + 1;
			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(cellNum);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(amount);

			
			
			
			

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
			System.out.println("sheet 201 works");

			rowNum++;
		}

		return true;
	
	}
	
	
	
	
	
	

	
	
	
	public void insertExcelFormulas(Workbook wb,Sheet worksheet) throws IOException {
	
		//Total Formula
		insertFormula(wb,worksheet,"SUM(C14:H14)",13,8);
		insertFormula(wb,worksheet,"SUM(C15:H15)",14,8);
		
		insertFormula(wb,worksheet,"SUM(C17:H17)",16,8);
		insertFormula(wb,worksheet,"SUM(C18:H18)",17,8);
		
		insertFormula(wb,worksheet,"SUM(C20:H20)",19,8);
		insertFormula(wb,worksheet,"SUM(C21:H21)",20,8);
		
		insertFormula(wb,worksheet,"SUM(C23:H23)",22,8);
		insertFormula(wb,worksheet,"SUM(C24:H24)",23,8);
		
		insertFormula(wb,worksheet,"SUM(C26:H26)",25,8);
		insertFormula(wb,worksheet,"SUM(C27:H27)",26,8);
		
		insertFormula(wb,worksheet,"SUM(C29:H29)",28,8);
		insertFormula(wb,worksheet,"SUM(C30:H30)",29,8);
		
		
		//Percentage formula
		insertFormula(wb,worksheet,"I14/$I$32*100",13,9);
		insertFormula(wb,worksheet,"I15/$I$33*100",14,9);
		
		insertFormula(wb,worksheet,"I17/$I$32*100",16,9);
		insertFormula(wb,worksheet,"I18/$I$33*100",17,9);
		
		insertFormula(wb,worksheet,"I20/$I$32*100",19,9);
		insertFormula(wb,worksheet,"I21/$I$33*100",20,9);
		
		insertFormula(wb,worksheet,"I23/$I$32*100",22,9);
		insertFormula(wb,worksheet,"I24/$I$33*100",23,9);
		
		insertFormula(wb,worksheet,"I26/$I$32*100",25,9);
		insertFormula(wb,worksheet,"I27/$I$33*100",26,9);
		
		insertFormula(wb,worksheet,"I29/$I$32*100",28,9);
		insertFormula(wb,worksheet,"I30/$I$33*100",29,9);
		
		
		//Complete Total
		
		insertFormula(wb,worksheet,"J14+J17+J20+J23+J26+J29",31,9);
		insertFormula(wb,worksheet,"J15+J18+J21+J24+J27+J30",32,9);
		
		insertFormula(wb,worksheet,"I14+I17+I20+I23+I26+I29",31,8);
		insertFormula(wb,worksheet,"IF(I15+I18+I21+I24+I27+I30='300'!E70,I15+I18+I21+I24+I27+I130,\"Check Rules!!!\")",32,8);
		
		
		insertFormula(wb,worksheet,"H14+H17+H20+H23+H26+H29",31,7);
		insertFormula(wb,worksheet,"H15+H18+H21+H24+H27+H30",32,7);
		
		
		insertFormula(wb,worksheet,"G14+G17+G20+G23+G26+G29",31,6);
		insertFormula(wb,worksheet,"G15+G18+G21+G24+G27+G30",32,6);
		
		
		insertFormula(wb,worksheet,"F14+F17+F20+F23+F26+F29",31,5);
		insertFormula(wb,worksheet,"F15+F18+F21+F24+F27+F30",32,5);
		
		insertFormula(wb,worksheet,"E14+E17+E20+E23+E26+E29",31,4);
		insertFormula(wb,worksheet,"E15+E18+E21+E24+E27+E30",32,4);
		
		
		insertFormula(wb,worksheet,"D14+D17+D20+D23+D26+D29",31,3);
		insertFormula(wb,worksheet,"D15+D18+D21+D24+D27+D30",32,3);
		
		
		insertFormula(wb,worksheet,"C14+C17+C20+C23+C26+C29",31,2);
		insertFormula(wb,worksheet,"C15+C18+C21+C24+C27+C30",32,2);
		
		
	}
	
	
	
	
	
	
	public void insertFormula(Workbook wb,Sheet worksheet,String formula,int rowNum,int cellNum  ) {
		
		Cell cell = null;
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		String cellFormula= formula;
		cell.setCellType(CellType.FORMULA);
		cell.setCellFormula(cellFormula);
	}



}
