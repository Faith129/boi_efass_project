package com.efass.sheet.mmfbr001;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.springframework.stereotype.Service;

import com.efass.specials.SpecialData;

@Service
public class sheet001_Util {

	public String writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		
		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
		SpecialData sb = new SpecialData();
		sb.setChildFolderPath(Path);
		
	

		// Read the spreadsheet that needs to be updated
		FileInputStream fsIP = new FileInputStream(new File(Path));
		// Access the workbook
		Workbook wb = WorkbookFactory.create(fsIP);
		// Access the worksheet, so that we can update / modify it.

		int rowNum = 14;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			

		
			String number1 = ((listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());
			String value1 = ((listAtI.get(1) == null) ? "0" : listAtI.get(1).toString());
			
			String number2 = ((listAtI.get(2) == null) ? "0" : listAtI.get(2).toString());
			String value2 = ((listAtI.get(3) == null) ? "0" : listAtI.get(3).toString());
			String code = listAtI.get(4).toString();
			int __number1 = Integer.parseInt(number1);
			int __value1 =Integer.parseInt(value1);
			int __number2 = Integer.parseInt(number2);
			int __value2 =Integer.parseInt(value2);
			
			
			//roundUp Numbers
			int _number1 = (int) Math.ceil(__number1);
			int _value1 = (int) Math.ceil(__value1);
			
			int _number2 = (int) Math.ceil(__number2);
			int _value2 = (int) Math.ceil(__value2);
			
		
			
			
			if(listAtI.get(4).equals("21111") || listAtI.get(4).equals("21112")) {
				
			 insertBorrowers( rowNum, wb, fsIP, Path,  _value2,  _number2,  _value1,  _number1,code);	
				
			}else if(listAtI.get(4).equals("21121") || listAtI.get(4).equals("21122")) {
				
				insertClientsDropOut( rowNum, wb, fsIP, Path,  _value2,  _number2,  _value1,  _number1,code);			
			}else if(listAtI.get(4).equals("21131") || listAtI.get(4).equals("21132") ||listAtI.get(4).equals("21141") ||listAtI.get(4).equals("21145") ||listAtI.get(4).equals("1")) {
			
				insertDepositors( rowNum, wb, fsIP, Path,  _value2,  _number2,  _value1,  _number1,code);
			}
					
		
		}

		return Path;
	}

	
	

	
	
public void insertBorrowers(int rowNum,	Workbook wb,FileInputStream fsIP,String Path, int _value2, int _number2, int _value1, int _number1, String code) throws IOException {
	
	if (code.equals("21111")) {
	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object

	
	Cell cell01 = null;
	cell01 = worksheet.getRow(13).getCell(5);
	String formula= "E15+E16";
	cell01.setCellType(CellType.FORMULA);
	cell01.setCellFormula(formula);
	
	
	Cell cell = null;
	// Access the second cell in second row to update the value
	cell = worksheet.getRow(14).getCell(5);
	// Get current cell value value and overwrite the value
	cell.setCellValue(_value2);

	
	
	Cell cell2 = null;
	// Access the second cell in second row to update the value
	cell2 = worksheet.getRow(14).getCell(4);
	// Get current cell value value and overwrite the value
	cell2.setCellValue(_number2);
	
	
	
	Cell cell3 = null;
	// Access the second cell in second row to update the value
	cell3 = worksheet.getRow(14).getCell(3);
	// Get current cell value value and overwrite the value
	cell3.setCellValue(_value1);

	
	
	Cell cell4 = null;
	// Access the second cell in second row to update the value
	cell4 = worksheet.getRow(14).getCell(2);
	// Get current cell value value and overwrite the value
	cell4.setCellValue(_number1);
	

	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();


	}else if (code.equals("21112")) {
		
		Sheet worksheet = wb.getSheet("001");
		// declare a Cell object

		Cell cell = null;
		// Access the second cell in second row to update the value
		cell = worksheet.getRow(15).getCell(5);
		// Get current cell value value and overwrite the value
		cell.setCellValue(_value2);

		
		
		Cell cell2 = null;
		// Access the second cell in second row to update the value
		cell2 = worksheet.getRow(15).getCell(4);
		// Get current cell value value and overwrite the value
		cell2.setCellValue(_number2);
		
		
		
		Cell cell3 = null;
		// Access the second cell in second row to update the value
		cell3 = worksheet.getRow(15).getCell(3);
		// Get current cell value value and overwrite the value
		cell3.setCellValue(_value1);

		
		
		Cell cell4 = null;
		// Access the second cell in second row to update the value
		cell4 = worksheet.getRow(15).getCell(2);
		// Get current cell value value and overwrite the value
		cell4.setCellValue(_number1);
		

		

		// Close the InputStream
		fsIP.close();
		// Open FileOutputStream to write updates

		
		FileOutputStream output_file = new FileOutputStream(new File(Path));

		wb.write(output_file);
		// close the stream
		output_file.close();
		
		
	}
	
}


public void insertClientsDropOut(int rowNum,Workbook wb,FileInputStream fsIP,String Path, int _value2, int _number2, int _value1, int _number1, String code) throws IOException {
	
	if (code.equals("21121")) {
	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object

	Cell cell = null;
	// Access the second cell in second row to update the value
	cell = worksheet.getRow(17).getCell(5);
	// Get current cell value value and overwrite the value
	cell.setCellValue(_value2);

	
	
	Cell cell2 = null;
	// Access the second cell in second row to update the value
	cell2 = worksheet.getRow(17).getCell(4);
	// Get current cell value value and overwrite the value
	cell2.setCellValue(_number2);
	
	
	
	Cell cell3 = null;
	// Access the second cell in second row to update the value
	cell3 = worksheet.getRow(17).getCell(3);
	// Get current cell value value and overwrite the value
	cell3.setCellValue(_value1);

	
	
	Cell cell4 = null;
	// Access the second cell in second row to update the value
	cell4 = worksheet.getRow(17).getCell(2);
	// Get current cell value value and overwrite the value
	cell4.setCellValue(_number1);
	

	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();


	}else if (code.equals("21122")) {
		
		Sheet worksheet = wb.getSheet("001");
		// declare a Cell object

		Cell cell = null;
		// Access the second cell in second row to update the value
		cell = worksheet.getRow(18).getCell(5);
		// Get current cell value value and overwrite the value
		cell.setCellValue(_value2);

		
		
		Cell cell2 = null;
		// Access the second cell in second row to update the value
		cell2 = worksheet.getRow(18).getCell(4);
		// Get current cell value value and overwrite the value
		cell2.setCellValue(_number2);
		
		
		
		Cell cell3 = null;
		// Access the second cell in second row to update the value
		cell3 = worksheet.getRow(18).getCell(3);
		// Get current cell value value and overwrite the value
		cell3.setCellValue(_value1);

		
		
		Cell cell4 = null;
		// Access the second cell in second row to update the value
		cell4 = worksheet.getRow(18).getCell(2);
		// Get current cell value value and overwrite the value
		cell4.setCellValue(_number1);
		

		

		// Close the InputStream
		fsIP.close();
		// Open FileOutputStream to write updates

		
		FileOutputStream output_file = new FileOutputStream(new File(Path));

		wb.write(output_file);
		// close the stream
		output_file.close();
		
		
	}
	
}







public void insertDepositors(int rowNum,Workbook wb,FileInputStream fsIP,String Path, int _value2, int _number2, int _value1, int _number1, String code) throws IOException {
	
	if (code.equals("21131")) {
	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object

	Cell cell = null;
	// Access the second cell in second row to update the value
	cell = worksheet.getRow(20).getCell(5);
	// Get current cell value value and overwrite the value
	cell.setCellValue(_value2);

	
	
	Cell cell2 = null;
	// Access the second cell in second row to update the value
	cell2 = worksheet.getRow(20).getCell(4);
	// Get current cell value value and overwrite the value
	cell2.setCellValue(_number2);
	
	
	
	Cell cell3 = null;
	// Access the second cell in second row to update the value
	cell3 = worksheet.getRow(20).getCell(3);
	// Get current cell value value and overwrite the value
	cell3.setCellValue(_value1);

	
	
	Cell cell4 = null;
	// Access the second cell in second row to update the value
	cell4 = worksheet.getRow(20).getCell(2);
	// Get current cell value value and overwrite the value
	cell4.setCellValue(_number1);
	

	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();


	}else if (code.equals("21132")) {
		
		Sheet worksheet = wb.getSheet("001");
		// declare a Cell object

		Cell cell = null;
		// Access the second cell in second row to update the value
		cell = worksheet.getRow(21).getCell(5);
		// Get current cell value value and overwrite the value
		cell.setCellValue(_value2);

		
		
		Cell cell2 = null;
		// Access the second cell in second row to update the value
		cell2 = worksheet.getRow(21).getCell(4);
		// Get current cell value value and overwrite the value
		cell2.setCellValue(_number2);
		
		
		
		Cell cell3 = null;
		// Access the second cell in second row to update the value
		cell3 = worksheet.getRow(21).getCell(3);
		// Get current cell value value and overwrite the value
		cell3.setCellValue(_value1);

		
		
		Cell cell4 = null;
		// Access the second cell in second row to update the value
		cell4 = worksheet.getRow(21).getCell(2);
		// Get current cell value value and overwrite the value
		cell4.setCellValue(_number1);
		

		

		// Close the InputStream
		fsIP.close();
		// Open FileOutputStream to write updates

		
		FileOutputStream output_file = new FileOutputStream(new File(Path));

		wb.write(output_file);
		// close the stream
		output_file.close();
		
		
	}
	
	
else if (code.equals("21141")) {
		
		Sheet worksheet = wb.getSheet("001");
		// declare a Cell object

		Cell cell = null;
		// Access the second cell in second row to update the value
		cell = worksheet.getRow(23).getCell(5);
		// Get current cell value value and overwrite the value
		cell.setCellValue(_value2);

		
		
		Cell cell2 = null;
		// Access the second cell in second row to update the value
		cell2 = worksheet.getRow(23).getCell(4);
		// Get current cell value value and overwrite the value
		cell2.setCellValue(_number2);
		
		
		
		Cell cell3 = null;
		// Access the second cell in second row to update the value
		cell3 = worksheet.getRow(23).getCell(3);
		// Get current cell value value and overwrite the value
		cell3.setCellValue(_value1);

		
		
		Cell cell4 = null;
		// Access the second cell in second row to update the value
		cell4 = worksheet.getRow(23).getCell(2);
		// Get current cell value value and overwrite the value
		cell4.setCellValue(_number1);
		

		

		// Close the InputStream
		fsIP.close();
		// Open FileOutputStream to write updates

		
		FileOutputStream output_file = new FileOutputStream(new File(Path));

		wb.write(output_file);
		// close the stream
		output_file.close();
		
		
	}
	
	
	
	
else if (code.equals("21145")) {
	
	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object

	Cell cell = null;
	// Access the second cell in second row to update the value
	cell = worksheet.getRow(24).getCell(5);
	// Get current cell value value and overwrite the value
	cell.setCellValue(_value2);

	
	
	Cell cell2 = null;
	// Access the second cell in second row to update the value
	cell2 = worksheet.getRow(24).getCell(4);
	// Get current cell value value and overwrite the value
	cell2.setCellValue(_number2);
	
	
	
	Cell cell3 = null;
	// Access the second cell in second row to update the value
	cell3 = worksheet.getRow(24).getCell(3);
	// Get current cell value value and overwrite the value
	cell3.setCellValue(_value1);

	
	
	Cell cell4 = null;
	// Access the second cell in second row to update the value
	cell4 = worksheet.getRow(24).getCell(2);
	// Get current cell value value and overwrite the value
	cell4.setCellValue(_number1);
	

	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();
	
	
}
	
	
	
	
	
else if (code.equals("1")) {
	
	Sheet worksheet = wb.getSheet("001");
	// declare a Cell object


	
	Cell cell4 = null;
	// Access the second cell in second row to update the value
	cell4 = worksheet.getRow(32).getCell(2);
	// Get current cell value value and overwrite the value
	cell4.setCellValue(_number1);
	

	

	// Close the InputStream
	fsIP.close();
	// Open FileOutputStream to write updates

	
	FileOutputStream output_file = new FileOutputStream(new File(Path));

	wb.write(output_file);
	// close the stream
	output_file.close();
	
	
}
	
}

}
