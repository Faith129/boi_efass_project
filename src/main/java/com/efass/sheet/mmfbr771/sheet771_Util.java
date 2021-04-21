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
				
				String remark = (String) listAtI.get(11);
				String ninetyOnedays = (String) listAtI.get(10);
				String sixtyOneNinety = (String) listAtI.get(9);
				String thirtyOneSix = (String) listAtI.get(8);
				String oneThirty = (String) listAtI.get(7);
//				String thotNonPerfCred = (String) listAtI.get(7);
				String accruedIntUnpaid = (String) listAtI.get(6);
				String prinPaymentDueUnpaid = (String) listAtI.get(5);
				String amountGranted = (String) listAtI.get(4);
				String _lastRepaymentDate = (String) listAtI.get(3);
				String _pastDueDate = (String) listAtI.get(2);
				String customerName = (String) listAtI.get(1);
				String customerCode = (String) listAtI.get(0);
				

			    System.out.println(_lastRepaymentDate);
		
			    
			    
			    
			    
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
						
					    } 
					    if ( !___lastRepaymentDate.equals("0")) {
					    						
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
		  
		// Insert Formula
		Cell cell01 = null;
		cell01 = worksheet.getRow(19).getCell(13);
		String formula01 = "(0.05*J20)+(0.2*K20)+(0.5*L20)+M20";
		cell01.setCellType(CellType.FORMULA);
		cell01.setCellFormula(formula01);
		
		Cell cell02 = null;
		cell02 = worksheet.getRow(20).getCell(13);
		String formula02 = "(0.05*J21)+(0.2*K21)+(0.5*L21)+M21";
		cell02.setCellType(CellType.FORMULA);
		cell02.setCellFormula(formula02);
		
		Cell cell03 = null;
		cell03 = worksheet.getRow(21).getCell(13);
		String formula03 = "(0.05*J22)+(0.2*K22)+(0.5*L22)+M22";
		cell03.setCellType(CellType.FORMULA);
		cell03.setCellFormula(formula03);
		
		Cell cell04 = null;
		cell04 = worksheet.getRow(22).getCell(13);
		String formula04 = "(0.05*J23)+(0.2*K23)+(0.5*L23)+M23";
		cell04.setCellType(CellType.FORMULA);
		cell04.setCellFormula(formula04);
		
		Cell cell05 = null;
		cell05 = worksheet.getRow(23).getCell(13);
		String formula05 = "(0.05*J24)+(0.2*K24)+(0.5*L24)+M24";
		cell05.setCellType(CellType.FORMULA);
		cell05.setCellFormula(formula05);
		
		Cell cell06 = null;
		cell06 = worksheet.getRow(24).getCell(13);
		String formula06 = "(0.05*J25)+(0.2*K25)+(0.5*L25)+M25";
		cell06.setCellType(CellType.FORMULA);
		cell06.setCellFormula(formula06);
		
		Cell cell07 = null;
		cell07 = worksheet.getRow(25).getCell(13);
		String formula07 = "(0.05*J26)+(0.2*K26)+(0.5*L26)+M26";
		cell07.setCellType(CellType.FORMULA);
		cell07.setCellFormula(formula07);
		
		Cell cell08 = null;
		cell08 = worksheet.getRow(26).getCell(13);
		String formula08 = "(0.05*J27)+(0.2*K27)+(0.5*L27)+M27";
		cell08.setCellType(CellType.FORMULA);
		cell08.setCellFormula(formula08);
		
		Cell cell09 = null;
		cell09 = worksheet.getRow(27).getCell(13);
		String formula09 = "(0.05*J28)+(0.2*K28)+(0.5*L28)+M28";
		cell09.setCellType(CellType.FORMULA);
		cell09.setCellFormula(formula09);
		
		Cell cell010 = null;
		cell010 = worksheet.getRow(28).getCell(13);
		String formula10 = "(0.05*J29)+(0.2*K29)+(0.5*L29)+M29";
		cell010.setCellType(CellType.FORMULA);
		cell010.setCellFormula(formula10);
		
		Cell cell011 = null;
		cell011 = worksheet.getRow(29).getCell(13);
		String formula11 = "(0.05*J30)+(0.2*K30)+(0.5*L30)+M30";
		cell011.setCellType(CellType.FORMULA);
		cell011.setCellFormula(formula11);
		
		Cell cell012 = null;
		cell012 = worksheet.getRow(30).getCell(13);
		String formula012 = "(0.05*J31)+(0.2*K31)+(0.5*L31)+M31";
		cell012.setCellType(CellType.FORMULA);
		cell012.setCellFormula(formula012);
		
		Cell cell013 = null;
		cell013 = worksheet.getRow(31).getCell(13);
		String formula13 = "(0.05*J32)+(0.2*K32)+(0.5*L32)+M32";
		cell013.setCellType(CellType.FORMULA);
		cell013.setCellFormula(formula13);
		
		Cell cell014 = null;
		cell014 = worksheet.getRow(32).getCell(13);
		String formula14 = "(0.05*J33)+(0.2*K33)+(0.5*L33)+M33";
		cell014.setCellType(CellType.FORMULA);
		cell014.setCellFormula(formula14);
		
		Cell cell015 = null;
		cell015 = worksheet.getRow(33).getCell(13);
		String formula15 = "(0.05*J34)+(0.2*K34)+(0.5*L34)+M34";
		cell015.setCellType(CellType.FORMULA);
		cell015.setCellFormula(formula15);
		
		Cell cell016 = null;
		cell016 = worksheet.getRow(34).getCell(13);
		String formula16 = "(0.05*J35)+(0.2*K35)+(0.5*L35)+M35";
		cell016.setCellType(CellType.FORMULA);
		cell016.setCellFormula(formula16);
		
		Cell cell017 = null;
		cell017 = worksheet.getRow(35).getCell(13);
		String formula17 = "(0.05*J36)+(0.2*K36)+(0.5*L36)+M36";
		cell017.setCellType(CellType.FORMULA);
		cell017.setCellFormula(formula17);
		
		Cell cell018 = null;
		cell018 = worksheet.getRow(36).getCell(13);
		String formula18 = "(0.05*J37)+(0.2*K37)+(0.5*L37)+M37";
		cell018.setCellType(CellType.FORMULA);
		cell018.setCellFormula(formula18);
		
		Cell cell019 = null;
		cell019 = worksheet.getRow(37).getCell(13);
		String formula19 = "(0.05*J38)+(0.2*K38)+(0.5*L38)+M38";
		cell019.setCellType(CellType.FORMULA);
		cell019.setCellFormula(formula19);
		
		Cell cell020 = null;
		cell020 = worksheet.getRow(38).getCell(13);
		String formula20 = "(0.05*J39)+(0.2*K39)+(0.5*L39)+M39";
		cell020.setCellType(CellType.FORMULA);
		cell020.setCellFormula(formula20);
		
		Cell cell021 = null;
		cell021 = worksheet.getRow(39).getCell(13);
		String formula21 = "(0.05*J40)+(0.2*K40)+(0.5*L40)+M40";
		cell021.setCellType(CellType.FORMULA);
		cell021.setCellFormula(formula21);
		
		Cell cell022 = null;
		cell022 = worksheet.getRow(40).getCell(13);
		String formula22 = "(0.05*J41)+(0.2*K41)+(0.5*L41)+M41";
		cell022.setCellType(CellType.FORMULA);
		cell022.setCellFormula(formula22);
		
		Cell cell023 = null;
		cell023 = worksheet.getRow(41).getCell(13);
		String formula23 = "(0.05*J42)+(0.2*K42)+(0.5*L42)+M42";
		cell023.setCellType(CellType.FORMULA);
		cell023.setCellFormula(formula23);
		
		Cell cell024 = null;
		cell024 = worksheet.getRow(42).getCell(13);
		String formula24 = "(0.05*J43)+(0.2*K43)+(0.5*L43)+M43";
		cell024.setCellType(CellType.FORMULA);
		cell024.setCellFormula(formula24);
		
		Cell cell025 = null;
		cell025 = worksheet.getRow(43).getCell(13);
		String formula25 = "(0.05*J44)+(0.2*K44)+(0.5*L44)+M44";
		cell025.setCellType(CellType.FORMULA);
		cell025.setCellFormula(formula25);
		
		Cell cell026 = null;
		cell026 = worksheet.getRow(44).getCell(13);
		String formula26 = "(0.05*J45)+(0.2*K45)+(0.5*L45)+M45";
		cell026.setCellType(CellType.FORMULA);
		cell026.setCellFormula(formula26);
		
		Cell cell027 = null;
		cell027 = worksheet.getRow(45).getCell(13);
		String formula27 = "(0.05*J46)+(0.2*K46)+(0.5*L46)+M46";
		cell027.setCellType(CellType.FORMULA);
		cell027.setCellFormula(formula27);
		
		Cell cell028 = null;
		cell028 = worksheet.getRow(46).getCell(13);
		String formula28 = "(0.05*J47)+(0.2*K47)+(0.5*L47)+M47";
		cell028.setCellType(CellType.FORMULA);
		cell028.setCellFormula(formula28);
		
		Cell cell029 = null;
		cell029 = worksheet.getRow(47).getCell(13);
		String formula29 = "(0.05*J48)+(0.2*K48)+(0.5*L48)+M48";
		cell029.setCellType(CellType.FORMULA);
		cell029.setCellFormula(formula29);
		
		Cell cell030 = null;
		cell030 = worksheet.getRow(48).getCell(13);
		String formula30 = "(0.05*J49)+(0.2*K49)+(0.5*L49)+M49";
		cell030.setCellType(CellType.FORMULA);
		cell030.setCellFormula(formula30);
		
		Cell cell031 = null;
		cell031 =worksheet.getRow(49).getCell(13);
		String formula31 = "(0.05*J50)+(0.2*K50)+(0.5*L50)+M50";
		cell031.setCellType(CellType.FORMULA);
		cell031.setCellFormula(formula31);
		
		Cell cell032 = null;
		cell032 = worksheet.getRow(50).getCell(13);
		String formula32 = "(0.05*J51)+(0.2*K51)+(0.5*L51)+M51";
		cell032.setCellType(CellType.FORMULA);
		cell032.setCellFormula(formula32);
		
		Cell cell033 = null;
		cell033 = worksheet.getRow(51).getCell(13);
		String formula33 = "(0.05*J52)+(0.2*K52)+(0.5*L52)+M52";
		cell033.setCellType(CellType.FORMULA);
		cell033.setCellFormula(formula33);
		
		Cell cell034 = null;
		cell034 = worksheet.getRow(52).getCell(13);
		String formula34 = "(0.05*J53)+(0.2*K53)+(0.5*L53)+M53";
		cell034.setCellType(CellType.FORMULA);
		cell034.setCellFormula(formula34);
		
		Cell cell035 = null;
		cell035 = worksheet.getRow(53).getCell(13);
		String formula35 = "(0.05*J54)+(0.2*K54)+(0.5*L54)+M54";
		cell035.setCellType(CellType.FORMULA);
		cell035.setCellFormula(formula35);
		
		Cell cell036 = null;
		cell036 = worksheet.getRow(54).getCell(13);
		String formula36 = "(0.05*J55)+(0.2*K55)+(0.5*L55)+M55";
		cell036.setCellType(CellType.FORMULA);
		cell036.setCellFormula(formula36);
		
		Cell cell037 = null;
		cell037 = worksheet.getRow(55).getCell(13);
		String formula37 ="(0.05*J56)+(0.2*K56)+(0.5*L56)+M56";
		cell037.setCellType(CellType.FORMULA);
		cell037.setCellFormula(formula37);
		
		Cell cell038 = null;
		cell038 = worksheet.getRow(56).getCell(13);
		String formula38 = "(0.05*J57)+(0.2*K57)+(0.5*L57)+M57";
		cell038.setCellType(CellType.FORMULA);
		cell038.setCellFormula(formula38);
		
		Cell cell039 = null;
		cell039 = worksheet.getRow(57).getCell(13);
		String formula39 = "(0.05*J58)+(0.2*K58)+(0.5*L58)+M58";
		cell039.setCellType(CellType.FORMULA);
		cell039.setCellFormula(formula39);
		
		Cell cell040 = null;
		cell040 = worksheet.getRow(58).getCell(13);
		String formula40 = "(0.05*J59)+(0.2*K59)+(0.5*L59)+M59";
		cell040.setCellType(CellType.FORMULA);
		cell040.setCellFormula(formula40);
		
		Cell cell41 = null;
		cell41 = worksheet.getRow(59).getCell(13);
		String formula41 = "(0.05*J60)+(0.2*K60)+(0.5*L60)+M60";
		cell41.setCellType(CellType.FORMULA);
		cell41.setCellFormula(formula41);
		
		Cell cell42 = null;
		cell42 = worksheet.getRow(60).getCell(13);
		String formula42 = "(0.05*J61)+(0.2*K61)+(0.5*L61)+M61";
		cell42.setCellType(CellType.FORMULA);
		cell42.setCellFormula(formula42);
		
		Cell cell43 = null;
		cell43 = worksheet.getRow(61).getCell(13);
		String formula43 = "(0.05*J62)+(0.2*K62)+(0.5*L62)+M62";
		cell43.setCellType(CellType.FORMULA);
		cell43.setCellFormula(formula43);
		
		Cell cell44 = null;
		cell44 = worksheet.getRow(62).getCell(13);
		String formula44 = "(0.05*J63)+(0.2*K63)+(0.5*L63)+M63";
		cell44.setCellType(CellType.FORMULA);
		cell44.setCellFormula(formula44);
		
		Cell cell45 = null;
		cell45 = worksheet.getRow(63).getCell(13);
		String formula45 = "(0.05*J64)+(0.2*K64)+(0.5*L64)+M64";
		cell45.setCellType(CellType.FORMULA);
		cell45.setCellFormula(formula45);
		
		Cell cell46 = null;
		cell46 = worksheet.getRow(64).getCell(13);
		String formula46 = "(0.05*J65)+(0.2*K65)+(0.5*L65)+M65";
		cell46.setCellType(CellType.FORMULA);
		cell46.setCellFormula(formula46);
		
		Cell cell47 = null;
		cell47 = worksheet.getRow(65).getCell(13);
		String formula47 = "(0.05*J66)+(0.2*K66)+(0.5*L66)+M66";
		cell47.setCellType(CellType.FORMULA);
		cell47.setCellFormula(formula47);
		
		Cell cell48 = null;
		cell48 = worksheet.getRow(66).getCell(13);
		String formula48 = "(0.05*J67)+(0.2*K67)+(0.5*L67)+M67";
		cell48.setCellType(CellType.FORMULA);
		cell48.setCellFormula(formula48);
		
		Cell cell49 = null;
		cell49 = worksheet.getRow(67).getCell(13);
		String formula49 = "(0.05*J68)+(0.2*K68)+(0.5*L68)+M68";
		cell49.setCellType(CellType.FORMULA);
		cell49.setCellFormula(formula49);
		
		Cell cell50 = null;
		cell50 = worksheet.getRow(68).getCell(13);
		String formula50 = "(0.05*J69)+(0.2*K69)+(0.5*L69)+M69";
		cell50.setCellType(CellType.FORMULA);
		cell50.setCellFormula(formula50);
		
		Cell cell51 = null;
		cell51 = worksheet.getRow(69).getCell(13);
		String formula51 = "(0.05*J70)+(0.2*K70)+(0.5*L70)+M70";
		cell51.setCellType(CellType.FORMULA);
		cell51.setCellFormula(formula51);
		
		Cell cell52 = null;
		cell52 = worksheet.getRow(70).getCell(13);
		String formula52 = "(0.05*J71)+(0.2*K71)+(0.5*L71)+M71";
		cell52.setCellType(CellType.FORMULA);
		cell52.setCellFormula(formula52);
		
		Cell cell53 = null;
		cell53 = worksheet.getRow(71).getCell(13);
		String formula53 = "(0.05*J72)+(0.2*K72)+(0.5*L72)+M72";
		cell53.setCellType(CellType.FORMULA);
		cell53.setCellFormula(formula53);
		
		Cell cell54 = null;
		cell54 = worksheet.getRow(72).getCell(13);
		String formula54 = "(0.05*J73)+(0.2*K73)+(0.5*L73)+M73";
		cell54.setCellType(CellType.FORMULA);
		cell54.setCellFormula(formula54);
		
		Cell cell55 = null;
		cell55 = worksheet.getRow(73).getCell(13);
		String formula55 = "(0.05*J74)+(0.2*K74)+(0.5*L74)+M74";
		cell55.setCellType(CellType.FORMULA);
		cell55.setCellFormula(formula55);
		
		Cell cell56 = null;
		cell56 = worksheet.getRow(74).getCell(13);
		String formula56 = "(0.05*J75)+(0.2*K75)+(0.5*L75)+M75";
		cell56.setCellType(CellType.FORMULA);
		cell56.setCellFormula(formula56);
		
		Cell cell57 = null;
		cell57 = worksheet.getRow(75).getCell(13);
		String formula57 = "(0.05*J76)+(0.2*K76)+(0.5*L76)+M76";
		cell57.setCellType(CellType.FORMULA);
		cell57.setCellFormula(formula57);
		
		Cell cell58 = null;
		cell58 = worksheet.getRow(76).getCell(13);
		String formula58 = "(0.05*J77)+(0.2*K77)+(0.5*L77)+M77";
		cell58.setCellType(CellType.FORMULA);
		cell58.setCellFormula(formula58);
		
		Cell cell59 = null;
		cell59 = worksheet.getRow(77).getCell(13);
		String formula59 = "(0.05*J78)+(0.2*K78)+(0.5*L78)+M78";
		cell59.setCellType(CellType.FORMULA);
		cell59.setCellFormula(formula59);
		
		Cell cell60 = null;
		cell60 = worksheet.getRow(78).getCell(13);
		String formula60 = "(0.05*J79)+(0.2*K79)+(0.5*L79)+M79";
		cell60.setCellType(CellType.FORMULA);
		cell60.setCellFormula(formula60);
		
		Cell cell61 = null;
		cell61 = worksheet.getRow(79).getCell(13);
		String formula61 = "(0.05*J80)+(0.2*K80)+(0.5*L80)+M80";
		cell61.setCellType(CellType.FORMULA);
		cell61.setCellFormula(formula61);
		
		Cell cell62 = null;
		cell62 = worksheet.getRow(80).getCell(13);
		String formula62 = "(0.05*J81)+(0.2*K81)+(0.5*L81)+M81";
		cell62.setCellType(CellType.FORMULA);
		cell62.setCellFormula(formula62);
		
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


