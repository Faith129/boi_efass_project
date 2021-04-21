
package com.efass.sheet.mmfbr771;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.report.ReportDAO;
import com.efass.report.ReportRepository;
import com.efass.sheet.mmfbr321.sheet321Repository;
import com.efass.specials.DateConverter;
import com.efass.specials.SpecialData;

@Service
public class sheet771_Util {
	
	
	@Autowired
	  ReportRepository ReportRepo ;

	@Autowired
	DateConverter dateConvert;
	
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
			System.out.print("inside 771 2");
			int rowNum = 19;
		
				for (int i = 0; i < listOfLists.size(); i++) {
      				System.out.print("inside 771 3");
				List<Object> listAtI = listOfLists.get(i);
				
				String remark = (String) listAtI.get(13);
				String _bankprov = (String) listAtI.get(12);
				String _ninetyOnedays = (String) listAtI.get(11);
				String _sixtyOneNinety = (String) listAtI.get(10);
				String _thirtyOneSix = (String) listAtI.get(9);
				String _oneThirty = (String) listAtI.get(8);
				String _thotNonPerfCred = (String) listAtI.get(7);
				String _accruedIntUnpaid = (String) listAtI.get(6);
				String _prinPaymentDueUnpaid = (String) listAtI.get(5);
				String _amountGranted = (String) listAtI.get(4);
				String _lastRepaymentDate = (String) listAtI.get(3);
				String _pastDueDate = (String) listAtI.get(2);
				String customerName = (String) listAtI.get(1);
				String customerCode = (String) listAtI.get(0);
				

			    System.out.println(_lastRepaymentDate);
		
			    
			    int amountGranted = Integer.parseInt(_amountGranted) ;
			    int prinPaymentDueUnpaid = Integer.parseInt(_prinPaymentDueUnpaid) ;
			    int accruedIntUnpaid = Integer.parseInt(_accruedIntUnpaid) ;
			    int thotNonPerfCred = Integer.parseInt(_thotNonPerfCred) ;
			    int oneThirty = Integer.parseInt(_oneThirty) ;
			    int thirtyOneSix = Integer.parseInt(_thirtyOneSix) ;
			    int sixtyOneNinety = Integer.parseInt(_sixtyOneNinety) ;
			    int ninetyOnedays = Integer.parseInt(_ninetyOnedays) ;
			    double bankprov = Double.parseDouble(_bankprov) ;
			    
			   CellStyle cellStyle = wb.createCellStyle();
			   CreationHelper createHelper = wb.getCreationHelper();
			   cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
			   
			   
		

		
			   
			   
			   
				
				Sheet worksheet = wb.getSheet("771");
				// declare a Cell object

				
				//Add All Formulas
				insertExcelFormulas( wb,worksheet);
				
				
				
				Cell cell = null;
				// Access the second cell in second row to update the value
				cell = worksheet.getRow(rowNum).getCell(14);
				// Get current cell value value and overwrite the value
				cell.setCellValue(remark);

				Cell cell2 = null;
				// Access the second cell in second row to update the value
				cell2 = worksheet.getRow(rowNum).getCell(12);
				// Get current cell value value and overwrite the value
				cell2.setCellValue(ninetyOnedays);

				Cell cell3 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell3 = worksheet.getRow(rowNum).getCell(11);
				// Get current cell value value and overwrite the value
				cell3.setCellValue(sixtyOneNinety);
				
				
				
				Cell cell4 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell4 = worksheet.getRow(rowNum).getCell(10);
				// Get current cell value value and overwrite the value
				cell4.setCellValue(thirtyOneSix);
				
				
				
				Cell cell5 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell5 = worksheet.getRow(rowNum).getCell(9);
				// Get current cell value value and overwrite the value
				cell5.setCellValue(oneThirty);
				
				

				Cell cell14 = null;
				cell14 = worksheet.getRow(rowNum).getCell(8);
//				 Get current cell value value and overwrite the value
				cell14.setCellValue(thotNonPerfCred);
				
				
				Cell cell15 = null;
				cell15 = worksheet.getRow(rowNum).getCell(13);
//				 Get current cell value value and overwrite the value
				cell15.setCellValue(bankprov);
				
				
				Cell cell6 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell6 = worksheet.getRow(rowNum).getCell(7);
				// Get current cell value value and overwrite the value
				cell6.setCellValue(accruedIntUnpaid);
				
				Cell cell7 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell7 = worksheet.getRow(rowNum).getCell(6);
				// Get current cell value value and overwrite the value
				cell7.setCellValue(prinPaymentDueUnpaid);
				
				
				Cell cell8 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell8 = worksheet.getRow(rowNum).getCell(5);
				// Get current cell value value and overwrite the value
				cell8.setCellValue(amountGranted);
				
				
				
				
			    String sDate0=_lastRepaymentDate;
			    String sDate1 =_pastDueDate;
			    
			    
			    	
				System.out.println("Last Date : " +sDate0);
		    	System.out.println("Past Date: "+ sDate1);
			    
				
				String ___lastRepaymentDate =(( sDate0== null) ? "0" : sDate0.toString());
				String ___pastDueDate =(( sDate1== null) ? "0" : sDate1.toString());
					
					    if ( !___pastDueDate.equals("0")) {
					    	
					    	System.out.println("Last Date : " +___pastDueDate);
						    
//						    Date pastDueDate1=dateConvert.changeDateToGregorian(sDate1);
						Cell cell11 = null;
						// int cellNum3 =cellNum-3;
						// Access the second cell in second row to update the value
						cell11 = worksheet.getRow(rowNum).getCell(3);
						// Get current cell value value and overwrite the value
						cell11.setCellValue(___pastDueDate);
						cell11.setCellStyle(cellStyle);
						
					    }if ( !___lastRepaymentDate.equals("0")) {
					    						
						System.out.println("last repayment Date: "+ sDate0);
				    	
//					   	 Date lastRepaymentDate1=dateConvert.changeDateToGregorian(sDate0);	
						Cell cell10 = null;
						// int cellNum3 =cellNum-3;
						// Access the second cell in second row to update the value
						cell10 = worksheet.getRow(rowNum).getCell(4);
						// Get current cell value value and overwrite the value
						
						cell10.setCellValue(___lastRepaymentDate);
						cell10.setCellStyle(cellStyle);
			   
					    }
				

				Cell cell12 = null;
				// int cellNum3 =cellNum-3;
				// Access the second cell in second row to update the value
				cell12 = worksheet.getRow(rowNum).getCell(2);
				// Get current cell value value and overwrite the value
				cell12.setCellValue(customerName);
				
				
				Cell cell13 = null;
				// int cellNum3 =cellNum-3;
				cell13 = worksheet.getRow(rowNum).getCell(1);
				// Get current cell value value and overwrite the value
				cell13.setCellValue(customerCode);
				
				
				
				// Insert Formula
				
				Cell cell_100 = null;
				cell_100 = worksheet.getRow(14).getCell(5);
				String formula_11 = "SUM(F20:F65281)";
				cell_100.setCellType(CellType.FORMULA);
				cell_100.setCellFormula(formula_11);
				
				Cell cell101 = null;
				cell101 = worksheet.getRow(14).getCell(6);
				String formula12 = "SUM(G20:G65281)";
				cell101.setCellType(CellType.FORMULA);
				cell101.setCellFormula(formula12);
				
				Cell cell102 = null;
				cell102 = worksheet.getRow(14).getCell(7);
				String formula13 = "SUM(H20:H65281)";
				cell102.setCellType(CellType.FORMULA);
				cell102.setCellFormula(formula13);
				
				Cell cell103 = null;
				cell103 = worksheet.getRow(14).getCell(8);
				String formula14 = "SUM(I20:I65281)";
				cell103.setCellType(CellType.FORMULA);
				cell103.setCellFormula(formula14);
				
				Cell cell104 = null;
				cell104 = worksheet.getRow(14).getCell(9);
				String formula15 = "SUM(J20:J65281)";
				cell104.setCellType(CellType.FORMULA);
				cell104.setCellFormula(formula15);
			
				Cell cell105 = null;
				cell105 = worksheet.getRow(14).getCell(10);
				String formula16 = "SUM(K20:K65281)";
				cell105.setCellType(CellType.FORMULA);
				cell105.setCellFormula(formula16);
				
				
				Cell cell106 = null;
				cell106 = worksheet.getRow(14).getCell(11);
				String formula17 = "SUM(L20:L65281)";
				cell106.setCellType(CellType.FORMULA);
				cell106.setCellFormula(formula17);
				
			
				Cell cell107 = null;
				cell107 = worksheet.getRow(14).getCell(12);
				String formula18 = "SUM(M20:M65281)";
				cell107.setCellType(CellType.FORMULA);
				cell107.setCellFormula(formula18);
				
			
				
				
				Cell _cell109 = null;
				_cell109 = worksheet.getRow(14).getCell(13);
				String _formula20 = "SUM(N20:N65281)";
				_cell109.setCellType(CellType.FORMULA);
				_cell109.setCellFormula(_formula20);
				

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
				System.out.println("sheet 771works");

				rowNum++;
			}

			return true;
		}
	
	
	
	
	
	public void insertExcelFormulas(Workbook wb,Sheet worksheet) throws IOException {
		
		  worksheet = wb.getSheet("771");

		
//		Cell cell02 = null;
//		cell02 = worksheet.getRow(20).getCell(8);
//		String formula02 = "G21+H21";
//		cell02.setCellType(CellType.FORMULA);
//		cell02.setCellFormula(formula02);
//		
//		Cell cell03 = null;
//		cell03 = worksheet.getRow(21).getCell(8);
//		String formula03 = "G22+H22";
//		cell03.setCellType(CellType.FORMULA);
//		cell03.setCellFormula(formula03);
		
		
		
		
		
		
		
//		
//		Cell cell04 = null;
//		cell04 = worksheet.getRow(22).getCell(8);
//		String formula04 = "G23+H23";
//		cell04.setCellType(CellType.FORMULA);
//		cell04.setCellFormula(formula04);
//		
//		Cell cell05 = null;
//		cell05 = worksheet.getRow(23).getCell(8);
//		String formula05 = "G24+H24";
//		cell05.setCellType(CellType.FORMULA);
//		cell05.setCellFormula(formula05);
//		
//		Cell cell06 = null;
//		cell06 = worksheet.getRow(24).getCell(8);
//		String formula06 = "G25+H25";
//		cell06.setCellType(CellType.FORMULA);
//		cell06.setCellFormula(formula06);
//		
//		Cell cell07 = null;
//		cell07 = worksheet.getRow(25).getCell(8);
//		String formula07 = "G26+H26";
//		cell07.setCellType(CellType.FORMULA);
//		cell07.setCellFormula(formula07);
//		
//		Cell cell08 = null;
//		cell08 = worksheet.getRow(26).getCell(8);
//		String formula08 = "G27+H27";
//		cell08.setCellType(CellType.FORMULA);
//		cell08.setCellFormula(formula08);
//		
//		Cell cell09 = null;
//		cell09 = worksheet.getRow(27).getCell(8);
//		String formula09 = "G28+H28";
//		cell09.setCellType(CellType.FORMULA);
//		cell09.setCellFormula(formula09);
//		
//		Cell cell010 = null;
//		cell010 = worksheet.getRow(28).getCell(8);
//		String formula10 = "G29+H29";
//		cell010.setCellType(CellType.FORMULA);
//		cell010.setCellFormula(formula10);
//		
//		Cell cell011 = null;
//		cell011 = worksheet.getRow(29).getCell(8);
//		String formula11 = "G30+H30";
//		cell011.setCellType(CellType.FORMULA);
//		cell011.setCellFormula(formula11);
//		
//		Cell cell012 = null;
//		cell012 = worksheet.getRow(30).getCell(8);
//		String formula012 = "G31+H31";
//		cell012.setCellType(CellType.FORMULA);
//		cell012.setCellFormula(formula012);
//		
//		Cell cell013 = null;
//		cell013 = worksheet.getRow(31).getCell(8);
//		String formula13 = "G32+H32";
//		cell013.setCellType(CellType.FORMULA);
//		cell013.setCellFormula(formula13);
//		
//		Cell cell014 = null;
//		cell014 = worksheet.getRow(32).getCell(8);
//		String formula14 = "G33+H33";
//		cell014.setCellType(CellType.FORMULA);
//		cell014.setCellFormula(formula14);
//		
//		Cell cell015 = null;
//		cell015 = worksheet.getRow(33).getCell(8);
//		String formula15 = "G34+H34";
//		cell015.setCellType(CellType.FORMULA);
//		cell015.setCellFormula(formula15);
//		
//		Cell cell016 = null;
//		cell016 = worksheet.getRow(34).getCell(8);
//		String formula16 = "G35+H35";
//		cell016.setCellType(CellType.FORMULA);
//		cell016.setCellFormula(formula16);
//		
//		Cell cell017 = null;
//		cell017 = worksheet.getRow(35).getCell(8);
//		String formula17 = "G36+H36";
//		cell017.setCellType(CellType.FORMULA);
//		cell017.setCellFormula(formula17);
//		
//		Cell cell018 = null;
//		cell018 = worksheet.getRow(36).getCell(8);
//		String formula18 = "G37+H37";
//		cell018.setCellType(CellType.FORMULA);
//		cell018.setCellFormula(formula18);
//		
//		Cell cell019 = null;
//		cell019 = worksheet.getRow(37).getCell(8);
//		String formula19 = "G39+H38";
//		cell019.setCellType(CellType.FORMULA);
//		cell019.setCellFormula(formula19);
//		
//		Cell cell020 = null;
//		cell020 = worksheet.getRow(38).getCell(8);
//		String formula20 = "G39+H39";
//		cell020.setCellType(CellType.FORMULA);
//		cell020.setCellFormula(formula20);
//		
//		Cell cell021 = null;
//		cell021 = worksheet.getRow(39).getCell(8);
//		String formula21 = "G40+H40";
//		cell021.setCellType(CellType.FORMULA);
//		cell021.setCellFormula(formula21);
//		
//		Cell cell022 = null;
//		cell022 = worksheet.getRow(40).getCell(8);
//		String formula22 = "G41+H41";
//		cell022.setCellType(CellType.FORMULA);
//		cell022.setCellFormula(formula22);
//		
//		Cell cell023 = null;
//		cell023 = worksheet.getRow(41).getCell(8);
//		String formula23 = "G42+H42";
//		cell023.setCellType(CellType.FORMULA);
//		cell023.setCellFormula(formula23);
//		
//		Cell cell024 = null;
//		cell024 = worksheet.getRow(42).getCell(8);
//		String formula24 = "G43+H43";
//		cell024.setCellType(CellType.FORMULA);
//		cell024.setCellFormula(formula24);
//		
//		Cell cell025 = null;
//		cell025 = worksheet.getRow(43).getCell(8);
//		String formula25 = "G44+H44";
//		cell025.setCellType(CellType.FORMULA);
//		cell025.setCellFormula(formula25);
//		
//		Cell cell026 = null;
//		cell026 = worksheet.getRow(44).getCell(8);
//		String formula26 = "G45+H45";
//		cell026.setCellType(CellType.FORMULA);
//		cell026.setCellFormula(formula26);
//		
//		Cell cell027 = null;
//		cell027 = worksheet.getRow(45).getCell(8);
//		String formula27 = "G46+H46";
//		cell027.setCellType(CellType.FORMULA);
//		cell027.setCellFormula(formula27);
//		
//		Cell cell028 = null;
//		cell028 = worksheet.getRow(46).getCell(8);
//		String formula28 = "G47+H47";
//		cell028.setCellType(CellType.FORMULA);
//		cell028.setCellFormula(formula28);
//		
//		Cell cell029 = null;
//		cell029 = worksheet.getRow(47).getCell(8);
//		String formula29 = "G48+H48";
//		cell029.setCellType(CellType.FORMULA);
//		cell029.setCellFormula(formula29);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
//		
//		Cell cell030 = null;
//		cell030 = worksheet.getRow(48).getCell(8);
//		String formula30 = "G49+H49";
//		cell030.setCellType(CellType.FORMULA);
//		cell030.setCellFormula(formula30);
		
	}
	
	
	
	
	public void insertFormula(Workbook wb,Sheet worksheet,String formula,int rowNum,int cellNum  ) {
		
		Cell cell = null;
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		String cellFormula= formula;
		cell.setCellType(CellType.FORMULA);
		cell.setCellFormula(cellFormula);
	}
	
	
	
	
	
	
	public String getFolderPathWithDate(LocalDate date) {

		ReportDAO Data = ReportRepo.findByPathDate(date.toString());
		String folderPath = Data.getFile_path();

		System.out.println("Folder Path:" + folderPath);
		return folderPath;
	}

}

