package com.efass.sheet.mmfbr764;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR764")
public class sheet764DAO {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	
	@Column(name = "TypeOfAccount")
	public String typeOfAccount;
	
	
	@Column(name = "_0-30Days")
	public String zeroTo30Days;
	
	@Column(name = "_31-60Days")
	public String thirtyOneTo60Days;
	
	@Column(name = "_61–90Days")
	public String sixtyOneTo90Days;
	
	
	@Column(name = "_91–180Days")
	public String nintyOneTo180Days;
	
	
	@Column(name = "_180–360Days")
	public String oneEightyTo180Days;
	
	
	@Column(name = "_Over360Days")
	public String over360Days;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeOfAccount() {
		return typeOfAccount;
	}


	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}


	public String getZeroTo30Days() {
		return zeroTo30Days;
	}


	public void setZeroTo30Days(String zeroTo30Days) {
		this.zeroTo30Days = zeroTo30Days;
	}


	public String getThirtyOneTo60Days() {
		return thirtyOneTo60Days;
	}


	public void setThirtyOneTo60Days(String thirtyOneTo60Days) {
		this.thirtyOneTo60Days = thirtyOneTo60Days;
	}


	public String getSixtyOneTo90Days() {
		return sixtyOneTo90Days;
	}


	public void setSixtyOneTo90Days(String sixtyOneTo90Days) {
		this.sixtyOneTo90Days = sixtyOneTo90Days;
	}


	public String getNintyOneTo180Days() {
		return nintyOneTo180Days;
	}


	public void setNintyOneTo180Days(String nintyOneTo180Days) {
		this.nintyOneTo180Days = nintyOneTo180Days;
	}


	public String getOneEightyTo180Days() {
		return oneEightyTo180Days;
	}


	public void setOneEightyTo180Days(String oneEightyTo180Days) {
		this.oneEightyTo180Days = oneEightyTo180Days;
	}


	public String getOver360Days() {
		return over360Days;
	}


	public void setOver360Days(String over360Days) {
		this.over360Days = over360Days;
	}
	
	
	
}
