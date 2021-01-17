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
	
	@Column(name = "ONE_THIRTY_DAYS")
	public String oneToThirtyDays;
	
	
	@Column(name = "THIRTYONE_SIX_DAYS")
	public String thirtyOneToSixtyDays;
	
	
	@Column(name = "SIXYONE_NINTY_DAYS")
	public String sixyOneToNintyDays;
	
	
	@Column(name = "NINTYONE_180DAYS")
	public String nintyOneTo180Days;
	
	
	@Column(name = "oneEightyOne-360Days")
	public String oneEightyOneTo360Days;


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


	public String getOneToThirtyDays() {
		return oneToThirtyDays;
	}


	public void setOneToThirtyDays(String oneToThirtyDays) {
		this.oneToThirtyDays = oneToThirtyDays;
	}


	public String getThirtyOneToSixtyDays() {
		return thirtyOneToSixtyDays;
	}


	public void setThirtyOneToSixtyDays(String thirtyOneToSixtyDays) {
		this.thirtyOneToSixtyDays = thirtyOneToSixtyDays;
	}


	public String getSixyOneToNintyDays() {
		return sixyOneToNintyDays;
	}


	public void setSixyOneToNintyDays(String sixyOneToNintyDays) {
		this.sixyOneToNintyDays = sixyOneToNintyDays;
	}


	public String getNintyOneTo180Days() {
		return nintyOneTo180Days;
	}


	public void setNintyOneTo180Days(String nintyOneTo180Days) {
		this.nintyOneTo180Days = nintyOneTo180Days;
	}


	public String getOneEightyOneTo360Days() {
		return oneEightyOneTo360Days;
	}


	public void setOneEightyOneTo360Days(String oneEightyOneTo360Days) {
		this.oneEightyOneTo360Days = oneEightyOneTo360Days;
	}
	
	
	
	
}
