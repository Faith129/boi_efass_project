package com.efass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.sheet.mmfbr1000.sheet1000DAO;
import com.efass.sheet.mmfbr1000.sheet1000Repository;
import com.efass.sheet.mmfbr141.sheet141Repository;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr201.sheet201Repository;
import com.efass.sheet.mmfbr202.sheet202Repository;
import com.efass.sheet.mmfbr221.sheet221Repository;
import com.efass.sheet.mmfbr300.sheet300DAO;
import com.efass.sheet.mmfbr300.sheet300Repository;
import com.efass.sheet.mmfbr311.sheet311Repository;
import com.efass.sheet.mmfbr312.sheet312Repository;
import com.efass.sheet.mmfbr322.sheet322Repository;
import com.efass.sheet.mmfbr451.sheet451Repository;
import com.efass.sheet.mmfbr501.sheet501DAO;
import com.efass.sheet.mmfbr501.sheet501Repository;
import com.efass.sheet.mmfbr642.sheet642Repository;
import com.efass.sheet.mmfbr651.sheet651Repository;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr711.sheet711Repository;
import com.efass.sheet.mmfbr746.sheet746Repository;
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.sheet.mmfbr761.sheet761Repository;
import com.efass.sheet.mmfbr762.sheet762DAO;
import com.efass.sheet.mmfbr762.sheet762Repository;
import com.efass.sheet.mmfbr763.sheet763DAO;
import com.efass.sheet.mmfbr763.sheet763Repository;
import com.efass.sheet.mmfbr764.sheet764Repository;
import com.efass.sheet.mmfbr771.sheet771Repository;
import com.efass.sheet.mmfbr811.sheet811Repository;
import com.efass.sheet.mmfbr933.sheet933Repository;
import com.efass.sheet.mmfbr951.sheet951Repository;
import com.efass.sheet.mmfbr980.sheet980DAO;
import com.efass.sheet.mmfbr980.sheet980Repository;
import com.efass.sheet.mmfbr996.sheet996Repository;


@Service
public class PrepareTables {

	
	@Autowired
	sheet311Repository _311Repository;
	@Autowired
	sheet221Repository _221Repository;
	@Autowired
	sheet711Repository _711Repository;
	@Autowired
	sheet746Repository _746Repository;
	@Autowired
	sheet761Repository _761Repository;
	@Autowired
	sheet771Repository _771Repository;
	@Autowired
	sheet762Repository _762Repository;
	@Autowired
	sheet763Repository _763Repository;
	@Autowired
	sheet764Repository _764Repository;
	@Autowired
	sheet811Repository _811Repository;
	@Autowired
	sheet141Repository _141Repository;
	@Autowired
	sheet201Repository _201Repository;
	@Autowired
	sheet202Repository _202Repository;
	@Autowired
	sheet312Repository _312Repository;
	@Autowired
	sheet322Repository _322Repository;
	@Autowired
	sheet451Repository _451Repository;
	@Autowired
	sheet501Repository _501Repository;
	@Autowired
	sheet642Repository _642Repository;
	@Autowired
	sheet651Repository _651Repository;
	@Autowired
	sheet933Repository _933Repository;
	@Autowired
	sheet951Repository _951Repository;
	@Autowired
	sheet996Repository _996Repository;
	@Autowired
	sheet980Repository _980Repository;
	
	@Autowired
	sheet300Repository _300Repository;
	
	@Autowired
	sheet1000Repository _1000Repository;
	

	public void clearSheetTables() {
		
		try {

		populateSheet711();
		populateSheet762();
		populateSheet763();
		populateSheet761();
		populatesheet201();
		populatesheet980();
		populatesheet501();
	//	populatesheet1000();
		populatesheet300();
		}catch(Exception ex) {
			
		}
	}
	

	

	
	private void populateSheet711() {
		//Delete all 
		_711Repository.deleteAll();
		
		sheet711DAO data = new sheet711DAO();
		data.setLendingModel("Individuals");
		_711Repository.save(data);
		
		sheet711DAO data2 = new sheet711DAO();
		data2.setLendingModel("Solidarity Group");
		_711Repository.save(data2);
		
		
		sheet711DAO data3 = new sheet711DAO();
		data3.setLendingModel("Neighborhood and Small Group Revolving Funds");
		_711Repository.save(data3);
		
		
		sheet711DAO data4 = new sheet711DAO();
		data4.setLendingModel("Village Banking");
		_711Repository.save(data4);
		
		sheet711DAO data5 = new sheet711DAO();
		data5.setLendingModel("Wholesale lending");
		_711Repository.save(data5);
		
		sheet711DAO data6 = new sheet711DAO();
		data6.setLendingModel("Credit Unions");
		_711Repository.save(data6);
		
		sheet711DAO data7 = new sheet711DAO();
		data7.setLendingModel("Staff");
		_711Repository.save(data7);
		
		
		sheet711DAO data8 = new sheet711DAO();	
		data8.setLendingModel("Others - Specify");
		_711Repository.save(data8);
	
	}
	
	public void populateSheet762() {
		//delete all
		_762Repository.deleteAll();	
		
		sheet762DAO data = new sheet762DAO();
		data.setSector("Agriculture & Forestry");
		_762Repository.save(data);
		
		
		sheet762DAO data1 = new sheet762DAO();
		data1.setSector("Mining & Quarry");
		_762Repository.save(data1);
		
		
		sheet762DAO data2 = new sheet762DAO();
		data2.setSector("Manufacturing & Food Processing");
		_762Repository.save(data2);
		
			
		sheet762DAO data3 = new sheet762DAO();
		data3.setSector("Trade & Commerce");
		data3.setNoOfLoans("40");
		data3.setAmountGranted("8270");
		_762Repository.save(data3);

		sheet762DAO data4 = new sheet762DAO();
		data4.setSector("Transport & Communication");
		_762Repository.save(data4);
		
		sheet762DAO data5 = new sheet762DAO();
		data5.setSector("Real Estate & Construction");
		_762Repository.save(data5);
		
		sheet762DAO data6 = new sheet762DAO();
		data6.setSector("Consumer/Personal");
		data6.setNoOfLoans("18");
		data6.setAmountGranted("5010");
		_762Repository.save(data6);
		
		
		
		sheet762DAO data7 = new sheet762DAO();
		data7.setSector("Health");
		_762Repository.save(data7);
		
		
		
		sheet762DAO data8 = new sheet762DAO();
		data8.setSector("Education");
		_762Repository.save(data8);
		
		
		sheet762DAO data9 = new sheet762DAO();
		data9.setSector("Tourism & Hospitality");
		_762Repository.save(data9);
		
		
		sheet762DAO data10 = new sheet762DAO();
		data10.setSector("Purchase of Shares");
		_762Repository.save(data10);
		
		
		
		sheet762DAO data11 = new sheet762DAO();
		data11.setSector("Others (Specify)");
		_762Repository.save(data11);
		
	}
	
	
	
	
	public void populateSheet763() {
		//delete all
		_763Repository.deleteAll();		
	
		sheet763DAO data = new sheet763DAO();
		data.setLoanId("1");
		data.setTypeOfLoans("MICRO-LOANS");
		_763Repository.save(data);
		
		
		sheet763DAO data1 = new sheet763DAO();
		data1.setTypeOfLoans("Number of accounts");
		data1.setTypeId("1");
		_763Repository.save(data1);
		
		
		
		sheet763DAO data2 = new sheet763DAO();
		data2.setTypeOfLoans("Amount (₦)");
		data2.setTypeId("1");
		_763Repository.save(data2);
		
		
		sheet763DAO data3 = new sheet763DAO();
		data.setLoanId("2");
		data3.setTypeOfLoans("SMALL & MEDIUM ENTERPRISES LOANS");
		_763Repository.save(data3);
		
		
		
		sheet763DAO data4 = new sheet763DAO();
		data4.setTypeOfLoans("Number of accounts");
		data4.setTypeId("2");
		_763Repository.save(data4);
		
		
		sheet763DAO data5 = new sheet763DAO();
		data5.setTypeOfLoans("Amount (₦)");
		data5.setTypeId("2");
		_763Repository.save(data4);
		
		
		
		sheet763DAO data6 = new sheet763DAO();
		data.setLoanId("3");
		data6.setTypeOfLoans("HIRE PURCHASE");
		_763Repository.save(data5);
		
		
		
		sheet763DAO data7 = new sheet763DAO();
		data7.setTypeOfLoans("Number of accounts");
		data7.setTypeId("3");
		_763Repository.save(data7);
		
		
		sheet763DAO data8 = new sheet763DAO();
		data8.setTypeOfLoans("Amount (₦)");
		data8.setTypeId("3");
		_763Repository.save(data8);
		
		
		
		sheet763DAO data9 = new sheet763DAO();
		data.setLoanId("4");
		data9.setTypeOfLoans("HIRE PURCHASE");
		_763Repository.save(data9);
		
		sheet763DAO data10 = new sheet763DAO();
		data10.setTypeOfLoans("Number of accounts");
		data10.setTypeId("4");
		_763Repository.save(data10);
		
		
		sheet763DAO data11 = new sheet763DAO();
		data11.setTypeOfLoans("Amount (₦)");
		data11.setTypeId("4");
		_763Repository.save(data11);
		
		
		
		
		
		sheet763DAO data12 = new sheet763DAO();
		data.setLoanId("5");
		data12.setTypeOfLoans("MICRO-LEASES");
		_763Repository.save(data12);
		
		
		sheet763DAO data13 = new sheet763DAO();
		data13.setTypeOfLoans("Amount (₦)");
		data13.setTypeId("5");
		_763Repository.save(data13);
		
		sheet763DAO data14 = new sheet763DAO();
		data14.setTypeOfLoans("Number of accounts");
		data14.setTypeId("5");
		_763Repository.save(data14);
		
		
		
		
		
		sheet763DAO data15 = new sheet763DAO();
		data.setLoanId("6");
		data15.setTypeOfLoans("OTHER LOANS (SPECIFY)");
		_763Repository.save(data15);
		
		
		
		sheet763DAO data16 = new sheet763DAO();
		data16.setTypeOfLoans("Amount (₦)");
		data16.setTypeId("6");
		_763Repository.save(data16);
		
		sheet763DAO data17 = new sheet763DAO();
		data17.setTypeOfLoans("Number of accounts");
		data17.setTypeId("6");
		_763Repository.save(data17);
		
		
		
		sheet763DAO data18 = new sheet763DAO();
		data18.setTypeOfLoans("STAFF LOANS");
		_763Repository.save(data18);
		
		
		sheet763DAO data19 = new sheet763DAO();
		data19.setTypeOfLoans("Amount (₦)");
		data19.setTypeId("7");
		_763Repository.save(data19);
		
		sheet763DAO data20 = new sheet763DAO();
		data20.setTypeOfLoans("Number of accounts");
		data20.setTypeId("7");
		_763Repository.save(data20);
		
	
		
	}
	
	
	
	
	
	private void populateSheet761() {
		_761Repository.deleteAll();
	
		sheet761DAO data = new sheet761DAO();
		data.setSerialNo("10762");
		data.setDescription("Performing");
		_761Repository.save(data);
		
		sheet761DAO data1 = new sheet761DAO();
		data1.setSerialNo("10763");
		data1.setDescription("Non-Performing (Portfolio-At-Risk)");
		data1.setAmount("13,280");
		_761Repository.save(data1);
		
		sheet761DAO data2 = new sheet761DAO();
		data2.setSerialNo("10764");
		data2.setDescription("Pass & Watch");
		_761Repository.save(data2);
	
		sheet761DAO data3 = new sheet761DAO();
		data3.setSerialNo("10765");
		data3.setDescription("Substandard");
		_761Repository.save(data3);
		
		
		sheet761DAO data4 = new sheet761DAO();
		data4.setSerialNo("10766");
		data4.setDescription("Doubtful");
		_761Repository.save(data4);
		
		
		
		
		sheet761DAO data5 = new sheet761DAO();
		data5.setSerialNo("10767");
		data5.setDescription("Lost");
		_761Repository.save(data5);
		
		
		
		sheet761DAO data6 = new sheet761DAO();
		data6.setSerialNo("10768");
		data6.setDescription("Total Porfolio-At-Risk");
		_761Repository.save(data4);
		
		
		sheet761DAO data7 = new sheet761DAO();
		data7.setSerialNo("");
		data7.setDescription("Interest In Suspense");
		_761Repository.save(data4);
		
		
	}
	
	
	public void populatesheet980() {
		_980Repository.deleteAll();
		save980("Loans");
		save980("Investments");
		save980("Other Assets");
		save980("Deposits");
		save980("CDs and Other Liablities");
		save980("Equity (C)");
		save980("Net Periodic Gap A -(B+C)");
		
		
	}
	
	
	
	
	
	public void populatesheet201() {
		_201Repository.deleteAll();
		
		
		save201("DEMAND DEPOSITS", "1-30 Days");
		save201("DEMAND DEPOSITS", "31-30 Days");
		save201("DEMAND DEPOSITS", "61-90 Days");
		save201("DEMAND DEPOSITS", "91-180 Days");
		save201("DEMAND DEPOSITS", "181-360 Days");
		save201("DEMAND DEPOSITS", "Above 360 Days");
		
		
		
		save201("MADATORY SAVINGS", "1-30 Days");
		save201("MADATORY SAVINGS", "31-30 Days");
		save201("MADATORY SAVINGS", "61-90 Days");
		save201("MADATORY SAVINGS", "91-180 Days");
		save201("MADATORY SAVINGS", "181-360 Days");
		save201("MADATORY SAVINGS", "Above 360 Days");
		
		
		save201("VOLUNTARY SAVINGS", "1-30 Days");
		save201("VOLUNTARY SAVINGS", "31-30 Days");
		save201("VOLUNTARY SAVINGS", "61-90 Days");
		save201("VOLUNTARY SAVINGS", "91-180 Days");
		save201("VOLUNTARY SAVINGS", "181-360 Days");
		save201("VOLUNTARY SAVINGS", "Above 360 Days");
		
		
		
		
		
		
		
		save201("TERM/TIME DEPOSITS", "1-30 Days");
		save201("TERM/TIME DEPOSITS", "31-30 Days");
		save201("TERM/TIME DEPOSITS", "61-90 Days");
		save201("TERM/TIME DEPOSITS", "91-180 Days");
		save201("TERM/TIME DEPOSITS", "181-360 Days");
		save201("TERM/TIME DEPOSITS", "Above 360 Days");
		
		
		
		save201("SPECIAL DEPOSITS", "1-30 Days");
		save201("SPECIAL DEPOSITS", "31-30 Days");
		save201("SPECIAL DEPOSITS", "61-90 Days");
		save201("SPECIAL DEPOSITS", "91-180 Days");
		save201("SPECIAL DEPOSITS", "181-360 Days");
		save201("SPECIAL DEPOSITS", "Above 360 Days");
		
		
		
		save201("OTHER DEPOSITS(SPECIFY)", "1-30 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "31-30 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "61-90 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "91-180 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "181-360 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "Above 360 Days");
		
		
		
		
		
	}
	
	
	
	public void save980(String items) {
		
		sheet980DAO data = new sheet980DAO();
		data.setItems(items);
		_980Repository.save(data);	
	}
	
	
	
	
	public void populatesheet501() {
		
		save501("20510", "Accounts Payable (Provide Breakdown");
		save501("20515", "Unearned Income");
		save501("20520", "Interest Accrued not Paid");
		save501("20525", "Uncleared Effects / Transit items");
		save501("20530", "Un-audited Profit to Date");
		save501("20535", "Provision for Dimunition in the value of Investmen");
		save501("20540", "Provision for Losses on Off Balance Sheet Items");
		save501("20545", "Interest-in-Suspense");
		save501("20550", "Provision for Taxation");
		save501("20555", "Provision for Other Loan Losses");
		save501("20560", "Dividend Payable");
		save501("20565", "Suspense Account");
		save501("20570", "Deposits for Shares (Provide Breakdown)");
		save501("20575", "Miscellaneous (Specify)");
		
	}	
	
	
	
	
	

	
	
	public void populatesheet300() {
		_300Repository.deleteAll();


save300("10110","Notes","col1-null");
save300("10120", "Coins","col1-null");

save300("10610", "Quoted Companies","col1-null");
save300("10620", "Unquoted Companies","col1-null" );
save300("10630" , "Subsidiary Companies","col1-null" );
//save300("10640");
//save300("10650");
//save300("10700");
//save300("10710");
save300("10720" , "Small and Medium Enterprises Loans","col1-null" );
save300("10725" , "Blls Discounted","col1-null" );
save300("10730" , "Hire Purchase","col1-null" );
save300("10740" , "Advances Under Micro-Leases","col1-null" );
//save300("10745");
save300("10750" , "Staff Loans","col1-null" );
//save300("10760");
//save300("10770");
//save300("10780");
//save300("10790");
//save300("10795");
//save300("10800");
//save300("10810");
save300("10880" , "Provision for Losses on Other Assets","col1-null" );
//save300("10890");
//save300("10900");
save300("10910" , "Freehold Land and Building","col1-null" );
save300("10920" , "Leasehold Land and Building","col1-null" );
save300("10930" , "Plant and Machinery","col1-null" );
save300("10940" , "Furniture and Fixtures","col1-null" );
save300("10950" , "Motor Vehicles","col1-null" );
save300("10960" , "Office Equipment","col1-null" );
//save300("10970");
save300("10980" , "Less Accumulated Depraciation","col1-null" );
//save300("10990");
//save300("1");
//save300("20100");
save300("20110" , "Demand Deposits","col1-null" );
save300("20120" , "Mandatory Deposits","col1-null" );
save300("20125" , "Voluntary Savings Deposits","col1-null" );
save300("20130" , "Time/Term Deposits","col1-null" );
//save300("20140");
//save300("20200");
//save300("20300");
//save300("20310");
//save300("20320");
//save300("20330");
//save300("20450");
//save300("20500");
//save300("20600");
save300("20610" , "Federal Government","col1-null" );
save300("20620 " , "State Government","col1-null" );
save300("20630" , "Local Government","col1-null" );
//save300("20640");
//save300("20650");
//save300("20660");
//save300("20700");
save300("20710" , "Redeemable Debenture","col1-null" );
save300("20720" , "Irredeemable Debenture","col1-null" );
//save300("20750");
//save300("20800");
save300("20810" , "Authorised Share Capital","col1-null" );
//save300("20820");
save300("20830" , "Ordinary Shares","col1-null" );
save300("20840"  , "Preference Shares","col1-null" );
//save300("0860");
//save300("20900");
save300("20910" , "Statutory Reserve","col1-null" );
save300("20920" , "Share Premium","col1-null" );
save300("20930" , "General Reserve","col1-null" );
//save300("20932");
save300("20935" , "Bonus Reserves","col1-null" );
save300("20940" , "Revaluation Reserves","col1-null" );
//save300("20950");
save300("20960" , "Retained Profit/Loss","col1-null" );
//save300("20965");
//save300("20970");
//save300("20980");
//save300("20990");
//save300("20995");

	
	}
	
	
	
	
	
	public void populatesheet1000() {
		_1000Repository.deleteAll();
		save1000("30000", "Interest Income");	
		save1000("30100", "Less interest Expenses");
	
		
		save1000("30210", "Commission");
		save1000("30220", "Fees/Charges");
		save1000("30230", "Income From Investments");
		save1000("30240", "Other Income From Non-Financial Services");
		save1000("31100", "Staff Cost");
	
		save1000("31110", "Directors");
		save1000("31120", "Depreciation");
		save1000("31130", "Provision For Bad Debts");
		save1000("31140", "Bad Debts Written-Off");
		save1000("31150", "Penalties Paid");
		save1000("31160", "Overheads");
		save1000("31190", "Less: Provision For Taxation");
		save1000("31210", "Extra Ordinary items(EOI)");
		save1000("31220", "Tax On EOI");
	
	}
	
	
	
	public void save1000(String code, String desc) {
		
		sheet1000DAO data = new sheet1000DAO();
		
		data.setCode(code);
		data.setDescription(desc);
		_1000Repository.save(data);
	}
	
	
	public void save300(String code, String desc, String amount1) {
		
		sheet300DAO data = new sheet300DAO();
		data.setCode(code);
		data.setItemDescription(desc);
		data.setAmount1(amount1);
		_300Repository.save(data);
	}
	
	public void save501(String bankCode, String item) {
		
	sheet501DAO data = new sheet501DAO();
	data.setBank_code(bankCode);
	data.setItem(item);
	_501Repository.save(data);		
	}
	
	
	public void save201(String TypeOfDeposit, String duration) {
		
		sheet201DAO data = new sheet201DAO();
		data.setTypeOfDeposit(TypeOfDeposit);
		data.setDuration(duration);
		_201Repository.save(data);
		
	}
}
