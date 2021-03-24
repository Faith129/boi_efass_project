package com.efass.sheet.mmfbr811;

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
public class sheet811_Util {

	
	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet811Repository _811Repo;

	
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

		int rowNum = 11;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			String item =  (String) listAtI.get(2);
			
			String _performing =(( listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());
			String _nonperforming =(( listAtI.get(1) == null) ? "0" : listAtI.get(1).toString());
			
		
			int performing = Integer.parseInt(_performing);
			int nonperforming = Integer.parseInt(_nonperforming);
	
		
			
	
		
		
			
			Sheet worksheet = wb.getSheet("811");
			// declare a Cell object

			if ( listAtI.get(2).equals("Accounts Receivable [Provide Breakdown]")) {
			Cell cell1 = null;
			// Access the second cell in second row to update the value
			cell1 = worksheet.getRow(11).getCell(2);
			// Get current cell value value and overwrite the value
			cell1.setCellValue(performing);

			Cell cell2 = null;
			cell2 = worksheet.getRow(11).getCell(3);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(nonperforming);
			
			
			Cell cell3 = null;
			cell3 = worksheet.getRow(11).getCell(4);
			String total= "SUM(C12:D12)";
			cell3.setCellType(CellType.FORMULA);
			cell3.setCellFormula(total);
			
			}
			
			if ( listAtI.get(2).equals("Accrued Interest Receivable [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(12).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(12).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(12).getCell(4);
				String total= "SUM(C13:D13)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Cheques for Collection /Transit Items [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(13).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(13).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(13).getCell(4);
				String total= "SUM(C14:D14)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Prepaid Interest [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(14).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(14).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(14).getCell(4);
				String total= "SUM(C15:D15)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Prepaid Rent [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(15).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(15).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(15).getCell(4);
				String total= "SUM(C16:D16)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}

			if ( listAtI.get(2).equals("Stationery [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(16).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(16).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(16).getCell(4);
				String total= "SUM(C17:D17)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Other Prepayments [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(17).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(17).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(17).getCell(4);
				String total= "SUM(C18:D18)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Suspense Account [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(18).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(18).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(18).getCell(4);
				String total= "SUM(C19:D19)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Goodwill and Other Intangible Assets [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(19).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(19).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(19).getCell(4);
				String total= "SUM(C20:D20)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			if ( listAtI.get(2).equals("Miscellaneous [Provide Breakdown]")) {
				Cell cell1 = null;
				// Access the second cell in second row to update the value
				cell1 = worksheet.getRow(20).getCell(2);
				// Get current cell value value and overwrite the value
				cell1.setCellValue(performing);

				Cell cell2 = null;
				cell2 = worksheet.getRow(20).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(nonperforming);
				
				
				Cell cell3 = null;
				cell3 = worksheet.getRow(20).getCell(4);
				String total= "SUM(C21:D21)";
				cell3.setCellType(CellType.FORMULA);
				cell3.setCellFormula(total);
				
				}
			
			Cell cell01 = null;
			cell01 = worksheet.getRow(21).getCell(2);
			String formula= "SUM(C12:C21)";
			cell01.setCellType(CellType.FORMULA);
			cell01.setCellFormula(formula);
			
			Cell cell02 = null;
			cell02 = worksheet.getRow(21).getCell(3);
			String formula1= "SUM(D12:D21)";
			cell02.setCellType(CellType.FORMULA);
			cell02.setCellFormula(formula1);
			
			Cell cell03 = null;
			cell03 = worksheet.getRow(21).getCell(4);
			String formula2= "SUM(E12:E21)";
			cell03.setCellType(CellType.FORMULA);
			cell03.setCellFormula(formula2);
		

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
			System.out.println("sheet 811 works");

			rowNum++;
		}

		return true;
	}
	
	
}
