package com.efass.sheet.mmfbr322;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MMFBR322")
public class sheet322DAO {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "BANK_CODE")
	private String bank_code;
	
	
	
	
	@Column(name = "BANK_NAME")
	private String bank_name;
	
	
	
	@Column(name = "RATE")
	private String rate;
	
	
	
	@Column(name = "TENOR")
	private String tenor;
	
	
	
	
	@Column(name = "AMOUNT")
	private String amount;
	
	



	@Column(name = "MATURITY")
	private String maturityDate;





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





	public String getBank_name() {
		return bank_name;
	}





	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
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





	public String getAmount() {
		return amount;
	}





	public void setAmount(String amount) {
		this.amount = amount;
	}





	public String getMaturityDate() {
		return maturityDate;
	}





	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	


	
	
}
