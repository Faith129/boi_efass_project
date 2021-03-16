package com.efass.sheet.mmfbr711;

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

import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.specials.SpecialData;
import com.efass.specials.SpecialFunction;

@Service
public class sheet711_Util{

	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet711Repository _711Repo;

	
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

		int rowNum = 11;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			int numbers,amount;
			if(listAtI.get(0)== null || listAtI.get(1)== null) {
				
				numbers = 0;
				amount = 0;
			}else {
				 numbers = Integer.parseInt((String) listAtI.get(0));
				 amount = Integer.parseInt((String) listAtI.get(1));	
			}
			

			

			Sheet worksheet = wb.getSheet("711");
			// declare a Cell object

//			Cell cell = null;
//			// Access the second cell in second row to update the value
//			cell = worksheet.getRow(rowNum).getCell(3);
//			// Get current cell value value and overwrite the value
//			cell.setCellValue(amount);
//
//			Cell cell2 = null;
//			// Access the second cell in second row to update the value
//			cell2 = worksheet.getRow(rowNum).getCell(2);
//			// Get current cell value value and overwrite the value
//			cell2.setCellValue(numbers);
			
			if ( listAtI.get(2).equals("Individuals")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(11).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(11).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(11).getCell(4);
				String formula= "D12/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			
			if ( listAtI.get(2).equals("Solidarity Group")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(12).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(12).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(12).getCell(4);
				String formula= "D12/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
			}
			
			if ( listAtI.get(2).equals("Neighborhood and Small Group Revolving Funds")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(13).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(13).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(13).getCell(4);
				String formula= "D14/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
				
			}
			
			if ( listAtI.get(2).equals("Village Banking")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(14).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(14).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(14).getCell(4);
				String formula= "D15/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
				
			}
			
			if ( listAtI.get(2).equals("Wholesale lending")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(15).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(15).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(15).getCell(4);
				String formula= "D16/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
				
			}
			
			if ( listAtI.get(2).equals("Credit Unions")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(16).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(16).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(16).getCell(4);
				String formula= "D17/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
				
			}
			
			if ( listAtI.get(2).equals("Staff")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(17).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(17).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(17).getCell(4);
				String formula= "D18/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
				
			}
			
			if ( listAtI.get(2).equals("Others - Specify")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(18).getCell(2);
				// Get current cell value value and overwrite the value
				cell.setCellValue(numbers);	
				
				
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(18).getCell(3);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);	
				
				Cell celldiv = null;
				celldiv = worksheet.getRow(18).getCell(4);
				String formula= "D19/$D$20";
				celldiv.setCellType(CellType.FORMULA);
				celldiv.setCellFormula(formula);
				
				
			}
			
			
			
			Cell cell01 = null;
			cell01 = worksheet.getRow(19).getCell(2);
			String formula= "SUM(C12:C19)";
			cell01.setCellType(CellType.FORMULA);
			cell01.setCellFormula(formula);
			
			Cell cell02 = null;
			cell02 = worksheet.getRow(19).getCell(3);
			String formula1= "SUM(D12:D19)";
			cell02.setCellType(CellType.FORMULA);
			cell02.setCellFormula(formula1);
		
			Cell cell03 = null;
			cell03 = worksheet.getRow(19).getCell(4);
			String formula2= "SUM(E12:E19)";
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
			System.out.println("sheet 711 works");

			rowNum++;
		}

		return true;
	}
	
	
	

	public String getFolderPathWithDate(LocalDate date) {

		ReportDAO Data = ReportRepo.findByPathDate(date.toString());
		String folderPath = Data.getFile_path();

		System.out.println("Folder Path:" + folderPath);
		return folderPath;
	}






}
