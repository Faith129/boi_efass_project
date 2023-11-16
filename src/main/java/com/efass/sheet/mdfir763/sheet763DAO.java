package com.efass.sheet.mmfbr763;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR763")
public class sheet763DAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	  	  
	@Column(name = "DURATION")
	public String duration;
	
	
	
	@Column(name = "TYPE_OF_LOAN")
	public String type_of_loan;
	
	@Column(name = "NO_OF_ACCOUNT")
	public String no_of_account;
	
	
	
	@Column(name = "AMOUNT")
	public String amount;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}



	public String getType_of_loan() {
		return type_of_loan;
	}



	public void setType_of_loan(String type_of_loan) {
		this.type_of_loan = type_of_loan;
	}



	public String getNo_of_account() {
		return no_of_account;
	}



	public void setNo_of_account(String no_of_account) {
		this.no_of_account = no_of_account;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	

	
	
	
	
	
	
	
}
