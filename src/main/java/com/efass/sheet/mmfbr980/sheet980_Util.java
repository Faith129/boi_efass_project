package com.efass.sheet.mmfbr980;

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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.Validation;
import com.efass.report.ReportRepository;
import com.efass.specials.SpecialData;

@Service
public class sheet980_Util {

	@Autowired
	  ReportRepository ReportRepo ;
	
	@Autowired
	Validation validation;
	
	
	
	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date ,String folderPath, String duration)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		
		
	
		
		
		int rowNum = 0;
		int cellNum= 0;
		
		if(duration == "1-30 Days") {
			rowNum = 12;
			cellNum= 2;
		}else if (duration == "31-60 Days") {
			rowNum = 12;
			cellNum= 3;
		}else if (duration == "61-90 Days") {
			rowNum = 12;
			cellNum= 4;
		}else if (duration == "91-180 Days") {
			rowNum = 12;
			cellNum= 5;
		}else if (duration == "181-360 Days") {
			rowNum = 12;
			cellNum= 6;
		}else if(duration == "Above 360 Days") {
			rowNum = 12;
			cellNum= 7;
			
		}else {
			return true;
		}
		
		
		
    		String Path =folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
			SpecialData sb = new SpecialData();
			sb.setChildFolderPath(Path);
			
		

		// Read the spreadsheet that needs to be updated
			FileInputStream fsIP = new FileInputStream(new File(Path));
			// Access the workbook
			Workbook wb = WorkbookFactory.create(fsIP);
			// Access the worksheet, so that we can update / modify it.
	
	
			
		
			
			for (int i = 0; i < listOfLists.size(); i++) {
				
				List<Object> listAtI = listOfLists.get(i);
				
				String _amount =(( listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());
				
		
				
		
				
				
				Double amt = Double.parseDouble(_amount);
				int amount = validation.roundUP(amt);
			
				
			
				
				Sheet worksheet = wb.getSheet("980");
				// declare a Cell object

					
				if(rowNum == 15) {
				//Add All Formulas
				insertTotal_A_excelFormulas( wb,worksheet);
				rowNum = rowNum + 2; 
				}else if (rowNum == 18){
					insertTotal_B_excelFormulas( wb,worksheet);
					rowNum = rowNum + 1; 
				} else if(rowNum == 20){
					insertOtherFormulas( wb,worksheet);
				}
				else{
			
				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(rowNum).getCell(cellNum);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(amount);
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
				System.out.println("sheet 980 works");

				rowNum++;
			}

			return true;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	private void insertOtherFormulas(Workbook wb, Sheet worksheet) {
		insertFormula(wb,worksheet,"C16-C19-C20",20,2);
		insertFormula(wb,worksheet,"D16-D19-D20",20,3);
		insertFormula(wb,worksheet,"E16-E19-E20",20,4);
		insertFormula(wb,worksheet,"F16-F19-F20",20,5);
		insertFormula(wb,worksheet,"G16-G19-G20",20,6);
		insertFormula(wb,worksheet,"H16-H19-H20",20,7);
		
		
		
		insertFormula(wb,worksheet,"C21",21,2);
		insertFormula(wb,worksheet,"C21+D21",21,3);
		insertFormula(wb,worksheet,"D22+E21",21,4);
		insertFormula(wb,worksheet,"E22+F21",21,5);
		insertFormula(wb,worksheet,"F22+G21",21,6);
		insertFormula(wb,worksheet,"H21+G22",21,7);
		
		
		//Total Formula
		insertFormula(wb,worksheet,"SUM(C13:H13)",12,8);
		insertFormula(wb,worksheet,"SUM(C14:H14)",13,8);
		insertFormula(wb,worksheet,"SUM(C15:H15)",14,8);
		
		insertFormula(wb,worksheet,"SUM(I13:I15)",15,8);
		insertFormula(wb,worksheet,"SUM(C17:H17)",16,8);
		
		insertFormula(wb,worksheet,"SUM(C18:H18)",17,8);
		insertFormula(wb,worksheet,"SUM(I17:I18)",18,8);
		
		insertFormula(wb,worksheet,"SUM(C20:H20)",19,8);
		insertFormula(wb,worksheet,"SUM(C21:H21)",20,8);
		
		insertFormula(wb,worksheet,"H22",21,8);
	
		
		
	}












	private void insertTotal_B_excelFormulas(Workbook wb, Sheet worksheet) {
		
		insertFormula(wb,worksheet,"SUM(C17:C18)",18,2);
		insertFormula(wb,worksheet,"SUM(D17:D18)",18,3);
		insertFormula(wb,worksheet,"SUM(E17:E18)",18,4);
		insertFormula(wb,worksheet,"SUM(F17:F18)",18,5);
		insertFormula(wb,worksheet,"SUM(G17:G18)",18,6);
		insertFormula(wb,worksheet,"SUM(H17:H18)",18,7);	
	}












	private void insertTotal_A_excelFormulas(Workbook wb, Sheet worksheet) {
	
		insertFormula(wb,worksheet,"SUM(C14:C15)",15,2);
		insertFormula(wb,worksheet,"SUM(D13:D15)",15,3);
		insertFormula(wb,worksheet,"SUM(E13:E15)",15,4);
		insertFormula(wb,worksheet,"SUM(F13:F15)",15,5);
		insertFormula(wb,worksheet,"SUM(G13:G15)",15,6);
		insertFormula(wb,worksheet,"SUM(H13:H15)",15,7);
	}












	public void insertExcelFormulas(Workbook wb,Sheet worksheet) throws IOException {
		
		
		
		//1-30Days
		insertFormula(wb,worksheet,"SUM(C14:H14)",13,8);
		
		
//		//Total Formula
//		insertFormula(wb,worksheet,"SUM(C14:H14)",13,8);
//		insertFormula(wb,worksheet,"SUM(C15:H15)",14,8);
//		
//		insertFormula(wb,worksheet,"SUM(C17:H17)",16,8);
//		insertFormula(wb,worksheet,"SUM(C18:H18)",17,8);
//		
//		insertFormula(wb,worksheet,"SUM(C20:H20)",19,8);
//		insertFormula(wb,worksheet,"SUM(C21:H21)",20,8);
//		
//		insertFormula(wb,worksheet,"SUM(C23:H23)",22,8);
//		insertFormula(wb,worksheet,"SUM(C24:H24)",23,8);
//		
//		insertFormula(wb,worksheet,"SUM(C26:H26)",25,8);
//		insertFormula(wb,worksheet,"SUM(C27:H27)",26,8);
//		
//		insertFormula(wb,worksheet,"SUM(C29:H29)",28,8);
//		insertFormula(wb,worksheet,"SUM(C30:H30)",29,8);
//		
//		
//		//Percentage formula
//		insertFormula(wb,worksheet,"I14/$I$32*100",13,9);
//		insertFormula(wb,worksheet,"I15/$I$33*100",14,9);
//		
//		insertFormula(wb,worksheet,"I17/$I$32*100",16,9);
//		insertFormula(wb,worksheet,"I18/$I$33*100",17,9);
//		
//		insertFormula(wb,worksheet,"I20/$I$32*100",19,9);
//		insertFormula(wb,worksheet,"I21/$I$33*100",20,9);
//		
//		insertFormula(wb,worksheet,"I23/$I$32*100",22,9);
//		insertFormula(wb,worksheet,"I24/$I$33*100",23,9);
//		
//		insertFormula(wb,worksheet,"I26/$I$32*100",25,9);
//		insertFormula(wb,worksheet,"I27/$I$33*100",26,9);
//		
//		insertFormula(wb,worksheet,"I29/$I$32*100",28,9);
//		insertFormula(wb,worksheet,"I30/$I$33*100",29,9);
//		
//		
//		//Complete Total
//		
//		insertFormula(wb,worksheet,"J14+J17+J20+J23+J26+J29",31,9);
//		insertFormula(wb,worksheet,"J15+J18+J21+J24+J27+J30",32,9);
//		
//		insertFormula(wb,worksheet,"I14+I17+I20+I23+I26+I29",31,8);
//		insertFormula(wb,worksheet,"IF(I15+I18+I21+I24+I27+I30='300'!E70,I15+I18+I21+I24+I27+I130,\"Check Rules!!!\")",32,8);
//		
//		
//		insertFormula(wb,worksheet,"H14+H17+H20+H23+H26+H29",31,7);
//		insertFormula(wb,worksheet,"H15+H18+H21+H24+H27+H30",32,7);
//		
//		
//		insertFormula(wb,worksheet,"G14+G17+G20+G23+G26+G29",31,6);
//		insertFormula(wb,worksheet,"G15+G18+G21+G24+G27+G30",32,6);
//		
//		
//		insertFormula(wb,worksheet,"F14+F17+F20+F23+F26+F29",31,5);
//		insertFormula(wb,worksheet,"F15+F18+F21+F24+F27+F30",32,5);
//		
//		insertFormula(wb,worksheet,"E14+E17+E20+E23+E26+E29",31,4);
//		insertFormula(wb,worksheet,"E15+E18+E21+E24+E27+E30",32,4);
//		
//		
//		insertFormula(wb,worksheet,"D14+D17+D20+D23+D26+D29",31,3);
//		insertFormula(wb,worksheet,"D15+D18+D21+D24+D27+D30",32,3);
//		
//		
//		insertFormula(wb,worksheet,"C14+C17+C20+C23+C26+C29",31,2);
//		insertFormula(wb,worksheet,"C15+C18+C21+C24+C27+C30",32,2);
		
		
	}
	
	
	
	
	public void insertFormula(Workbook wb,Sheet worksheet,String formula,int rowNum,int cellNum  ) {
		
		Cell cell = null;
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		String cellFormula= formula;
		cell.setCellType(CellType.FORMULA);
		cell.setCellFormula(cellFormula);
	}

	
	
	
}
