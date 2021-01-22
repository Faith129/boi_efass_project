package com.efass.sheet.mmfbr221;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR221")
public class sheet221DAO implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "BANK_CODE")
	public String bankCode;

	@Column(name = "BANK_NAME")
	public String bankName;

	@Column(name = "AMOUNT")
	public String amount;
	
	
	
	public sheet221DAO() {
		
	}

	public sheet221DAO(int id, String bankCode, String bankName, String amount) {
	
		this.id = id;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.amount = amount;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
