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

			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(3);
			// Get current cell value value and overwrite the value
			cell.setCellValue(amount);

			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(2);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(numbers);

		

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
