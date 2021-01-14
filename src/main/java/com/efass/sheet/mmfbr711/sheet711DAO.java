package com.efass.sheet.mmfbr711;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR711")
public class sheet711DAO {
	
	

  
	  
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	
	@Column(name = "LENDING_MODEL")
	public String lendingModel;
	
	@Column(name = "NUMBERS")
	public String numbers;
	
	@Column(name = "AMOUNT")
	public String amount;
	
	@Column(name = "PERCENTAGE")
	public String percentage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLendingModel() {
		return lendingModel;
	}

	public void setLendingModel(String lendingModel) {
		this.lendingModel = lendingModel;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	
	

	
	

	  
	  
	  

}
