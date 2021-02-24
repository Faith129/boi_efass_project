package com.efass.sheet.mmfbr312;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR312")
public class sheet312DAO {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
  
	@Column(name = "BANK_CODE")
	public String bankCode;
	
	
	
	@Column(name = "BANK_NAME")
	public String nameOfBanks;
	
	
	@Column(name = "RATE")
	public String rate;
	
	
	
	@Column(name = "TENOR")
	public String tenor;
	
	
	
	@Column(name = "EFFECTIVE_DATE")
	public String effectiveDate;
	
	
	
	
	@Column(name = "MATURITY")
	public String maturityDate;
	
	
	
	@Column(name = "AMOUNT")
	public String amount;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBankCode() {
		return bankCode;
	}



	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}



	public String getNameOfBanks() {
		return nameOfBanks;
	}



	public void setNameOfBanks(String nameOfBanks) {
		this.nameOfBanks = nameOfBanks;
	}



	public String getRate() {
		return rate;
	}



	public void setRate(String rate) {
		this.rate = rate;
	}



	public String getTenor() {
		return tenor;
	}



	public void setTenor(String tenor) {
		this.tenor = tenor;
	}



	public String getEffectiveDate() {
		return effectiveDate;
	}



	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}



	public String getMaturityDate() {
		return maturityDate;
	}



	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
	
	
	
}
