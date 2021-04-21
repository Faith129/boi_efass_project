
package com.efass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efass.sheet.mmfbr1000.sheet1000DAO;
import com.efass.sheet.mmfbr1000.sheet1000Repository;
import com.efass.sheet.mmfbr141.sheet141Repository;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr201.sheet201Repository;
import com.efass.sheet.mmfbr202.sheet202DAO;
import com.efass.sheet.mmfbr202.sheet202Repository;
import com.efass.sheet.mmfbr221.sheet221Repository;
import com.efass.sheet.mmfbr300.sheet300DAO;
import com.efass.sheet.mmfbr300.sheet300Repository;
import com.efass.sheet.mmfbr300.sheet300TemporaryDAO;
import com.efass.sheet.mmfbr300.sheet300TemporaryRepository;
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
import com.efass.sheet.mmfbr764.sheet764DAO;
import com.efass.sheet.mmfbr764.sheet764Repository;
import com.efass.sheet.mmfbr771.sheet771Repository;
import com.efass.sheet.mmfbr811.sheet811DAO;
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
	sheet300TemporaryRepository _300TemporaryRepository;

	@Autowired
	sheet1000Repository _1000Repository;

	public void clearSheetTables() {

		try {
			
		populateSheet811();
		populateSheet764();
		populateSheet711();
		populateSheet762();
		populateSheet763();
		populateSheet761();
		populatesheet201();
		populatesheet202();
		populatesheet501();
		populatesheet980();	
	//	populatesheet1000();
		populatesheet300();
		populatesheet300_Temp();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void populateSheet811() {
		//Delete all
		_811Repository.deleteAll();

		sheet811DAO data = new sheet811DAO();
		data.setCode("10815");
		data.setItem("Accounts Receivable [Provide Breakdown]");
		_811Repository.save(data);

		sheet811DAO data2 = new sheet811DAO();
		data2.setCode("10820");
		data2.setItem("Accrued Interest Receivable [Provide Breakdown]");
		_811Repository.save(data2);


		sheet811DAO data3 = new sheet811DAO();
		data3.setCode("10825");
		data3.setItem("Cheques for Collection /Transit Items [Provide Breakdown]");
		_811Repository.save(data3);


		sheet811DAO data4 = new sheet811DAO();
		data4.setCode("10835");
		data4.setItem("Prepaid Interest [Provide Breakdown]");
		_811Repository.save(data4);

		sheet811DAO data5 = new sheet811DAO();
		data5.setCode("10840");
		data5.setItem("Prepaid Rent [Provide Breakdown]");
		_811Repository.save(data5);

		sheet811DAO data6 = new sheet811DAO();
		data6.setCode("10845");
		data6.setItem("Stationery [Provide Breakdown]");
		_811Repository.save(data6);

		sheet811DAO data7 = new sheet811DAO();
		data7.setCode("10850");
		data7.setItem("Other Prepayments [Provide Breakdown]");
		_811Repository.save(data7);


		sheet811DAO data8 = new sheet811DAO();
		data8.setCode("10855");
		data8.setItem("Suspense Account [Provide Breakdown]");
		_811Repository.save(data8);

		sheet811DAO data9 = new sheet811DAO();
		data9.setCode("10860");
		data9.setItem("Goodwill and Other Intangible Assets [Provide Breakdown]");
		_811Repository.save(data9);

		sheet811DAO data10 = new sheet811DAO();
		data10.setCode("10865");
		data10.setItem("Miscellaneous [Provide Breakdown]");
		_811Repository.save(data10);

		}
	


	private void populateSheet711() {
		// Delete all
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
	

	private void populateSheet764() {
		// Delete all
		_764Repository.deleteAll();

		sheet764DAO data = new sheet764DAO();
		data.setAccount_type("Loans and Advances");
		_764Repository.save(data);

		sheet764DAO data2 = new sheet764DAO();
		data2.setAccount_type("Hire Purchase");
		_764Repository.save(data2);

		sheet764DAO data3 = new sheet764DAO();
		data3.setAccount_type("Micro Leases");
		_764Repository.save(data3);
		
		sheet764DAO data4 = new sheet764DAO();
		data4.setAccount_type("Savings Deposits");
		_764Repository.save(data4);

		sheet764DAO data5 = new sheet764DAO();
		data5.setAccount_type("Time/Term Deposits");
		_764Repository.save(data5);

		sheet764DAO data6 = new sheet764DAO();
		data6.setAccount_type("Target Deposits");
		_764Repository.save(data6);

	}


	public void populateSheet762() {
		// delete all
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
//		data3.setNoOfLoans("40");
//		data3.setAmountGranted("8270");
		_762Repository.save(data3);

		sheet762DAO data4 = new sheet762DAO();
		data4.setSector("Transport & Communication");
		_762Repository.save(data4);

		sheet762DAO data5 = new sheet762DAO();
		data5.setSector("Real Estate & Construction");
		_762Repository.save(data5);

		sheet762DAO data6 = new sheet762DAO();
		data6.setSector("Rent/Housing");
		_762Repository.save(data6);

		sheet762DAO data7 = new sheet762DAO();
		data7.setSector("Consumer/Personal");
//		data7.setNoOfLoans("18");
//		data7.setAmountGranted("5010");
		_762Repository.save(data7);
    
		sheet762DAO data8 = new sheet762DAO();
		data8.setSector("Health");
		_762Repository.save(data8);

		sheet762DAO data9 = new sheet762DAO();
		data9.setSector("Education");
		_762Repository.save(data9);

		sheet762DAO data10 = new sheet762DAO();
		data10.setSector("Tourism & Hospitality");
		_762Repository.save(data10);

		sheet762DAO data11 = new sheet762DAO();
		data11.setSector("Purchase of Shares");
		_762Repository.save(data11);

		sheet762DAO data12 = new sheet762DAO();
		data12.setSector("Others (Specify)");
		_762Repository.save(data12);
	}
	

	public void populateSheet763() {
		// delete all
		_763Repository.deleteAll();
				
		save763("MICRO-LOANS", "1-30 Days");
		save763("MICRO-LOANS", "31-60 Days");
		save763("MICRO-LOANS", "61-90 Days");
		save763("MICRO-LOANS", "91-180 Days");
		save763("MICRO-LOANS", "181-360 Days");
		save763("MICRO-LOANS", "Above 360 Days");

		save763("SMALL & MEDIUM ENTERPRISES LOANS", "1-30 Days");
		save763("SMALL & MEDIUM ENTERPRISES LOANS", "31-60 Days");
		save763("SMALL & MEDIUM ENTERPRISES LOANS", "61-90 Days");
		save763("SMALL & MEDIUM ENTERPRISES LOANS", "91-180 Days");
		save763("SMALL & MEDIUM ENTERPRISES LOANS", "181-360 Days");
		save763("SMALL & MEDIUM ENTERPRISES LOANS", "Above 360 Days");

		save763("HIRE PURCHASE", "1-30 Days");
		save763("HIRE PURCHASE", "31-60 Days");
		save763("HIRE PURCHASE", "61-90 Days");
		save763("HIRE PURCHASE", "91-180 Days");
		save763("HIRE PURCHASE", "181-360 Days");
		save763("HIRE PURCHASE", "Above 360 Days");

		save763("MICRO-LEASES", "1-30 Days");
		save763("MICRO-LEASES", "31-60 Days");
		save763("MICRO-LEASES", "61-90 Days");
		save763("MICRO-LEASES", "91-180 Days");
		save763("MICRO-LEASES", "181-360 Days");
		save763("MICRO-LEASES", "Above 360 Days");

		save763("OTHER LOANS (SPECIFY)", "1-30 Days");
		save763("OTHER LOANS (SPECIFY)", "31-60 Days");
		save763("OTHER LOANS (SPECIFY)", "61-90 Days");
		save763("OTHER LOANS (SPECIFY)", "91-180 Days");
		save763("OTHER LOANS (SPECIFY)", "181-360 Days");
		save763("OTHER LOANS (SPECIFY)", "Above 360 Days");

		save763("STAFF LOANS", "1-30 Days");
		save763("STAFF LOANS", "31-60 Days");
		save763("STAFF LOANS", "61-90 Days");
		save763("STAFF LOANS", "91-180 Days");
		save763("STAFF LOANS", "181-360 Days");
		save763("STAFF LOANS", "Above 360 Days");


	}

	
	
	
	public void save763(String type_of_loan, String duration) {

		sheet763DAO data = new sheet763DAO();
		data.setType_of_loan(type_of_loan);
		data.setDuration(duration);
		_763Repository.save(data);
	}

	
	
	private void populateSheet761() {
		_761Repository.deleteAll();
		
		
		save761("10762", "Performing","");
		save761("10763", "Non-Performing (Portfolio-At-Risk)","");
		save761("10764", "Pass & Watch", "");
		save761("10765", "Substandard", "");
		save761("10766", "Doubtful", "");
		save761("10767", "Lost", "");
		save761("10768", "Total Porfolio-At-Risk", "");
		save761("", "Interest In Suspense", "");
	
//		sheet761DAO data = new sheet761DAO();
//		data.setSerialNo("10762");
//		data.setDescription("Performing");
//		//data.setAmount("13,280");
//		_761Repository.save(data);
//
//		sheet761DAO data1 = new sheet761DAO();
//		data1.setSerialNo("10763");
//		data1.setDescription("Non-Performing (Portfolio-At-Risk)");	
//		_761Repository.save(data1);
//
//		sheet761DAO data2 = new sheet761DAO();
//		data2.setSerialNo("10764");
//		data2.setDescription("Pass & Watch");
//		_761Repository.save(data2);
//
//		sheet761DAO data3 = new sheet761DAO();
//		data3.setSerialNo("10765");
//		data3.setDescription("Substandard");
//		_761Repository.save(data3);
//
//		sheet761DAO data4 = new sheet761DAO();
//		data4.setSerialNo("10766");
//		data4.setDescription("Doubtful");
//		_761Repository.save(data4);
//
//		sheet761DAO data5 = new sheet761DAO();
//		data5.setSerialNo("10767");
//		data5.setDescription("Lost");
//		_761Repository.save(data5);
//
//		sheet761DAO data6 = new sheet761DAO();
//		data6.setSerialNo("10768");
//		data6.setDescription("Total Porfolio-At-Risk");
//		_761Repository.save(data4);
//
//		sheet761DAO data7 = new sheet761DAO();
//		data7.setSerialNo("");
//		data7.setDescription("Interest In Suspense");
//		_761Repository.save(data4);

	}

	public void populatesheet980() {
		_980Repository.deleteAll();
        save980("LOANS", "1-30 Days");
		save980("LOANS", "31-60 Days");
		save980("LOANS", "61-90 Days");
		save980("LOANS", "91-180 Days");
		save980("LOANS", "181-360 Days");
		save980("LOANS", "Above 360 Days");
		
		
		
		save980("INVESTMENTS", "1-30 Days");
		save980("INVESTMENTS", "31-60 Days");
		save980("INVESTMENTS", "61-90 Days");
		save980("INVESTMENTS", "91-180 Days");
		save980("INVESTMENTS", "181-360 Days");
		save980("INVESTMENTS", "Above 360 Days");
		

		save980("OTHER ASSETS", "1-30 Days");
		save980("OTHER ASSETS", "31-60 Days");
		save980("OTHER ASSETS", "61-90 Days");
		save980("OTHER ASSETS", "91-180 Days");
		save980("OTHER ASSETS", "181-360 Days");
		save980("OTHER ASSETS", "Above 360 Days");

		save980("DEPOSITS", "1-30 Days");
		save980("DEPOSITS", "31-60 Days");
		save980("DEPOSITS", "61-90 Days");
		save980("DEPOSITS", "91-180 Days");
		save980("DEPOSITS", "181-360 Days");
		save980("DEPOSITS", "Above 360 Days");

		save980("CDS AND OTHER LIABILITY", "1-30 Days");
		save980("CDS AND OTHER LIABILITY", "31-60 Days");
		save980("CDS AND OTHER LIABILITY", "61-90 Days");
		save980("CDS AND OTHER LIABILITY", "91-180 Days");
		save980("CDS AND OTHER LIABILITY", "181-360 Days");
		save980("CDS AND OTHER LIABILITY", "Above 360 Days");

		save980("EQUITY (C)", "1-30 Days");
		save980("EQUITY (C)", "31-60 Days");
		save980("EQUITY (C)", "61-90 Days");
		save980("EQUITY (C)", "91-180 Days");
		save980("EQUITY (C)", "181-360 Days");
		save980("EQUITY (C)", "Above 360 Days");

		save980("NET PERIODIC GAP A- (B + C)", "1-30 Days");
		save980("NET PERIODIC GAP A- (B + C)", "31-60 Days");
		save980("NET PERIODIC GAP A- (B + C)", "61-90 Days");
		save980("NET PERIODIC GAP A- (B + C)", "91-180 Days");
		save980("NET PERIODIC GAP A- (B + C)", "181-360 Days");
		save980("NET PERIODIC GAP A- (B + C)", "Above 360 Days");

	}

	public void populatesheet201() {
		_201Repository.deleteAll();

		save201("DEMAND DEPOSITS", "1-30 Days");
		save201("DEMAND DEPOSITS", "31-60 Days");
		save201("DEMAND DEPOSITS", "61-90 Days");
		save201("DEMAND DEPOSITS", "91-180 Days");
		save201("DEMAND DEPOSITS", "181-360 Days");
		save201("DEMAND DEPOSITS", "Above 360 Days");

		save201("MADATORY SAVINGS", "1-30 Days");
		save201("MADATORY SAVINGS", "31-60 Days");
		save201("MADATORY SAVINGS", "61-90 Days");
		save201("MADATORY SAVINGS", "91-180 Days");
		save201("MADATORY SAVINGS", "181-360 Days");
		save201("MADATORY SAVINGS", "Above 360 Days");

		save201("VOLUNTARY SAVINGS", "1-30 Days");
		save201("VOLUNTARY SAVINGS", "31-60 Days");
		save201("VOLUNTARY SAVINGS", "61-90 Days");
		save201("VOLUNTARY SAVINGS", "91-180 Days");
		save201("VOLUNTARY SAVINGS", "181-360 Days");
		save201("VOLUNTARY SAVINGS", "Above 360 Days");

		save201("TERM/TIME DEPOSITS", "1-30 Days");
		save201("TERM/TIME DEPOSITS", "31-60 Days");
		save201("TERM/TIME DEPOSITS", "61-90 Days");
		save201("TERM/TIME DEPOSITS", "91-180 Days");
		save201("TERM/TIME DEPOSITS", "181-360 Days");
		save201("TERM/TIME DEPOSITS", "Above 360 Days");

		save201("SPECIAL DEPOSITS", "1-30 Days");
		save201("SPECIAL DEPOSITS", "31-60 Days");
		save201("SPECIAL DEPOSITS", "61-90 Days");
		save201("SPECIAL DEPOSITS", "91-180 Days");
		save201("SPECIAL DEPOSITS", "181-360 Days");
		save201("SPECIAL DEPOSITS", "Above 360 Days");

		save201("OTHER DEPOSITS(SPECIFY)", "1-30 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "31-60 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "61-90 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "91-180 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "181-360 Days");
		save201("OTHER DEPOSITS(SPECIFY)", "Above 360 Days");

	}

	public void populatesheet202() {
		_202Repository.deleteAll();
		
		save202("DEMAND DEPOSIT", "1-100,000");
		save202("DEMAND DEPOSIT", "100,001 Above");
		
		save202("SAVINGS DEPOSIT",  "1-100,000");
		save202("SAVINGS DEPOSIT",  "100,001 Above");
		
		save202("TERM/TIME DEPOSIT", "1-100,000");
		save202("TERM/TIME DEPOSIT", "100,001 Above");
		
		save202("SPECIAL/OTHER DEPOSITS", "1-100,000");
		save202("SPECIAL/OTHER DEPOSITS", "100,001 Above");
	}


	public void save980(String items, String duration) {
		sheet980DAO data = new sheet980DAO();
		data.setItems(items);
		data.setDuration(duration);
		_980Repository.save(data);
	}

	public void populatesheet501() {
		_501Repository.deleteAll();
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

		save300("10110", "Notes");
		save300("10120", "Coins");
		save300("10510", "Treasury Bills");
		save300("10610", "Quoted Companies");
		save300("10620", "Unquoted Companies");
		save300("10630", "Subsidiary Companies");
		save300("10720", "Small and Medium Enterprises Loans");
		save300("10725", "Blls Discounted");
		save300("10730", "Hire Purchase");
		save300("10740", "Advances Under Micro-Leases");
		save300("10750", "Staff Loans");
		save300("10880", "Provision for Losses on Other Assets");
		save300("10910", "Freehold Land and Building");
		save300("10920", "Leasehold Land and Building");
		save300("10930", "Plant and Machinery");
		save300("10940", "Furniture and Fixtures");
		save300("10950", "Motor Vehicles");
		save300("10960", "Office Equipment");
		save300("10980", "Less Accumulated Depraciation");
		save300("20110", "Demand Deposits");
		save300("20120", "Mandatory Deposits");
		save300("20125", "Voluntary Savings Deposits");
		save300("20130", "Time/Term Deposits");
		save300("20610", "Federal Government");
		save300("20620", "State Government");
		save300("20630", "Local Government");
		save300("20710", "Redeemable Debenture");
		save300("20720", "Irredeemable Debenture");
		save300("20810", "Authorised Share Capital");
		save300("20830", "Ordinary Shares");
		save300("20840", "Preference Shares");
		save300("20910", "Statutory Reserve");
		save300("20920", "Share Premium");
		save300("20930", "General Reserve");
		save300("20935", "Bonus Reserves");
		save300("20940", "Revaluation Reserves");
		save300("20960", "Retained Profit/Loss");


	}

	public void populatesheet300_Temp() {
		_300TemporaryRepository.deleteAll();

		save300_Temp("10110", "Notes");
		save300_Temp("10120", "Coins");
		save300_Temp("10510", "Treasury Bills");
		save300_Temp("10610", "Quoted Companies");
		save300_Temp("10620", "Unquoted Companies");
		save300_Temp("10630", "Subsidiary Companies");
		save300_Temp("10720", "Small and Medium Enterprises Loans");
		save300_Temp("10725", "Blls Discounted");
		save300_Temp("10730", "Hire Purchase");
		save300_Temp("10740", "Advances Under Micro-Leases");
		save300_Temp("10750", "Staff Loans");
		save300_Temp("10880", "Provision for Losses on Other Assets");
		save300_Temp("10910", "Freehold Land and Building");
		save300_Temp("10920", "Leasehold Land and Building");
		save300_Temp("10930", "Plant and Machinery");
		save300_Temp("10940", "Furniture and Fixtures");
		save300_Temp("10950", "Motor Vehicles");
		save300_Temp("10960", "Office Equipment");
		save300_Temp("10980", "Less Accumulated Depraciation");
		save300_Temp("20110", "Demand Deposits");
		save300_Temp("20120", "Mandatory Deposits");
		save300_Temp("20125", "Voluntary Savings Deposits");
		save300_Temp("20130", "Time/Term Deposits");
		save300_Temp("20610", "Federal Government");
		save300_Temp("20620", "State Government");
		save300_Temp("20630", "Local Government");
		save300_Temp("20710", "Redeemable Debenture");
		save300_Temp("20720", "Irredeemable Debenture");
		save300_Temp("20810", "Authorised Share Capital");
		save300_Temp("20830", "Ordinary Shares");
		save300_Temp("20840", "Preference Shares");
		save300_Temp("20910", "Statutory Reserve");
		save300_Temp("20920", "Share Premium");
		save300_Temp("20930", "General Reserve");
		save300_Temp("20935", "Bonus Reserves");
		save300_Temp("20940", "Revaluation Reserves");
		save300_Temp("20960", "Retained Profit/Loss");


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

	public void save300(String code, String desc) {

		sheet300DAO data = new sheet300DAO();
		data.setCode(code);
		data.setDescription(desc);
		_300Repository.save(data);
	}
	
	public void save300_Temp(String code, String desc) {

		sheet300TemporaryDAO data = new sheet300TemporaryDAO();
		data.setCode(code);
		data.setDescription(desc);
		_300TemporaryRepository.save(data);
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
	
	public void save202(String TypeOfDeposit, String priceRange) {

		sheet202DAO data = new sheet202DAO();
		data.setTypeOfDeposit(TypeOfDeposit);
		data.setPriceRange(priceRange);
		_202Repository.save(data);

	}
	
	public void save761(String serialNo, String description, String amount) {

		sheet761DAO data = new sheet761DAO();
		data.setSerialNo(serialNo);
		data.setDescription(description);
		data.setAmount(amount);
		_761Repository.save(data);

	}
}
