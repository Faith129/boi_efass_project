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

	@Column(name="DEPOSIT_TYPE")
	public String typeOfDeposit;
	
	@Column(name = "ONE_TO_30_DAYS")
	public int oneToThirtyDays;
	
	
	@Column(name = "THIRTY_ONE_TO_60_DAYS")
	public int thirtyOneToSixtyDays;
	
	
	@Column(name = "SIXTY_ONE_TO_90_DAYS")
	public int sixyOneToNintyDays;
	
	
	@Column(name = "NINETY_ONE_TO_180_DAYS")
	public int nintyOneTo180Days;
	
	
	@Column(name = "ONE_EIGHTY_ONE_TO_360_Days")
	public int oneEightyOneTo360Days;

	@Column(name = "ABOVE_360_DAYS")
	public int above360Days;
	
	
	
	
	
	
	
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


	public int getOneToThirtyDays() {
		return oneToThirtyDays;
	}


	public void setOneToThirtyDays(int oneToThirtyDays) {
		this.oneToThirtyDays = oneToThirtyDays;
	}


	public int getThirtyOneToSixtyDays() {
		return thirtyOneToSixtyDays;
	}


	public void setThirtyOneToSixtyDays(int thirtyOneToSixtyDays) {
		this.thirtyOneToSixtyDays = thirtyOneToSixtyDays;
	}


	public int getSixyOneToNintyDays() {
		return sixyOneToNintyDays;
	}


	public void setSixyOneToNintyDays(int sixyOneToNintyDays) {
		this.sixyOneToNintyDays = sixyOneToNintyDays;
	}


	public int getNintyOneTo180Days() {
		return nintyOneTo180Days;
	}


	public void setNintyOneTo180Days(int nintyOneTo180Days) {
		this.nintyOneTo180Days = nintyOneTo180Days;
	}


	public int getOneEightyOneTo360Days() {
		return oneEightyOneTo360Days;
	}


	public int getAbove360Days() {
		return above360Days;
	}


	public void setAbove360Days(int above360Days) {
		this.above360Days = above360Days;
	}


	public void setOneEightyOneTo360Days(int oneEightyOneTo360Days) {
		this.oneEightyOneTo360Days = oneEightyOneTo360Days;
	}
	
	
	
	
}
