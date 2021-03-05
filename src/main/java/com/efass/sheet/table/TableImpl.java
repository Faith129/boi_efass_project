package com.efass.sheet.table;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class TableImpl implements TableService {

	
	public  ResponseEntity<?> AssetsTableData() {
	
		
		List<TabSheet> table = new ArrayList<TabSheet>();
		
		TabSheet data = new TabSheet();
		data.setSheetNumber("MMFBR221");
		data.setReturnCode("Form MMFBR211");
		data.setBankCode("51253");
		data.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data.setReturnName("Schedule of Balances Due from other Banks in Nigeria");
		data.setStateName("LAGOS");
		data.setStateCode("20");
		data.setLgaName("Ikeja");
		data.setLgaCode("0");
		table.add(data);
		
		
		
		
		
		TabSheet data2 = new TabSheet();
		data2.setSheetNumber("MMFBR311");
		data2.setReturnCode("Form MMFBR311");
		data2.setBankCode("51253");
		data2.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data2.setReturnName("Schedule of Secured Placements with Banks/Discount Houses");
		data2.setStateName("LAGOS");
		data2.setStateCode("20");
		data2.setLgaName("Ikeja");
		data2.setLgaCode("0");
		table.add(data2);
		
		
		
		
		TabSheet data3 = new TabSheet();
		data3.setSheetNumber("MMFBR321");
		data3.setReturnCode("Form MMFBR321");
		data3.setBankCode("51253");
		data3.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data3.setReturnName("Schedule of Unsecured Placements with Banks/Discount Houses");
		data3.setStateName("LAGOS");
		data3.setStateCode("20");
		data3.setLgaName("Ikeja");
		data3.setLgaCode("0");
		table.add(data3);
		
		
		
		
		
		
		TabSheet data4 = new TabSheet();
		data4.setSheetNumber("MMFBR641");
		data4.setReturnCode("Form MMFBR641");
		data4.setBankCode("51254");
		data4.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data4.setReturnName("Schedule of Other Long-term Investments");
		data4.setStateName("LAGOS");
		data4.setStateCode("20");
		data4.setLgaName("Ikeja");
		data4.setLgaCode("0");
		table.add(data4);
		
		
		
		
		TabSheet data5 = new TabSheet();
		data5.setSheetNumber("MMFBR711");
		data5.setReturnCode("Form MMFBR711");
		data5.setBankCode("51255");
		data5.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data5.setReturnName("Schedule of Micro Loans by Lending Models");
		data5.setStateName("LAGOS");
		data5.setStateCode("20");
		data5.setLgaName("Ikeja");
		data5.setLgaCode("0");
		table.add(data5);
		
		
		
		TabSheet data6 = new TabSheet();
		data6.setSheetNumber("MMFBR746");
		data6.setReturnCode("Form MMFBR746");
		data6.setBankCode("61266");
		data6.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data6.setReturnName("Breakdown of Other Loans");
		data6.setStateName("LAGOS");
		data6.setStateCode("20");
		data6.setLgaName("Ikeja");
		data6.setLgaCode("0");
		table.add(data6);
		
		
		

		TabSheet data7 = new TabSheet();
		data7.setSheetNumber("MMFBR761");
		data7.setReturnCode("Form MMFBR761");
		data7.setBankCode("51253");
		data7.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data7.setReturnName("Summary of Loan Classification");
		data7.setStateName("LAGOS");
		data7.setStateCode("20");
		data7.setLgaName("Ikeja");
		data7.setLgaCode("0");
		table.add(data7);
		
		
		
		
		TabSheet data8 = new TabSheet();
		data8.setSheetNumber("MMFBR771");
		data8.setReturnCode("Form MMFBR771");
		data8.setBankCode(null);
		data8.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data8.setReturnName("Summary of Non Performing Loans");
		data8.setStateName("LAGOS");
		data8.setStateCode("20");
		data8.setLgaName("Ikeja");
		data8.setLgaCode("0");
		table.add(data8);
		
		
		
		
		
		TabSheet data9 = new TabSheet();
		data9.setSheetNumber("MMFBR762");
		data9.setReturnCode("Form MMFBR762");
		data9.setBankCode("51253");
		data9.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data9.setReturnName("Sectoral Analysis of Loans and Advances");
		data9.setStateName("LAGOS");
		data9.setStateCode("20");
		data9.setLgaName("Ikeja");
		data9.setLgaCode("0");
		table.add(data9);
		
		
		
		
		TabSheet data10 = new TabSheet();
		data10.setSheetNumber("MMFBR763");
		data10.setReturnCode("Form MMFBR763");
		data10.setBankCode("51253");
		data10.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data10.setReturnName("Schedule of Loans Structure and Maturity Profile");
		data10.setStateName("LAGOS");
		data10.setStateCode("20");
		data10.setLgaName("Ikeja");
		data10.setLgaCode("0");
		table.add(data10);
		
		
		TabSheet data11 = new TabSheet();
		data11.setSheetNumber("MMFBR764");
		data11.setReturnCode("Form MMFBR764");
		data11.setBankCode("51253");
		data11.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data11.setReturnName("Schedule of Interest Rates");
		data11.setStateName("LAGOS");
		data11.setStateCode("20");
		data11.setLgaName("Ikeja");
		data11.setLgaCode("0");
		table.add(data11);
		
		
		
		TabSheet data12 = new TabSheet();
		data12.setSheetNumber("MMFBR812");
		data12.setReturnCode("Form MMFBR812");
		data12.setBankCode(null);
		data12.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data12.setReturnName("Schedule of Other Assets");
		data12.setStateName("LAGOS");
		data12.setStateCode("20");
		data12.setLgaName("Ikeja");
		data12.setLgaCode("0");
		table.add(data12);
		
		
		
		TabSheet data13 = new TabSheet();
		data13.setSheetNumber("MMFBR141");
		data13.setReturnCode("Form MMFBR141");
		data13.setBankCode("51253");
		data13.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data13.setReturnName("Schedule of Other Deposits");
		data13.setStateName("LAGOS");
		data13.setStateCode("20");
		data13.setLgaName("Ikeja");
		data13.setLgaCode("0");
		table.add(data13);
		
		
		
		
		TabSheet data14 = new TabSheet();
		data14.setSheetNumber("MMFBR201");
		data14.setReturnCode("Form MMFBR201");
		data14.setBankCode("51253");
		data14.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data14.setReturnName("Schedule of Other Deposits");
		data14.setStateName("LAGOS");
		data14.setStateCode("20");
		data14.setLgaName("Ikeja");
		data14.setLgaCode("0");
		table.add(data14);
		
		
		
		
		
		TabSheet data15 = new TabSheet();
		data15.setSheetNumber("MMFBR202");
		data15.setReturnCode("Form MMFBR202");
		data15.setBankCode("51253");
		data15.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data15.setReturnName("Schedule of Insured Deposit");
		data15.setStateName("LAGOS");
		data15.setStateCode("20");
		data15.setLgaName("Ikeja");
		data15.setLgaCode("0");
		table.add(data15);
		
	
		
		
		
		TabSheet data16 = new TabSheet();
		data16.setSheetNumber("MMFBR312");
		data16.setReturnCode("Form MMFBR312");
		data16.setBankCode("51253");
		data16.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data16.setReturnName("Schedules of Takings From Banks in Nigeria");
		data16.setStateName("LAGOS");
		data16.setStateCode("20");
		data16.setLgaName("Ikeja");
		data16.setLgaCode("0");
		table.add(data16);	
		
		
		TabSheet data17 = new TabSheet();
		data17.setSheetNumber("MMFBR322");
		data17.setReturnCode("Form MMFBR322");
		data17.setBankCode("51253");
		data17.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data17.setReturnName("Breakdown of Takings From Other Institutions");
		data17.setStateName("LAGOS");
		data17.setStateCode("20");
		data17.setLgaName("Ikeja");
		data17.setLgaCode("0");
		table.add(data17);
		
		
		TabSheet data18 = new TabSheet();
		data18.setSheetNumber("MMFBR451");
		data18.setReturnCode("Form MMFBR451");
		data18.setBankCode("51253");
		data18.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data18.setReturnName("Schedule of Re-financing Facilities");
		data18.setStateName("LAGOS");
		data18.setStateCode("20");
		data18.setLgaName("Ikeja");
		data18.setLgaCode("0");
		table.add(data18);
		
		
		
		TabSheet data19 = new TabSheet();
		data19.setSheetNumber("MMFBR501");
		data19.setReturnCode("Form MMFBR501");
		data19.setBankCode("51253");
		data19.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data19.setReturnName("Schedule of Other Liabilities	");
		data19.setStateName("LAGOS");
		data19.setStateCode("20");
		data19.setLgaName("Ikeja");
		data19.setLgaCode("0");
		table.add(data19);
		
		
		
		TabSheet data20 = new TabSheet();
		data20.setSheetNumber("MMFBR642");
		data20.setReturnCode("Form MMFBR642");
		data20.setBankCode("51253");
		data20.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data20.setReturnName("Schedule of Borrowings from Foreign Agencies");
		data20.setStateName("LAGOS");
		data20.setStateCode("20");
		data20.setLgaName("Ikeja");
		data20.setLgaCode("0");
		table.add(data20);
		
		
		
		TabSheet data21 = new TabSheet();
		data21.setSheetNumber("MMFBR651");
		data21.setReturnCode("Form MMFBR651");
		data21.setBankCode(null);
		data21.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data21.setReturnName("Schedule of Borrowings from Other Agencies");
		data21.setStateName("LAGOS");
		data21.setStateCode("21");
		data21.setLgaName("Ikeja");
		data21.setLgaCode("0");
		table.add(data21);
		
		
		
		TabSheet data22 = new TabSheet();
		data22.setSheetNumber("MMFBR933");
		data22.setReturnCode("Form MMFBR933");
		data22.setBankCode(null);
		data22.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data22.setReturnName("Schedule of Deferred Grants & Donation Reserves");
		data22.setStateName("LAGOS");
		data22.setStateCode("22");
		data22.setLgaName("Ikeja");
		data22.setLgaCode("0");
		table.add(data22);
		
		
		
		TabSheet data23 = new TabSheet();
		data23.setSheetNumber("MMFBR951");
		data23.setReturnCode("Form MMFBR951");
		data23.setBankCode(null);
		data23.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data23.setReturnName("Schedule of Other Reserves");
		data23.setStateName("LAGOS");
		data23.setStateCode("23");
		data23.setLgaName("Ikeja");
		data23.setLgaCode("0");
		table.add(data23);
		
		
		
		TabSheet data24 = new TabSheet();
		data24.setSheetNumber("MMFBR996");
		data24.setReturnCode("Form MMFBR996");
		data24.setBankCode("51253");
		data24.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data24.setReturnName("Schedule of Off Balance Sheet Engagements");
		data24.setStateName("LAGOS");
		data24.setStateCode("24");
		data24.setLgaName("Ikeja");
		data24.setLgaCode("0");
		table.add(data24);
		
		
		TabSheet data25 = new TabSheet();
		data25.setSheetNumber("MMFBR980");
		data25.setReturnCode("Form MMFBR980");
		data25.setBankCode("51253");
		data25.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data25.setReturnName("Gap Analysis");
		data25.setStateName("LAGOS");
		data25.setStateCode("24");
		data25.setLgaName("Ikeja");
		data25.setLgaCode("0");
		table.add(data25);
		
		
		TabSheet data26 = new TabSheet();
		data26.setSheetNumber("MMFBR811");
		data26.setReturnCode("Form MMFBR811");
		data26.setBankCode("51253");
		data26.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data26.setReturnName("Schedule of Other Assets		");
		data26.setStateName("LAGOS");
		data26.setStateCode("20");
		data26.setLgaName("Ikeja");
		data26.setLgaCode("0");
		table.add(data26);
		
		
		
		TabSheet data29 = new TabSheet();
		data29.setSheetNumber("MMFBR300");
		data29.setReturnCode("Form MMFBR300");
		data29.setBankCode("51253");
		data29.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data29.setReturnName("Monthly Statement of Assets and Liabilities");
		data29.setStateName("LAGOS");
		data29.setStateCode("24");
		data29.setLgaName("Ikeja");
		data29.setLgaCode("0");
		table.add(data29);





		TabSheet data27 = new TabSheet();
		data27.setSheetNumber("MMFBR1000");
		data27.setReturnCode("Form MMFBR1000");
		data27.setBankCode("51253");
		data27.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data27.setReturnName("Monthly Statements of Profit and Loss Account");
		data27.setStateName("LAGOS");
		data27.setStateCode("20");
		data27.setLgaName("Ikeja");
		data27.setLgaCode("0");
		table.add(data27);





		TabSheet data28 = new TabSheet();
		data28.setSheetNumber("MMFBR M001");
		data28.setReturnCode("Form MMFBR M001");
		data28.setBankCode("51253");
		data28.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data28.setReturnName("Memorandum Items");
		data28.setStateName("LAGOS");
		data28.setStateCode("20");
		data28.setLgaName("Ikeja");
		data28.setLgaCode("0");
		table.add(data28);

		
		
		
		
		
		TabSheet data26 = new TabSheet();
		data26.setSheetNumber("MMFBR300");
		data26.setReturnCode("Form MMFBR300");
		data26.setBankCode("51253");
		data26.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data26.setReturnName("Monthly Statement of Assets and Liabilities");
		data26.setStateName("LAGOS");
		data26.setStateCode("24");
		data26.setLgaName("Ikeja");
		data26.setLgaCode("0");
		table.add(data26);
		
		
		
		
		
		TabSheet data27 = new TabSheet();
		data27.setSheetNumber("MMFBR1000");
		data27.setReturnCode("Form MMFBR1000");
		data27.setBankCode("51253");
		data27.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data27.setReturnName("Monthly Statements of Profit and Loss Account");
		data27.setStateName("LAGOS");
		data27.setStateCode("20");
		data27.setLgaName("Ikeja");
		data27.setLgaCode("0");
		table.add(data27);
		
		
		
		
		
		TabSheet data28 = new TabSheet();
		data28.setSheetNumber("MMFBR M001");
		data28.setReturnCode("Form MMFBR M001");
		data28.setBankCode("51253");
		data28.setBankName("NEPTUNE MICROFINANCE BANK LIMITED");
		data28.setReturnName("Memorandum Items");
		data28.setStateName("LAGOS");
		data28.setStateCode("20");
		data28.setLgaName("Ikeja");
		data28.setLgaCode("0");
		table.add(data28);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		TableResponse res = new TableResponse();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setData(table);
		return new ResponseEntity<>(res, HttpStatus.OK);

		
	}
	
}
