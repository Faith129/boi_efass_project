package com.efass.sheet.mmfbr451;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MMFBR451")
public class sheet451DAO {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "BANK_CODE")
	public String bankCode;
	
	
	
	
	@Column(name = "BANK_NAME")
	public String nameOfInstitution;
	
	
	
	@Column(name = "RATE")
	public String rate;
	
	
	
	@Column(name = "TENOR")
	public String tenor;
	
	
	
	
	@Column(name = "MATURITY_DATE")
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


	public String getNameOfInstitution() {
		return nameOfInstitution;
	}


	public void setNameOfInstitution(String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
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
