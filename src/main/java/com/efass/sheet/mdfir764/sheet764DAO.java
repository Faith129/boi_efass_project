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


	  
	  
	@Column(name = "ACCOUNT_TYPE")
	public String account_type;
	
	
	@Column(name = "ONE_TO_30_DAYS")
	public String one_to_30_days;
	
	@Column(name = "THIRTY_ONE_TO_60_DAYS")
	public String thirtyOneTo60Days;
	
	@Column(name = "SIXTY_ONE_TO_90_DAYS")
	public String sixty_one_to_90_days;
	
	
	@Column(name = "NINETY_ONE_TO_180_DAYS")
	public String ninety_one_to_180_days;
	
	
	@Column(name = "ONE_EIGHTY_ONE_TO_360_DAYS")
	public String   one_eighty_one_to_360_days;
	
	
	@Column(name = "ABOVE_360_DAYS")
	public String  above_360_days;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAccount_type() {
		return account_type;
	}


	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}


	public String getOne_to_30_days() {
		return one_to_30_days;
	}


	public void setOne_to_30_days(String one_to_30_days) {
		this.one_to_30_days = one_to_30_days;
	}


	public String getThirtyOneTo60Days() {
		return thirtyOneTo60Days;
	}


	public void setThirtyOneTo60Days(String thirtyOneTo60Days) {
		this.thirtyOneTo60Days = thirtyOneTo60Days;
	}


	public String getSixty_one_to_90_days() {
		return sixty_one_to_90_days;
	}


	public void setSixty_one_to_90_days(String sixty_one_to_90_days) {
		this.sixty_one_to_90_days = sixty_one_to_90_days;
	}


	public String getNinety_one_to_180_days() {
		return ninety_one_to_180_days;
	}


	public void setNinety_one_to_180_days(String ninety_one_to_180_days) {
		this.ninety_one_to_180_days = ninety_one_to_180_days;
	}


	public String getOne_eighty_one_to_360_days() {
		return one_eighty_one_to_360_days;
	}


	public void setOne_eighty_one_to_360_days(String one_eighty_one_to_360_days) {
		this.one_eighty_one_to_360_days = one_eighty_one_to_360_days;
	}


	public String getAbove_360_days() {
		return above_360_days;
	}


	public void setAbove_360_days(String above_360_days) {
		this.above_360_days = above_360_days;
	}


	
}
