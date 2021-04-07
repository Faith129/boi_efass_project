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
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate date, String folderPath, String pricerange) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		int rowNum = 0;
		int cellNum= 0;
		if(pricerange ==  "1-100,000") {
			rowNum = 12;
			cellNum= 3;
		}else if (pricerange == "100,001 Above") {
			rowNum = 12;
			cellNum= 4;
			
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

//			int rowNum = 12;
			for (int i = 0; i < listOfLists.size(); i++) {
				List<Object> listAtI = listOfLists.get(i);
				
				String _noOfAccounts =(( listAtI.get(2)== null) ? "0" : listAtI.get(2).toString());
				
				String _amount =(( listAtI.get(3) == null) ? "0" : listAtI.get(3).toString());
				
		
				
				int noOfAccounts = Integer.parseInt(_noOfAccounts);
				
				
				Double amt = Double.parseDouble(_amount);
				int amount = validation.roundUP(amt);
			
				String emptyValue = "";
				
			
		
			
			
				
				
				Sheet worksheet = wb.getSheet("202");
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
				System.out.println("sheet 202 works");

				rowNum++;
			}

			return true;
		}
	
	public void insertExcelFormulas(Workbook wb,Sheet worksheet) throws IOException {
		
		//Total Formula
		insertFormula(wb,worksheet,"SUM(D14:E14)",13,5);
		insertFormula(wb,worksheet,"SUM(D15:E15)",14,5);
		
		insertFormula(wb,worksheet,"SUM(D17:E17)",16,5);
		insertFormula(wb,worksheet,"SUM(D18:E18)",17,5);
		
		insertFormula(wb,worksheet,"SUM(D20:E20)",19,5);
		insertFormula(wb,worksheet,"SUM(D21:E21)",20,5);
		
		insertFormula(wb,worksheet,"SUM(D23:E23)",22,5);
		insertFormula(wb,worksheet,"SUM(D24:E24)",23,5);
	
		
		
		//Complete Total
		
		insertFormula(wb,worksheet,"D14+D17+D20+D23",25,3);
		insertFormula(wb,worksheet,"E14+E17+E20+E23",25,4);
		insertFormula(wb,worksheet,"F14+F17+F20+F23",25,5);
		
		
		
		insertFormula(wb,worksheet,"D14+D17+D20+D23",26,3);
		insertFormula(wb,worksheet,"E14+E17+E20+E23",26,4);
		insertFormula(wb,worksheet,"IF(F15+F18+F21+F24='300'!E70,F15+F18+F21+F24,\"Check Rules!!!\")",26,5);
		
		
		
	}
	
	
	
	
	
	
	public void insertFormula(Workbook wb,Sheet worksheet,String formula,int rowNum,int cellNum  ) {
		
		Cell cell = null;
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		String cellFormula= formula;
		cell.setCellType(CellType.FORMULA);
		cell.setCellFormula(cellFormula);
	}


	
}
		
		
	


