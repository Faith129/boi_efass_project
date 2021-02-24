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

	
	

	   
	@Column(name = "LOAN_TYPE")
	public String typeOfLoans;
	
	
	
	
	
	@Column(name = "ONE_TO_30_DAYS")
	public String one_to_30_Days;
	
	@Column(name = "THIRTY_ONE_TO_60_DAYS")
	public String thirty_one_to_60_Days;
	
	@Column(name = "SIXTY_ONE_TO_90_DAYS")
	public String sixty_one_to_90_days;
	
	
	
	@Column(name = "NINETY_ONE_TO_180_DAYS")
	public String ninty_one_to_180_days;
	
	
	@Column(name = "ONE_EIGHTY_ONE_TO_360_DAYS")
	public String one_eighty_one_to_360_days;
	
	
	@Column(name = "ABOVE_360_DAYS")
	public String above_360_days;
	
	
	
	
	@Column(name = "TOTAL")
	public String total;

	
	
	@Column(name = "TYPE_ID")
	public String typeId;

	
	@Column(name = "LOAN_ID")
	public String loanId;

	public String getLoanId() {
		return loanId;
	}


	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeOfLoans() {
		return typeOfLoans;
	}


	public String getOne_to_30_Days() {
		return one_to_30_Days;
	}


	public void setOne_to_30_Days(String one_to_30_Days) {
		this.one_to_30_Days = one_to_30_Days;
	}


	public String getThirty_one_to_60_Days() {
		return thirty_one_to_60_Days;
	}


	public void setThirty_one_to_60_Days(String thirty_one_to_60_Days) {
		this.thirty_one_to_60_Days = thirty_one_to_60_Days;
	}


	public String getSixty_one_to_90_days() {
		return sixty_one_to_90_days;
	}


	public void setSixty_one_to_90_days(String sixty_one_to_90_days) {
		this.sixty_one_to_90_days = sixty_one_to_90_days;
	}


	public String getNinty_one_to_180_days() {
		return ninty_one_to_180_days;
	}


	public void setNinty_one_to_180_days(String ninty_one_to_180_days) {
		this.ninty_one_to_180_days = ninty_one_to_180_days;
	}


	public String getOne_eighty_one_to_360_days() {
		return one_eighty_one_to_360_days;
	}


	public void setOne_eighty_one_to_360_days(String one_eighty_one_to_360_days) {
		this.one_eighty_one_to_360_days = one_eighty_one_to_360_days;
	}


	public String getTypeId() {
		return typeId;
	}


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public String getAbove_360_days() {
		return above_360_days;
	}


	public void setAbove_360_days(String above_360_days) {
		this.above_360_days = above_360_days;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public void setTypeOfLoans(String typeOfLoans) {
		this.typeOfLoans = typeOfLoans;
	}


	
	
	
	
	
	
	
}
