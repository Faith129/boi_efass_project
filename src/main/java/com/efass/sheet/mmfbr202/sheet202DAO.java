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
	private int id;

	@Column(name = "DEPOSIT_TYPE")
	private String typeOfDeposit;
	
	
	@Column(name = "ONE_TO_100K")
	private String oneToHundredNaira;
	
	
	@Column(name = "HUNDRED_ANDONE_AND_ABOVE")
	private String hundredAndOneNaira;


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


	public String getOneToHundredNaira() {
		return oneToHundredNaira;
	}


	public void setOneToHundredNaira(String oneToHundredNaira) {
		this.oneToHundredNaira = oneToHundredNaira;
	}


	public String getHundredAndOneNaira() {
		return hundredAndOneNaira;
	}


	public void setHundredAndOneNaira(String hundredAndOneNaira) {
		this.hundredAndOneNaira = hundredAndOneNaira;
	}
	
	
	
	
	
	
	
	
}
