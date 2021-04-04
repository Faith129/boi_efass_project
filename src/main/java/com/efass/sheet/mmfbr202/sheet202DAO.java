package com.efass.sheet.mmfbr202;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MMFBR202")
public class sheet202DAO {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "TYPE_OF_DEPOSIT")
	public String typeOfDeposit;
	
	
	@Column(name = "PRICE_RANGE")
	public String priceRange;
	
	
	@Column(name = "NUMBER_OF_ACCOUNTS")
	public String numberOfAccount;
	
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

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String getNumberOfAccount() {
		return numberOfAccount;
	}

	public void setNumberOfAccount(String numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}


	
	
	
	
	
	
	
}
