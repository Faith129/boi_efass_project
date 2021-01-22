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
		
		
		
		
		
		
		TableResponse res = new TableResponse();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setData(table);
		return new ResponseEntity<>(res, HttpStatus.OK);

		
	}
	
}
