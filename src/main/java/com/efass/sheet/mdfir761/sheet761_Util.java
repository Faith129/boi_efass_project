package com.efass.sheet.mmfbr761;



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

import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr321.sheet321Repository;
import com.efass.specials.SpecialData;

@Service
public class sheet761_Util {
	
	
	@Autowired
	  ReportRepository ReportRepo ;


	@Autowired
	  sheet761Repository _761Repo;
	
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
//			int rowNum = 11;
//			
		
			
				for (int i = 0; i < listOfLists.size(); i++) {
      
				List<Object> listAtI = listOfLists.get(i);
				
				String _amount =(( listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());
				
				
			
				int amount =  Integer.parseInt(_amount);
			
			
				
				Sheet worksheet = wb.getSheet("761");
				// declare a Cell object
				if ( listAtI.get(1).equals("Performing")) {
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(11).getCell(3);
				// Get current cell value value and overwrite the value
				cell.setCellValue(amount);
				}
				
				if ( listAtI.get(1).equals("Pass & Watch")) {
					Cell cell01 = null;
					cell01 = worksheet.getRow(13).getCell(3);
					String formula= "'771'!J15";
					cell01.setCellType(CellType.FORMULA);
					cell01.setCellFormula(formula);	
				}
					
				if ( listAtI.get(1).equals("Substandard")) {
					Cell cell02 = null;
					cell02 = worksheet.getRow(14).getCell(3);
					String formula1= "'771'!K15";
					cell02.setCellType(CellType.FORMULA);
					cell02.setCellFormula(formula1);
				}
				
				if ( listAtI.get(1).equals("Doubtful")) {
					Cell cell03 = null;
					cell03 = worksheet.getRow(15).getCell(3);
					String formula2= "'771'!L15";
					cell03.setCellType(CellType.FORMULA);
					cell03.setCellFormula(formula2);

				}
				
				if ( listAtI.get(1).equals("Lost")) {
					
					Cell cell04 = null;
					cell04 = worksheet.getRow(16).getCell(3);
					String formula3= "'771'!M15";
					cell04.setCellType(CellType.FORMULA);
					cell04.setCellFormula(formula3);

				}
				
				if ( listAtI.get(1).equals("Total Porfolio-At-Risk")) {
					
					Cell cell05 = null;
					cell05 = worksheet.getRow(17).getCell(3);
					String formula4= "SUM(D14:D17)";
					cell05.setCellType(CellType.FORMULA);
					cell05.setCellFormula(formula4);

				}
				
				if ( listAtI.get(1).equals("Interest In Suspense")) {
				
					Cell cell06 = null;
					cell06 = worksheet.getRow(18).getCell(3);
					String formula5= "'771'!H15";
					cell06.setCellType(CellType.FORMULA);
					cell06.setCellFormula(formula5);

				}
			
				
//				Cell total = null;
//				total = worksheet.getRow(19).getCell(3);
//				String formula6= "IF(D19+D18+D12='300'!E42,D19+D18+D12,\"Check Rules!!!\")";
//				total.setCellType(CellType.FORMULA);
//				total.setCellFormula(formula6);



				
				
				
				

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
				System.out.println("sheet 761works");

//				rowNum++;
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


