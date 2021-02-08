package com.efass.sheet.mmfbr933;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR811")
public class sheet933DAO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	
	
	@Column(name = "INSTITUTION_NAME")
	public String institution_name;
	
	
	@Column(name = "COUNTRY")
	public String country;
	
	
	@Column(name = "PURPOSE")
	public String purpose;
	
	@Column(name = "OUTSTAN_DEF_GRANT_DONTN_AMT")
	public String outstanding_deferred_grants_amount;
	
	
	
	
	@Column(name = "AMOUNT_TRF_TO_GENE_RESERV")
	public String amount_transferred_to_general_reserves;




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getInstitution_name() {
		return institution_name;
	}




	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getPurpose() {
		return purpose;
	}




	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}




	public String getOutstanding_deferred_grants_amount() {
		return outstanding_deferred_grants_amount;
	}




	public void setOutstanding_deferred_grants_amount(String outstanding_deferred_grants_amount) {
		this.outstanding_deferred_grants_amount = outstanding_deferred_grants_amount;
	}




	public String getAmount_transferred_to_general_reserves() {
		return amount_transferred_to_general_reserves;
	}




	public void setAmount_transferred_to_general_reserves(String amount_transferred_to_general_reserves) {
		this.amount_transferred_to_general_reserves = amount_transferred_to_general_reserves;
	}
	
	
	
	
}
