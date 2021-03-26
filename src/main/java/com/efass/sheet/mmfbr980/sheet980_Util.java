package com.efass.sheet.mmfbr980;

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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.report.ReportRepository;
import com.efass.specials.SpecialData;

@Service
public class sheet980_Util {

	@Autowired
	  ReportRepository ReportRepo ;
	
	
	
	
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
	
			int rowNum = 12;
			
		
			
				for (int i = 0; i < listOfLists.size(); i++) {
					
					
					
					
//					data.add(sheetdata.get(i).getItems());
//					data.add(sheetdata.get(i).getOne_to_30_days());
//					data.add(sheetdata.get(i).getThirty_one_to_60_days());
//					data.add(sheetdata.get(i).getSixty_one_to_90_days());
//					data.add(sheetdata.get(i).getNinety_one_to_180_days());
//					data.add(sheetdata.get(i).getOne_eighty_one_to_360_days());
//					
					
					
      
				List<Object> listAtI = listOfLists.get(i);
				
				
				
				String _one_to_30_days =(( listAtI.get(1)== null) ? "0" : listAtI.get(1).toString());
				
				String _thirty_one_to_60_days =(( listAtI.get(2) == null) ? "0" : listAtI.get(2).toString());
				
				String _sixty_one_to_90_days =(( listAtI.get(3) == null) ? "0" : listAtI.get(3).toString());
				
				String _ninety_one_to_180_days =(( listAtI.get(4) == null) ? "0" : listAtI.get(4).toString());
				String _one_eighty_one_to_360_days =(( listAtI.get(5) == null) ? "0" : listAtI.get(5).toString());

				Sheet worksheet = wb.getSheet("980");
				// declare a Cell object

			
				
				
				Cell cell01 = null;
				// int cellNum3 =cellNum-3;
				cell01 = worksheet.getRow(rowNum).getCell(1);
				// Get current cell value value and overwrite the value
				cell01.setCellValue(_one_to_30_days);
				
				Cell cell02 = null;
				// int cellNum3 =cellNum-3;
				cell02 = worksheet.getRow(rowNum).getCell(2);
				// Get current cell value value and overwrite the value
				cell02.setCellValue(_thirty_one_to_60_days);
				
				
				Cell cell03 = null;
				// int cellNum3 =cellNum-3;
				cell03 = worksheet.getRow(rowNum).getCell(3);
				// Get current cell value value and overwrite the value
				cell03.setCellValue(_sixty_one_to_90_days);
				
				Cell cell04 = null;
				// int cellNum3 =cellNum-3;
				cell04 = worksheet.getRow(rowNum).getCell(4);
				// Get current cell value value and overwrite the value
				cell04.setCellValue(_one_to_30_days);
				
				Cell cell05 = null;
				// int cellNum3 =cellNum-3;
				cell05 = worksheet.getRow(rowNum).getCell(5);
				// Get current cell value value and overwrite the value
				cell05.setCellValue(_ninety_one_to_180_days);
				
				Cell cell06 = null;
				// int cellNum3 =cellNum-3;
				cell06 = worksheet.getRow(rowNum).getCell(6);
				// Get current cell value value and overwrite the value
				cell06.setCellValue(_one_eighty_one_to_360_days);
				
				
				
//				if(rowNum == 15) {
//					
//				}else if () {}
				
				
				

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
				System.out.println("sheet 980 works");

				rowNum++;
			}

			return true;
		}
}
