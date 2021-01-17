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

	
	@Column(name = "TYPE_OF_LOANS")
	public String typeOfLoans;
	
	
	@Column(name = "_1-30Days")
	public String oneTo30Days;
	
	@Column(name = "_31-60Days")
	public String thirtyOneTo60Days;
	
	@Column(name = "_61–90Days")
	public String sixtyOneTo90Days;
	
	
	
	@Column(name = "_180Days")
	public String oneEightyDays;
	
	
	@Column(name = "_181–360Days")
	public String oneEightyoneTo360Days;
	
	
	@Column(name = "_above360Days")
	public String above360Days;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeOfLoans() {
		return typeOfLoans;
	}


	public void setTypeOfLoans(String typeOfLoans) {
		this.typeOfLoans = typeOfLoans;
	}


	public String getOneTo30Days() {
		return oneTo30Days;
	}


	public void setOneTo30Days(String oneTo30Days) {
		this.oneTo30Days = oneTo30Days;
	}


	public String getSixtyOneTo90Days() {
		return sixtyOneTo90Days;
	}


	public void setSixtyOneTo90Days(String sixtyOneTo90Days) {
		this.sixtyOneTo90Days = sixtyOneTo90Days;
	}


	public String getOneEightyDays() {
		return oneEightyDays;
	}


	public void setOneEightyDays(String oneEightyDays) {
		this.oneEightyDays = oneEightyDays;
	}


	public String getOneEightyoneTo360Days() {
		return oneEightyoneTo360Days;
	}


	public void setOneEightyoneTo360Days(String oneEightyoneTo360Days) {
		this.oneEightyoneTo360Days = oneEightyoneTo360Days;
	}


	public String getThirtyOneTo60Days() {
		return thirtyOneTo60Days;
	}


	public void setThirtyOneTo60Days(String thirtyOneTo60Days) {
		this.thirtyOneTo60Days = thirtyOneTo60Days;
	}


	public String getAbove360Days() {
		return above360Days;
	}


	public void setAbove360Days(String above360Days) {
		this.above360Days = above360Days;
	}
	
	
	
	
	
	
}
