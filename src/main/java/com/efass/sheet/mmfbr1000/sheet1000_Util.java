package com.efass.sheet.mmfbr1000;

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
import org.springframework.stereotype.Service;

import com.efass.specials.SpecialData;

@Service
public class sheet1000_Util {
	
	
	
	
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

		int rowNum = 13;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			
//			String amount = (String) listAtI.get(0);
		
			String amount = ((listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());
		
			String code = listAtI.get(1).toString();
			
			int _amount = Integer.parseInt(amount);
			
			
		//	if(_amount != 0) {
				
			
				
				Sheet worksheet = wb.getSheet("1000");
				// declare a Cell object
				
				insertData(wb, fsIP, Path,code, _amount);

//				Cell cell = null;
//				// Access the second cell in second row to update the value
//				cell = worksheet.getRow(rowNum).getCell(4);
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
				System.out.println("sheet 1000 works");

				rowNum++;
				
				
		//	}
		
			
		
		}

		return true;
	}
	
	
	
	
	
	
	
	
	public void insertData(Workbook wb,FileInputStream fsIP,String Path, String code, int amount ) throws IOException {
	

		Sheet worksheet = wb.getSheet("1000");
		// declare a Cell object
		
		
		if(code.equals("3000")) {
			
			
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(13).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("30100")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(14).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}
		
		//Adding formulas
		Cell cell00 = null;
		cell00 = worksheet.getRow(15).getCell(5);
		String formula00= "SUM(D14:D15)";
		cell00.setCellType(CellType.FORMULA);
		cell00.setCellFormula(formula00);
		
		
		if(code.equals("30210")) {
			
			
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(17).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("30220")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(18).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("30230")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(19).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("30240")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(20).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}
		
		
		//Adding formulas
		Cell cell01 = null;
		cell01 = worksheet.getRow(21).getCell(5);
		String formula01= "SUM(D18:D21)";
		cell01.setCellType(CellType.FORMULA);
		cell01.setCellFormula(formula01);
		
		Cell cell02 = null;
		cell02 = worksheet.getRow(22).getCell(6);
		String formula02= "SUM(D16:E22)";
		cell02.setCellType(CellType.FORMULA);
		cell02.setCellFormula(formula02);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
if(code.equals("31100")) {
			
			
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(24).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31110")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(25).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31120")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(26).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31130")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(27).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}
		

		else if(code.equals("31140")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(28).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31150")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(29).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31160")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(30).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}
		



		
		

		else if(code.equals("31190")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(33).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31200")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(35).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}else if(code.equals("31220")) {
			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(36).getCell(4);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);	
		}
		



		//Adding Formula
		Cell cell001 = null;
		cell001 = worksheet.getRow(31).getCell(5);
		String formula001= "SUM(D25:D31)";
		cell001.setCellType(CellType.FORMULA);
		cell001.setCellFormula(formula001);
		
		
		Cell cell002 = null;
		cell002 = worksheet.getRow(31).getCell(6);
		String formula002= "E32";
		cell002.setCellType(CellType.FORMULA);
		cell002.setCellFormula(formula002);
		
		
		Cell cell03 = null;
		cell03 = worksheet.getRow(32).getCell(6);
		String formula03= "F23-F32";
		cell03.setCellType(CellType.FORMULA);
		cell03.setCellFormula(formula03);
		
		
		Cell cell04 = null;
		cell04 = worksheet.getRow(33).getCell(5);
		String formula04= "D34";
		cell04.setCellType(CellType.FORMULA);
		cell04.setCellFormula(formula04);
		
		Cell cell05 = null;
		cell05 = worksheet.getRow(33).getCell(5);
		String formula05= "E34";
		cell05.setCellType(CellType.FORMULA);
		cell05.setCellFormula(formula05);

		
		
		Cell cell06 = null;
		cell06 = worksheet.getRow(34).getCell(5);
		String formula06= "F33-F34";
		cell06.setCellType(CellType.FORMULA);
		cell06.setCellFormula(formula06);
		
		
		
		
		
		Cell cell07 = null;
		cell07 = worksheet.getRow(37).getCell(5);
		String formula07= "D36-D37";
		cell07.setCellType(CellType.FORMULA);
		cell07.setCellFormula(formula07);
		
		
		
		Cell cell08 = null;
		cell08 = worksheet.getRow(38).getCell(5);
		String formula08= "D36-D37";
		cell08.setCellType(CellType.FORMULA);
		cell08.setCellFormula(formula08);
		

		// Close the InputStream
		fsIP.close();
		// Open FileOutputStream to write updates

		
		FileOutputStream output_file = new FileOutputStream(new File(Path));

		wb.write(output_file);
		// close the stream
		output_file.close();


	
	}

}
