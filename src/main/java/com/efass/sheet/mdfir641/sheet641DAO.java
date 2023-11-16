package com.efass.sheet.mmfbr641;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR641")
public class sheet641DAO implements Serializable {


	private static final long serialVersionUID = 1928892232870720320L;

   
	  
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	
	
	@Column(name = "NATURE_OF_INVESTM")
	public String natureOfInvestment;
	
	@Column(name = "AMOUNT")
	public String amount;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNatureOfInvestment() {
		return natureOfInvestment;
	}

	public void setNatureOfInvestment(String natureOfInvestment) {
		this.natureOfInvestment = natureOfInvestment;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}


	
	
}
