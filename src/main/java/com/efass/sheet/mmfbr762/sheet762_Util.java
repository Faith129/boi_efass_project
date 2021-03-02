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

		int rowNum = 12;
		for (int i = 0; i < listOfLists.size(); i++) {
			List<Object> listAtI = listOfLists.get(i);
			
			int loan;
			int amount;
			if (listAtI.get(1)==null ||listAtI.get(2)==null ) {
				loan = 0;
				amount=0;
			}else if (listAtI.get(1) != null ||listAtI.get(2) != null ) {
				loan= Integer.parseInt(listAtI.get(1).toString());
				amount = Integer.parseInt(listAtI.get(2).toString());
				
				
			
			
		
			
			
			String sector = (String) listAtI.get(0);
			int NoOfLoans = loan;
			int AmountGranted =amount; 
		
			
		
			
			Sheet worksheet = wb.getSheet("762");
			// declare a Cell object

			Cell cell = null;
			// Access the second cell in second row to update the value
			cell = worksheet.getRow(rowNum).getCell(3);
			// Get current cell value value and overwrite the value
			cell.setCellValue(AmountGranted);

			Cell cell2 = null;
			// Access the second cell in second row to update the value
			cell2 = worksheet.getRow(rowNum).getCell(2);
			// Get current cell value value and overwrite the value
			cell2.setCellValue(NoOfLoans);

			}
			

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
