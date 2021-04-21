package com.efass.sheet.mmfbr300;

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
import com.efass.specials.SpecialData;

@Service
public class sheet300_Util {

	@Autowired
	Validation validation;
	
	@Autowired
	sheet300TemporaryRepository _300TemporaryRepository;
	

	public Boolean writeSpecificList(List<List<Object>> listOfLists, LocalDate Date, String folderPath)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {

		_300TemporaryRepository.deleteAll(); // this is where i put the delete method
		
		String Path = folderPath + "/cbn_MFB_rpt_12345m052087.xlsx";
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

//			String amount = (String) listAtI.get(0);

			String _amount = ((listAtI.get(0) == null) ? "0" : listAtI.get(0).toString());

			double __amount = Double.parseDouble(_amount);

			int amount = validation.roundUP(__amount);
			String code = listAtI.get(1).toString();

			Sheet worksheet = wb.getSheet("300");
			// declare a Cell object

//			if (code.equals("10110") || code.equals("10120") || code.equals("10130")) {
//				insertAssets(Path, wb, fsIP, code, amount);
//			}
			
			
			insertDueFrom(Path, wb, fsIP, code, amount);

			rowNum++;

		}

		return true;
	}

//	public void insertAssets(String Path, Workbook wb, FileInputStream fsIP, String code, int amount)
//			throws IOException {
//
//		Sheet worksheet = wb.getSheet("001");
//		// declare a Cell object
//
//		Cell cell = null;
//		cell = worksheet.getRow(15).getCell(4);
//		cell.setCellValue(amount);
//
//		Cell cell11 = null;
//		cell11 = worksheet.getRow(16).getCell(4);
//		cell11.setCellValue(amount);
//
//		Cell cell22 = null;
//		cell22 = worksheet.getRow(17).getCell(5);
//		String formula = "SUM(D15:D16)";
//		cell22.setCellType(CellType.FORMULA);
//		cell22.setCellFormula(formula);
//
//		Cell cell23 = null;
//		cell23 = worksheet.getRow(17).getCell(6);
//		String formula2 = "E17";
//		cell23.setCellType(CellType.FORMULA);
//		cell23.setCellFormula(formula2);
//
//		// Close the InputStream
//		fsIP.close();
//		// Open FileOutputStream to write updates
//
//		FileOutputStream output_file = new FileOutputStream(new File(Path));
//
//		wb.write(output_file);
//		// close the stream
//		output_file.close();
//
//	}

	public void insertDueFrom(String Path, Workbook wb, FileInputStream fsIP, String code, int amount)
			throws IOException {

		Sheet worksheet = wb.getSheet("300");
		// declare a Cell object

		// Insert Formula
		Cell cell023 = null;
		cell023 = worksheet.getRow(16).getCell(4);
		String formula02 = "SUM(D15:D16)";
		cell023.setCellType(CellType.FORMULA);
		cell023.setCellFormula(formula02);

		Cell cell024 = null;
		cell024 = worksheet.getRow(16).getCell(5);
		String formula024 = "E17";
		cell024.setCellType(CellType.FORMULA);
		cell024.setCellFormula(formula024);
		
		
		Cell cell23 = null;
		cell23 = worksheet.getRow(19).getCell(3);
		String formula2 = "'221'!D48";
		cell23.setCellType(CellType.FORMULA);
		cell23.setCellFormula(formula2);

		Cell cell24 = null;
		cell24 = worksheet.getRow(19).getCell(4);
		String formula24 = "D20";
		cell24.setCellType(CellType.FORMULA);
		cell24.setCellFormula(formula24);

		Cell cell25 = null;
		cell25 = worksheet.getRow(21).getCell(3);
		String formula25 = "'311'!F39";
		cell25.setCellType(CellType.FORMULA);
		cell25.setCellFormula(formula25);

		Cell cell26 = null;
		cell26 = worksheet.getRow(22).getCell(3);
		String formula26 = "'321'!F32";   //****
		cell26.setCellType(CellType.FORMULA);
		cell26.setCellFormula(formula26);

		Cell cell27 = null;
		cell27 = worksheet.getRow(23).getCell(4);
		String formula27 = "SUM(D22:D23)";
		cell27.setCellType(CellType.FORMULA);
		cell27.setCellFormula(formula27);

		Cell cell28 = null;
		cell28 = worksheet.getRow(24).getCell(5);
		String formula28 = "SUM(E20:E24)";
		cell28.setCellType(CellType.FORMULA);
		cell28.setCellFormula(formula28);

		Cell cell29 = null;    //***
		cell29 = worksheet.getRow(26).getCell(4);
		String formula29 = "D27";
		cell29.setCellType(CellType.FORMULA);
		cell29.setCellFormula(formula29);
		
		Cell cell29i = null;    //***
		cell29i = worksheet.getRow(26).getCell(5);
		String formula29i = "E27";
		cell29i.setCellType(CellType.FORMULA);
		cell29i.setCellFormula(formula29i);

		Cell cell30 = null;
		cell30 = worksheet.getRow(31).getCell(3);
		String formula30 = "'641'!D42";
		cell30.setCellType(CellType.FORMULA);
		cell30.setCellFormula(formula30);

		Cell cell31 = null;
		cell31 = worksheet.getRow(32).getCell(4);
		String formula31 = "SUM(D29:D32)";
		cell31.setCellType(CellType.FORMULA);
		cell31.setCellFormula(formula31);

		Cell cell32 = null;
		cell32 = worksheet.getRow(32).getCell(5);
		String formula32 = "E33";
		cell32.setCellType(CellType.FORMULA);
		cell32.setCellFormula(formula32);
		
		Cell cell33 = null;
		cell33 = worksheet.getRow(34).getCell(3);
		String formula33 = "'711'!D20";
		cell33.setCellType(CellType.FORMULA);
		cell33.setCellFormula(formula33);
		
		Cell cell34 = null;
		cell34 = worksheet.getRow(39).getCell(3);
		String formula34 = "'746'!F16";
		cell34.setCellType(CellType.FORMULA);
		cell34.setCellFormula(formula34);
		
		Cell cell35 = null;
		cell35 = worksheet.getRow(41).getCell(4);
		String formula35 = "SUM(D35:D41)";
		cell35.setCellType(CellType.FORMULA);
		cell35.setCellFormula(formula35);
		
		Cell cell36 = null;
		cell36 = worksheet.getRow(42).getCell(3);
		String formula36 = "'711'!D20";
		cell36.setCellType(CellType.FORMULA);
		cell36.setCellFormula(formula36);
		
		Cell cell37 = null;
		cell37 = worksheet.getRow(43).getCell(3);
		String formula37 = "0.01*'761'!D12";
		cell37.setCellType(CellType.FORMULA);
		cell37.setCellFormula(formula37);
		
		
		Cell cell38 = null;
		cell38 = worksheet.getRow(44).getCell(4);
		String formula38 = "D43+D44";
		cell38.setCellType(CellType.FORMULA);
		cell38.setCellFormula(formula38);
		
		
		Cell cell39 = null;
		cell39 = worksheet.getRow(44).getCell(4);
		String formula39 = "E42-E45";
		cell39.setCellType(CellType.FORMULA);
		cell39.setCellFormula(formula39);
		
		Cell cell40 = null;
		cell40 = worksheet.getRow(47).getCell(3);
		String formula40 = "'811'!E22";
		cell40.setCellType(CellType.FORMULA);
		cell40.setCellFormula(formula40);
		
		Cell cell41 = null;
		cell41 = worksheet.getRow(49).getCell(4);
		String formula41 = "D48-D49";
		cell41.setCellType(CellType.FORMULA);
		cell41.setCellFormula(formula41);
		
		Cell cell42 = null;
		cell42 = worksheet.getRow(49).getCell(5);
		String formula42 = "E50";
		cell42.setCellType(CellType.FORMULA);
		cell42.setCellFormula(formula42);
		
		Cell cell43 = null;
		cell43 = worksheet.getRow(57).getCell(4);
		String formula43 = "SUM(D52:D57)";
		cell43.setCellType(CellType.FORMULA);
		cell43.setCellFormula(formula43);
		
		Cell cell44 = null;
		cell44 = worksheet.getRow(58).getCell(4);
		String formula44 = "D59";
		cell44.setCellType(CellType.FORMULA);
		cell44.setCellFormula(formula44);
		
		Cell cell45 = null;
		cell45 = worksheet.getRow(49).getCell(4);
		String formula45 = "E58-E59";
		cell45.setCellType(CellType.FORMULA);
		cell45.setCellFormula(formula45);
		

		Cell cell46 = null;
		cell46 = worksheet.getRow(60).getCell(5);
		String formula46 = "F60+F50+F46+F33+F27+F25+F17";
		cell46.setCellType(CellType.FORMULA);
		cell46.setCellFormula(formula46);
		
		
		
//		LIABILITIES
		Cell cell47 = null;
		cell47 = worksheet.getRow(68).getCell(3);
		String formula47 = "'141'!D47";
		cell47.setCellType(CellType.FORMULA);
		cell47.setCellFormula(formula47);

		Cell cell48 = null;
		cell48 = worksheet.getRow(69).getCell(4);
		String formula48 = "D65:D69";
		cell48.setCellType(CellType.FORMULA);
		cell48.setCellFormula(formula48);

		Cell cell49 = null;
		cell49 = worksheet.getRow(69).getCell(5);
		String formula49 = "E70";
		cell49.setCellType(CellType.FORMULA);
		cell49.setCellFormula(formula49);

		Cell cell50 = null;
		cell50 = worksheet.getRow(71).getCell(3);
		String formula50 = "'312'!H35";
		cell50.setCellType(CellType.FORMULA);
		cell50.setCellFormula(formula50);

		Cell cell51 = null;
		cell51 = worksheet.getRow(72).getCell(3);
		String formula51 = "'322'!G22";
		cell51.setCellType(CellType.FORMULA);
		cell51.setCellFormula(formula51);

		Cell cell52 = null;
		cell52 = worksheet.getRow(73).getCell(4);
		String formula52 = "D72:D73";
		cell52.setCellType(CellType.FORMULA);
		cell52.setCellFormula(formula52);

		Cell cell53 = null;
		cell53 = worksheet.getRow(73).getCell(5);
		String formula53 = "E74";
		cell53.setCellType(CellType.FORMULA);
		cell53.setCellFormula(formula53);

		Cell cell54 = null;
		cell54 = worksheet.getRow(74).getCell(3);
		String formula54 = "'451'!G22";
		cell54.setCellType(CellType.FORMULA);
		cell54.setCellFormula(formula54);

		Cell cell55 = null;
		cell55 = worksheet.getRow(74).getCell(4);
		String formula55 = "D75";
		cell55.setCellType(CellType.FORMULA);
		cell55.setCellFormula(formula55);

		Cell cell56 = null;
		cell56 = worksheet.getRow(74).getCell(5);
		String formula56 = "E75";
		cell56.setCellType(CellType.FORMULA);
		cell56.setCellFormula(formula56);

		Cell cell57 = null;
		cell57 = worksheet.getRow(75).getCell(3);
		String formula57 = "'501'!D26";
		cell57.setCellType(CellType.FORMULA);
		cell57.setCellFormula(formula57);

		Cell cell58 = null;
		cell58 = worksheet.getRow(75).getCell(4);
		String formula58 = "D76";
		cell58.setCellType(CellType.FORMULA);
		cell58.setCellFormula(formula58);

		Cell cell59 = null;
		cell59 = worksheet.getRow(75).getCell(5);
		String formula59 = "E76";
		cell59.setCellType(CellType.FORMULA);
		cell59.setCellFormula(formula59);

		Cell cell60 = null;
		cell60 = worksheet.getRow(80).getCell(3);
		String formula60 = "'642'!H23";
		cell60.setCellType(CellType.FORMULA);
		cell60.setCellFormula(formula60);

		Cell cell61 = null;
		cell61 = worksheet.getRow(81).getCell(3);
		String formula61 = "'651'!G23";
		cell61.setCellType(CellType.FORMULA);
		cell61.setCellFormula(formula61);

		Cell cell62 = null;
		cell62 = worksheet.getRow(82).getCell(4);
		String formula62 = "SUM(D78:D82)";
		cell62.setCellType(CellType.FORMULA);
		cell62.setCellFormula(formula62);

		Cell cell63 = null;
		cell63 = worksheet.getRow(82).getCell(5);
		String formula63 = "E83";
		cell63.setCellType(CellType.FORMULA);
		cell63.setCellFormula(formula63);

		Cell cell64 = null;
		cell64 = worksheet.getRow(86).getCell(4);
		String formula64 = "SUM(D85:D86)";
		cell64.setCellType(CellType.FORMULA);
		cell64.setCellFormula(formula64);

		Cell cell65 = null;
		cell65 = worksheet.getRow(86).getCell(5);
		String formula65 = "E87";
		cell65.setCellType(CellType.FORMULA);
		cell65.setCellFormula(formula65);

		Cell cell66 = null;
		cell66 = worksheet.getRow(88).getCell(4);
		String formula66 = "D89";
		cell66.setCellType(CellType.FORMULA);
		cell66.setCellFormula(formula66);

		Cell cell67 = null;
		cell67 = worksheet.getRow(92).getCell(4);
		String formula67 = "SUM(D91:D92)";
		cell67.setCellType(CellType.FORMULA);
		cell67.setCellFormula(formula67);

		Cell cell68 = null;
		cell68 = worksheet.getRow(97).getCell(3);
		String formula68 = "'933'!H22";
		cell68.setCellType(CellType.FORMULA);
		cell68.setCellFormula(formula68);

		Cell cell69 = null;
		cell69 = worksheet.getRow(100).getCell(3);
		String formula69 = "'951'!D24";
		cell69.setCellType(CellType.FORMULA);
		cell69.setCellFormula(formula69);

		Cell cell70 = null;
		cell70 = worksheet.getRow(102).getCell(3);
		String formula70 = "IF('1000'!F39<0,'1000'!F39,\"\")";
		cell70.setCellType(CellType.FORMULA);
		cell70.setCellFormula(formula70);

		Cell cell71 = null;
		cell71 = worksheet.getRow(103).getCell(4);
		String formula71 = "SUM(D95:D103)";
		cell71.setCellType(CellType.FORMULA);
		cell71.setCellFormula(formula71);

		Cell cell72 = null;
		cell72 = worksheet.getRow(104).getCell(5);
		String formula72 = "E93+E104";
		cell72.setCellType(CellType.FORMULA);
		cell72.setCellFormula(formula72);

		Cell cell73 = null;
		cell73 = worksheet.getRow(105).getCell(5);
		String formula73 = "F70+F87+F83+F76+F75+F74+F105";
		cell73.setCellType(CellType.FORMULA);
		cell73.setCellFormula(formula73);

		Cell cell74 = null;
		cell74 = worksheet.getRow(106).getCell(5);
		String formula74 = "'996'!D23";
		cell74.setCellType(CellType.FORMULA);
		cell74.setCellFormula(formula74);

		
		


		// insert value

		
		//Cash
		if (code.equals("10110")) {
			insertValue(wb, worksheet, amount, 14, 3);
		} else if (code.equals("10120")) {
			insertValue(wb, worksheet, amount, 15, 3);
		 

		} else if (code.equals("10510")) {
			insertValue(wb, worksheet, amount, 26, 3);
		} 
		else if (code.equals("10610")) {
			insertValue(wb, worksheet, amount, 28, 3);

		} else if (code.equals("10620")) {
			insertValue(wb, worksheet, amount, 29, 3);
		} else if (code.equals("10630")) {
			insertValue(wb, worksheet, amount, 30, 3);
		} else if (code.equals("10720")) {
			insertValue(wb, worksheet, amount, 35, 3);
		} else if (code.equals("10725")) {
			insertValue(wb, worksheet, amount, 36, 3);
		} else if (code.equals("10730")) {
			insertValue(wb, worksheet, amount, 37, 3);
		} else if (code.equals("10740")) {
			insertValue(wb, worksheet, amount, 38, 3);
		} else if (code.equals("10750")) {
			insertValue(wb, worksheet, amount, 40, 3);
		} else if (code.equals("10880")) {
			insertValue(wb, worksheet, amount, 48, 3);
		}
		else if (code.equals("10910")) {
			insertValue(wb, worksheet, amount, 51, 3);
			
		}else if (code.equals("10920")) {
			insertValue(wb, worksheet, amount, 52, 3);
		}else if (code.equals("10930")) {
			insertValue(wb, worksheet, amount, 53, 3);
		}else if (code.equals("10940")) {
			insertValue(wb, worksheet, amount, 54, 3);
		}else if (code.equals("10950")) {
			insertValue(wb, worksheet, amount, 55, 3);
		}else if (code.equals("10960")) {
			insertValue(wb, worksheet, amount, 56, 3);

//		}else if (code.equals("10970")) {
//			insertFormula(wb, worksheet, "SUM(D52:D57)", 58, 5);
		}else if (code.equals("10980")) {
			insertValue(wb, worksheet, amount, 58, 3);
//		}else if (code.equals("10990")) {
//			insertFormula(wb, worksheet, "E58-E59", 60, 6);
//		}else if (code.equals("11000")) {
//			insertFormula(wb, worksheet, "F60+F50+F46+F33+F27+F25+F17", 60, 6);
		}
		
		

		// Liabilities

		if (code.equals("20110")) {
			insertValue(wb, worksheet, amount, 64, 3);
		} else if (code.equals("20120")) {
			insertValue(wb, worksheet, amount, 65, 3);
		} else if (code.equals("20125")) {
			insertValue(wb, worksheet, amount, 66, 3);
		} else if (code.equals("20130")) {
			insertValue(wb, worksheet, amount, 67, 3);
		} else if (code.equals("20610")) {
			insertValue(wb, worksheet, amount, 77, 3);
		} else if (code.equals("20620")) {
			insertValue(wb, worksheet, amount, 78, 3);
		} else if (code.equals("20630")) {
			insertValue(wb, worksheet, amount, 79, 3);
		} else if (code.equals("20710")) {
			insertValue(wb, worksheet, amount, 84, 3);
		} else if (code.equals("20720")) {
			insertValue(wb, worksheet, amount, 85, 3);
		} else if (code.equals("20810")) {
			insertValue(wb, worksheet, amount, 88, 3);
		} else if (code.equals("20830")) {
			insertValue(wb, worksheet, amount, 90, 3);
		} else if (code.equals("20840")) {
			insertValue(wb, worksheet, amount, 91, 3);
		} else if (code.equals("20910")) {
			insertValue(wb, worksheet, amount, 94, 3);
		} else if (code.equals("20920")) {
			insertValue(wb, worksheet, amount, 95, 3);
		} else if (code.equals("20930")) {
			insertValue(wb, worksheet, amount, 96, 3);
		} else if (code.equals("20935")) {
			insertValue(wb, worksheet, amount, 98, 3);
		} else if (code.equals("20940")) {
			insertValue(wb, worksheet, amount, 99, 3);
		} else if (code.equals("20960")) {
			insertValue(wb, worksheet, amount, 101, 3);
		}
		
		
//		else if (code.equals("20140")) {
////	insertFormula(wb, worksheet, "'141'!D47", 69, 3);
//	insertValue(wb, worksheet, amount, 68, 3);
//}
//		else if (code.equals("20200")) {
//	insertFormula(wb, worksheet, "SUM(D65:D69)", 70, 5);
//	insertFormula(wb, worksheet, "E70", 70, 6);
//}else if (code.equals("20310")) {
//	insertFormula(wb, worksheet, "'312'!H35", 72, 4);
//}else if (code.equals("20320")) {
//	insertFormula(wb, worksheet, "'322'!G22", 73, 4);
//}else if (code.equals("20330")) {
//	insertFormula(wb, worksheet, "'SUM(D72:D73)", 74, 5);
//	insertFormula(wb, worksheet, "E74", 74, 5);
//}else if (code.equals("20450")) {
//	insertFormula(wb, worksheet, "451!G22", 75, 5);
//	insertFormula(wb, worksheet, "D75", 75, 5);
//	insertFormula(wb, worksheet, "E75", 75, 5);
//}else if (code.equals("20500")) {
//	insertFormula(wb, worksheet, "'501'!D26", 76, 4);
//	insertFormula(wb, worksheet, "D76", 76, 5);
//	insertFormula(wb, worksheet, "E76", 76, 6);
//}

//}else if (code.equals("20640")) {
//	insertFormula(wb, worksheet, "'642'!H23", 81, 4);
//}else if (code.equals("20650")) {
//	insertFormula(wb, worksheet, "'651'!G23", 82, 4);
//}else if (code.equals("20660")) {
//	insertFormula(wb, worksheet, "SUM(D78:D82)", 83, 5);
//	insertFormula(wb, worksheet, "E87", 83, 6);
//}
//	
//	else if (code.equals("20750")) {
//		insertFormula(wb, worksheet, "SUM(D85:D86)", 87, 5);
//		insertFormula(wb, worksheet, "E87", 87, 5);
//	}
//}else if (code.equals("20860")) {
//	insertFormula(wb, worksheet, "SUM(D91:D92)", 93, 5);
//}
//	else if (code.equals("20965")) {
//		insertFormula(wb, worksheet, "IF('1000'!F39<0,'1000'!F39,\"\")", 92, 5);
//	}
//	else if (code.equals("20970")) {
//		insertFormula(wb, worksheet, "SUM(D95:D103)", 104, 5);
//	}else if (code.equals("20980")) {
//		insertFormula(wb, worksheet, "E93+E104", 105, 6);
//	}else if (code.equals("20990")) {
//		insertFormula(wb, worksheet, "F70+F87+F83+F76+F75+F74+F105", 106, 6);
//	}else if (code.equals("20995")) {
//		insertFormula(wb, worksheet, "'996'!D23", 107, 6);
//	}

// Ended at no. 49, begins at no.10890


		//Liabilities
//		
//		if (code.equals("20110")) {
//			insertValue(wb, worksheet, amount, 64, 3);
//		} else if (code.equals("20120")) {
//			insertValue(wb, worksheet, amount, 65, 3);
//		} 	else if (code.equals("20125")) {
//			insertValue(wb, worksheet, amount, 66, 3);
//		} else if (code.equals("20130")) {
//			insertValue(wb, worksheet, amount, 67, 3);
////		}  else if (code.equals("20140")) {
////			insertFormula(wb, worksheet, "'141'!D47", 69, 4);
////		} else if (code.equals("20200")) {
////			insertFormula(wb, worksheet, "SUM(D65:D69)", 70, 5);
////			insertFormula(wb, worksheet, "E70", 70, 6);
////		}else if (code.equals("20310")) {
////			insertFormula(wb, worksheet, "'312'!H35", 72, 4);
////		}else if (code.equals("20320")) {
////			insertFormula(wb, worksheet, "'322'!G22", 73, 4);
////		}else if (code.equals("20330")) {
////			insertFormula(wb, worksheet, "'SUM(D72:D73)", 74, 5);
////			insertFormula(wb, worksheet, "E74", 74, 5);
////		}else if (code.equals("20450")) {
////			insertFormula(wb, worksheet, "451!G22", 75, 5);
////			insertFormula(wb, worksheet, "D75", 75, 5);
////			insertFormula(wb, worksheet, "E75", 75, 5);
////		}else if (code.equals("20500")) {
////			insertFormula(wb, worksheet, "'501'!D26", 76, 4);
////			insertFormula(wb, worksheet, "D76", 76, 5);
////			insertFormula(wb, worksheet, "E76", 76, 6);
//		}else if (code.equals("20610")) {
//			insertValue(wb, worksheet, amount, 77, 3);
//		}else if (code.equals("20620")) {
//			insertValue(wb, worksheet, amount, 78, 3);
//		}else if (code.equals("20630")) {
//			insertValue(wb, worksheet, amount, 79, 3);
////		}else if (code.equals("20640")) {
////			insertFormula(wb, worksheet, "'642'!H23", 81, 4);
////		}else if (code.equals("20650")) {
////			insertFormula(wb, worksheet, "'651'!G23", 82, 4);
////		}else if (code.equals("20660")) {
////			insertFormula(wb, worksheet, "SUM(D78:D82)", 83, 5);
////			insertFormula(wb, worksheet, "E87", 83, 6);
//		}else if (code.equals("20710")) {
//			insertValue(wb, worksheet, amount, 84, 3);	
//		}else if (code.equals("20720")) {
//			insertValue(wb, worksheet, amount, 85, 3);
////		}else if (code.equals("20750")) {
////			insertFormula(wb, worksheet, "SUM(D85:D86)", 87, 5);
////			insertFormula(wb, worksheet, "E87", 87, 5);
//		}else if (code.equals("20810")) {
//			insertValue(wb, worksheet, amount, 88, 3);
////			insertFormula(wb, worksheet, "D89", 89, 6);
////		}else if (code.equals("20830")) {
////			insertValue(wb, worksheet, amount, 91, 4);
//		}else if (code.equals("20840")) {
//			insertValue(wb, worksheet, amount, 91, 3);
//		}else if (code.equals("20860")) 
//		{
////			insertFormula(wb, worksheet, "SUM(D91:D92)", 93, 5);
////		}
////		
//		}
//		
//		else if (code.equals("20910")) {
//			insertValue(wb, worksheet, amount, 94, 3);
//		}
//		else if (code.equals("20920")) {
//			insertValue(wb, worksheet, amount, 95, 3);
//		}else if (code.equals("20930")) {
//			insertValue(wb, worksheet, amount, 96, 3);
//		}
////		else if (code.equals("20935")) {
////			insertValue(wb, worksheet, amount, 98, 4);
////		}
//		else if (code.equals("20935")) {
//			insertValue(wb, worksheet, amount, 98, 3);
//		}else if (code.equals("20940")) {
//			insertValue(wb, worksheet, amount, 99, 3);
//		}		
////		else if (code.equals("20950")) {
////			insertFormula(wb, worksheet, "'951'!D24", 92, 4);
////		}
//		else if (code.equals("20960")) {
//			insertValue(wb, worksheet, amount, 101, 3);
//		}
//		//else if (code.equals("20960")) 
////		{
////			insertFormula(wb, worksheet, "IF('1000'!F39<0,'1000'!F39,\"\")", 103, 5);
////		}
////		else if (code.equals("20965")) {
////			insertFormula(wb, worksheet, "IF('1000'!F39<0,'1000'!F39,\"\")", 92, 5);
////		}else if (code.equals("20970")) {
////			insertFormula(wb, worksheet, "SUM(D95:D103)", 104, 5);
////		}else if (code.equals("20980")) {
////			insertFormula(wb, worksheet, "E93+E104", 105, 6);
////		}else if (code.equals("20990")) {
////			insertFormula(wb, worksheet, "F70+F87+F83+F76+F75+F74+F105", 106, 6);
////		}else if (code.equals("20995")) {
////			insertFormula(wb, worksheet, "'996'!D23", 107, 6);
////		}
////		
//		
		

		// Ended at no. 49, begins at no.10890

		// Close the InputStream
		fsIP.close();
		// Open FileOutputStream to write updates

		FileOutputStream output_file = new FileOutputStream(new File(Path));

		wb.write(output_file);
		// close the stream
		output_file.close();

	}
	
	
	
	public void insertFormula(Workbook wb,Sheet worksheet,String formula,int rowNum,int cellNum  ) {
		
		Cell cell = null;
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		String cellFormula= formula;
		cell.setCellType(CellType.FORMULA);
		cell.setCellFormula(cellFormula);
		
	}

	public void insertValue(Workbook wb, Sheet worksheet, int amount, int rowNum, int cellNum) {

		Cell cell = null;
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		cell.setCellValue(amount);
	}
}
