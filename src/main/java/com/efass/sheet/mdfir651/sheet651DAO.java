package com.efass.sheet.mmfbr651;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR651")
public class sheet651DAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "LENDING_INSTIT_NAME")
	public String Name_of_lending_institution;
	
	@Column(name = "COUNTRY")
	public String country;
	
	@Column(name = "DATE_FACILITY_GRANTED")
	public String date_facility_granted;
	
	
	@Column(name = "TENOR")
	public String tenor;
	
	
	@Column(name = "AMOUNT")
	public String amount_granted;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName_of_lending_institution() {
		return Name_of_lending_institution;
	}


	public void setName_of_lending_institution(String name_of_lending_institution) {
		Name_of_lending_institution = name_of_lending_institution;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDate_facility_granted() {
		return date_facility_granted;
	}


	public void setDate_facility_granted(String date_facility_granted) {
		this.date_facility_granted = date_facility_granted;
	}


	public String getTenor() {
		return tenor;
	}


	public void setTenor(String tenor) {
		this.tenor = tenor;
	}


	public String getAmount_granted() {
		return amount_granted;
	}


	public void setAmount_granted(String amount_granted) {
		this.amount_granted = amount_granted;
	}

	
}
