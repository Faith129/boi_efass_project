package com.efass.sheet.mmfbr771;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR771")
public class sheet771DAO {
	
	
	

	  
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	
	@Column(name = "CUSTOMER_CODE")
	public String customerCode;

	
	@Column(name = "CUSTOMER_NAME")
	public String customerName;
	
	
	@Column(name = "PAST_DUE_DATE")
	public String pastDueDate;
	
	@Column(name = "LAST_REPAYMNT_DATE")
	public String lastRepaymentDate;
	
	
	
	
	@Column(name = "AMOUNT_GRANTED")
	public String amountGranted;
	
	
	@Column(name = "PRIN_PAYMNT_DUE_UNPAID")
	public String principalPaymentDueUnpaid;
	
	@Column(name = "ACCRUED_INT_UNPAID")
	public String accruedInterestUnpaid;
	
	@Column(name = "TOT_NON_PERF_CREDIT")
	public String totalNonPerformingCredit;
	
	
	@Column(name = "ONE_THIRTY_DAYS")
	public String oneToThirtyDays;
	
	
	@Column(name = "THIRTYONE_SIX_DAYS")
	public String thirtyOneToSixtyDays;
	
	
	@Column(name = "SIXYONE_NINTY_DAYS")
	public String sixyOneToNintyDays;
	
	
	@Column(name = "NINTYONE_MORE_DAYS")
	public String nintyOneToModeDays;
	
	
	@Column(name = "BANK_PROVISION")
	public String bankprovision;
	


	@Column(name = "REMARKS")
	public String remarks;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCustomerCode() {
		return customerCode;
	}


	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPastDueDate() {
		return pastDueDate;
	}


	public void setPastDueDate(String pastDueDate) {
		this.pastDueDate = pastDueDate;
	}


	public String getLastRepaymentDate() {
		return lastRepaymentDate;
	}


	public void setLastRepaymentDate(String lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
	}


	public String getAmountGranted() {
		return amountGranted;
	}


	public void setAmountGranted(String amountGranted) {
		this.amountGranted = amountGranted;
	}


	public String getPrincipalPaymentDueUnpaid() {
		return principalPaymentDueUnpaid;
	}


	public void setPrincipalPaymentDueUnpaid(String principalPaymentDueUnpaid) {
		this.principalPaymentDueUnpaid = principalPaymentDueUnpaid;
	}


	public String getAccruedInterestUnpaid() {
		return accruedInterestUnpaid;
	}


	public void setAccruedInterestUnpaid(String accruedInterestUnpaid) {
		this.accruedInterestUnpaid = accruedInterestUnpaid;
	}


	public String getTotalNonPerformingCredit() {
		return totalNonPerformingCredit;
	}


	public void setTotalNonPerformingCredit(String totalNonPerformingCredit) {
		this.totalNonPerformingCredit = totalNonPerformingCredit;
	}


	public String getOneToThirtyDays() {
		return oneToThirtyDays;
	}


	public void setOneToThirtyDays(String oneToThirtyDays) {
		this.oneToThirtyDays = oneToThirtyDays;
	}


	public String getThirtyOneToSixtyDays() {
		return thirtyOneToSixtyDays;
	}


	public void setThirtyOneToSixtyDays(String thirtyOneToSixtyDays) {
		this.thirtyOneToSixtyDays = thirtyOneToSixtyDays;
	}


	public String getSixyOneToNintyDays() {
		return sixyOneToNintyDays;
	}


	public void setSixyOneToNintyDays(String sixyOneToNintyDays) {
		this.sixyOneToNintyDays = sixyOneToNintyDays;
	}


	public String getNintyOneToModeDays() {
		return nintyOneToModeDays;
	}


	public void setNintyOneToModeDays(String nintyOneToModeDays) {
		this.nintyOneToModeDays = nintyOneToModeDays;
	}
	
	
	public String getBankprovision() {
		return bankprovision;
	}


	public void setBankprovision(String bankprovision) {
		this.bankprovision = bankprovision;
	}



	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


//	public void setTotalNonPerformingCredit(int i) {
//		// TODO Auto-generated method stub
//		
//	}
//	
	

	
	
	

}
