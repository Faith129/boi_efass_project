package com.efass.sheet.mmfbr201;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "MMFBR201")
public class sheet201DAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name="TYPE_OF_DEPOSIT")
	public String typeOfDeposit;
	
	@Column(name="DURATION")
	public String duration;
	
	@Column(name = "NUMBER_OF_ACCOUNTS")
	public String numberofAccounts;
	
	
	@Column(name = "AMOUNT")
	public String amount;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeOfDeposit() {
		return typeOfDeposit;
	}


	public void setTypeOfDeposit(String typeOfDeposit) {
		this.typeOfDeposit = typeOfDeposit;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getNumberofAccounts() {
		return numberofAccounts;
	}


	public void setNumberofAccounts(String numberofAccounts) {
		this.numberofAccounts = numberofAccounts;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	
	
	
	
	
	
	
}
