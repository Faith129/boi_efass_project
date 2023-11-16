package com.efass.sheet.mmfbr764;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.efass.specials.SpecialData;


@Service
public class sheet764_Util {
	
	
	
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
				
			
				String One_to_30_day =(( listAtI.get(1) == null) ? "" : listAtI.get(1).toString());

				String ThirtyOneTo60Days = (( listAtI.get(2) == null) ? "" : listAtI.get(2).toString());
				
				
				String Sixty_one_to_90_days = (( listAtI.get(3) == null) ? "" : listAtI.get(3).toString());
				
				String Ninety_one_to_180_days = (( listAtI.get(4) == null) ? "" : listAtI.get(4).toString());
				
				String One_eighty_one_to_360_days = (( listAtI.get(5) == null) ? "" : listAtI.get(5).toString());
				
				String Above_360_days = (( listAtI.get(6) == null) ? "" : listAtI.get(6).toString());
				
				
//				int _ThirtyOneTo60Days = Integer.parseInt(ThirtyOneTo60Days);
//				int _One_to_30_day = Integer.parseInt(One_to_30_day);
//				int _Sixty_one_to_90_days = Integer.parseInt(Sixty_one_to_90_days);
//				int _Ninety_one_to_180_days = Integer.parseInt(Ninety_one_to_180_days);
//				int _One_eighty_one_to_360_days = Integer.parseInt(One_eighty_one_to_360_days);
//				int _Above_360_days = Integer.parseInt(Above_360_days);
				
				
				Sheet worksheet = wb.getSheet("764");
				// declare a Cell object
				
				
					Cell cell = null;
					// Access the second cell in second row to update the value
					cell = worksheet.getRow(rowNum).getCell(7);
					// Get current cell value value and overwrite the value
					cell.setCellValue(Above_360_days);
					
				
					Cell cell1 = null;
					// Access the second cell in second row to update the value
					cell1 = worksheet.getRow(rowNum).getCell(6);
					// Get current cell value value and overwrite the value
					cell1.setCellValue(One_eighty_one_to_360_days);
					
					
					Cell cell2 = null;
					// Access the second cell in second row to update the value
					cell2 = worksheet.getRow(rowNum).getCell(5);
					// Get current cell value value and overwrite the value
					cell2.setCellValue(Ninety_one_to_180_days);
					
					
					
					Cell cell3 = null;
					// Access the second cell in second row to update the value
					cell3 = worksheet.getRow(rowNum).getCell(4);
					// Get current cell value value and overwrite the value
					cell3.setCellValue(Sixty_one_to_90_days);
					
					
					
					
					Cell cell4 = null;
					// Access the second cell in second row to update the value
					cell4 = worksheet.getRow(rowNum).getCell(3);
					// Get current cell value value and overwrite the value
					cell4.setCellValue(ThirtyOneTo60Days);
					
					
					
					Cell cell5 = null;
					// Access the second cell in second row to update the value
					cell5 = worksheet.getRow(rowNum).getCell(2);
					// Get current cell value value and overwrite the value
					cell5.setCellValue(One_to_30_day);

			


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
				System.out.println("sheet 764works");

				rowNum++;
			}

			return true;
		}

}
