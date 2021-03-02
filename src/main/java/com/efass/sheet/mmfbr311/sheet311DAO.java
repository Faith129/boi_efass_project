package com.efass.sheet.mmfbr311;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR311")
public class sheet311DAO  {





	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	@Column(name = "BANK_CODE")
	public String bankCode;
	
	@Column(name = "BANK_NAME")
	public String bankName;
	
	@Column(name = "TENOR")
	public String tenor;
	
	@Column(name = "MATURITY")
	public String maturity_Date;
	
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}



	public String getMaturity_Date() {
		return maturity_Date;
	}

	public void setMaturity_Date(String maturity_Date) {
		this.maturity_Date = maturity_Date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	
	
	
	
	  
}
