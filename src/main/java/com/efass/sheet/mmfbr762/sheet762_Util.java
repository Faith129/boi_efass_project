package com.efass.sheet.mmfbr762;

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

import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr311.sheet311Repository;
import com.efass.specials.SpecialData;

@Service
public class sheet762_Util {
	
	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet762Repository _762Repo;

	
	
	

	
	public static Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {


		
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
		
			String sector = (String) listAtI.get(0);
			String loan =(( listAtI.get(1) == null) ? "0" : listAtI.get(1).toString());
			String amount =(( listAtI.get(2) == null) ? "0" : listAtI.get(2).toString());
					
			
			
			int NoOfLoans = Integer.parseInt(loan);
			int AmountGranted =Integer.parseInt(amount); 
		
			
		
			
			Sheet worksheet = wb.getSheet("762");
			// declare a Cell object

//			Cell cell = null;
//			 Access the second cell in second row to update the value
//			cell = worksheet.getRow(rowNum).getCell(3);
//			 Get current cell value value and overwrite the value
//			cell.setCellValue(AmountGranted);
//
//			Cell cell2 = null;
//			 Access the second cell in second row to update the value
//			cell2 = worksheet.getRow(rowNum).getCell(2);
//			 Get current cell value value and overwrite the value
//			cell2.setCellValue(NoOfLoans);

			
			if ( listAtI.get(0).equals("Agriculture & Forestry")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(11).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(11).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(11).getCell(4);
				String formula= "D12/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Mining & Quarry")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(12).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(12).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(12).getCell(4);
				String formula= "D13/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Manufacturing & Food Processing")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(13).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(13).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(13).getCell(4);
				String formula= "D14/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Trade & Commerce")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(14).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(14).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(14).getCell(4);
				String formula= "D15/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Transport & Communication")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(15).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(15).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(15).getCell(4);
				String formula= "D16/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Real Estate & Construction")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(16).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(16).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(16).getCell(4);
				String formula= "D17/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Rent/Housing")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(17).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(17).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(17).getCell(4);
				String formula= "D18/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			if ( listAtI.get(0).equals("Consumer/Personal")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(18).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(18).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(18).getCell(4);
				String formula= "D19/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}	if ( listAtI.get(0).equals("Health")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(19).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(19).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(19).getCell(4);
				String formula= "D20/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}	if ( listAtI.get(0).equals("Education")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(20).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(20).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(20).getCell(4);
				String formula= "D21/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}	if ( listAtI.get(0).equals("Tourism & Hospitality")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(21).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(21).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(21).getCell(4);
				String formula= "D22/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			} if ( listAtI.get(0).equals("Purchase of Shares")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(22).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(22).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(22).getCell(4);
				String formula= "D23/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}  if ( listAtI.get(0).equals("Others (Specify)")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(23).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(NoOfLoans);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(23).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(AmountGranted);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(23).getCell(4);
				String formula= "D24/$D$25";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			
			
			Cell cell01 = null;
			cell01 = worksheet.getRow(24).getCell(2);
			String formula= "SUM(C12:C24)";
			cell01.setCellType(CellType.FORMULA);
			cell01.setCellFormula(formula);
			
//			Cell cell02 = null;
//			cell02 = worksheet.getRow(24).getCell(3);
//			String formula2= "SUM(D12:D24)='300'!E42,SUM(D12:D24),\"Check Rules!!!\")";
//			cell02.setCellType(CellType.FORMULA);
//			cell02.setCellFormula(formula2);
//			
//			Cell cell03 = null;
//			cell03 = worksheet.getRow(24).getCell(4);
//			String formula3= "SUM(E12:E24)";
//			cell03.setCellType(CellType.FORMULA);
//			cell03.setCellFormula(formula3);

			// Close the InputStream
			fsIP.close();
			// Open FileOutputStream to write updates

			
			FileOutputStream output_file = new FileOutputStream(new File(Path));

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
