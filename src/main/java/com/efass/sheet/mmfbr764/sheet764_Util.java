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
				
		
//				
//				data.add(sheetdata.get(i).getAccount_type());
//				data.add(sheetdata.get(i).getOne_to_30_days());
//				data.add(sheetdata.get(i).getThirtyOneTo60Days());
//				data.add(sheetdata.get(i).getSixty_one_to_90_days());
//				data.add(sheetdata.get(i).getNinety_one_to_180_days());
//				data.add(sheetdata.get(i).getOne_eighty_one_to_360_days());
//				data.add(sheetdata.get(i).getAbove_360_days());
				
				
				
				String One_to_30_day =(( listAtI.get(1) == null) ? "0" : listAtI.get(1).toString());

				//int _amount = Integer.parseInt(amount);
				
				String bankCode = listAtI.get(1).toString();
				
				
				Sheet worksheet = wb.getSheet("764");
				// declare a Cell object
				
				if (bankCode.equals("20530")) {
					rowNum = rowNum+1;
					
				}else  {
					Cell cell = null;
					// Access the second cell in second row to update the value
					cell = worksheet.getRow(rowNum).getCell(3);
					// Get current cell value value and overwrite the value
					cell.setCellValue(_amount);
					
				}
			
				

			


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
				System.out.println("sheet 501works");

				rowNum++;
			}

			return true;
		}

}
