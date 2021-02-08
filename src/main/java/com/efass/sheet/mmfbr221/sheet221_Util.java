package com.efass.sheet.mmfbr221;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
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
public class sheet221_Util{

	@Autowired
	 static ReportRepository ReportRepo ;


	@Autowired
	 static sheet221Repository _221Repo;

	
	SpecialData specialData = new SpecialData();
	
	
	
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {


		
		
	

		// Create Check and Create Folder
	String childFolderPath =	new SpecialFunction().checkCreateFolder(folderPath);
		 
	specialData.setChildFolderPath(childFolderPath);
	specialData.setFolderPath(folderPath);
		
		if (folderPath.equals(null) || childFolderPath.equals(null)) {
			return false;
		}
		String Path ="./datafiles/cbn_MFB_rpt_12345m052087.xlsx";

		// Read the spreadsheet that needs to be updated
		FileInputStream fsIP = new FileInputStream(new File(Path));
		// Access the workbook
		Workbook wb = WorkbookFactory.create(fsIP);
		// Access the worksheet, so that we can update / modify it.

		int rowNum = 12;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);

			int amount = Integer.parseInt(listAtI.get(0).toString());
			String bankName = (String) listAtI.get(1);
			String bankCode = (String) listAtI.get(2);

			Sheet worksheet = wb.getSheet("221");
			// declare a Cell object

			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(3);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);

			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(1);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(bankName);

			Cell cell3 = null;
			// int cellNum3 =cellNum-3;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(0);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(bankCode);

			// Close the InputStream
			fsIP.close();
			// Open FileOutputStream to write updates

			
			FileOutputStream output_file = new FileOutputStream(new File(childFolderPath+"/" + "cbn_MFB_rpt_12345m052087.xlsx"));
			// FileOutputStream output_file =new FileOutputStream(new
			// File(".\\datafiles\\export\\cbn_MFB_rpt_12345m052087.xlsx"));
			// write changes
			wb.write(output_file);
			// close the stream
			output_file.close();
			System.out.println("works");

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
