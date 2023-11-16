package com.efass.sheet.mmfbr501;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR501")
public class sheet501DAO {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	
	
	@Column(name = "BANK_CODE")
	public String bank_code;
	
	
	
	@Column(name = "ITEM")
	public String item;
	
	
	@Column(name = "AMOUNT")
	public String amount;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBank_code() {
		return bank_code;
	}


	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}
	

	   
}
