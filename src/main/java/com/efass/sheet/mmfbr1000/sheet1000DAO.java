package com.efass.sheet.mmfbr1000;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "MMFBR1000")
public class sheet1000DAO {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name="CODE")
	public String code;
	
	
	@Column(name="DESCRIPTION")
	public String decsription;
	
	@Column(name="AMOUNT_1")
	public String amount_1;
	
	@Column(name="AMOUNT_2")
	public String amount_2;
	
	@Column(name="AMOUNT_3")
	public String amount_3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDecsription() {
		return decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	public String getAmount_1() {
		return amount_1;
	}

	public void setAmount_1(String amount_1) {
		this.amount_1 = amount_1;
	}

	public String getAmount_2() {
		return amount_2;
	}

	public void setAmount_2(String amount_2) {
		this.amount_2 = amount_2;
	}

	public String getAmount_3() {
		return amount_3;
	}

	public void setAmount_3(String amount_3) {
		this.amount_3 = amount_3;
	}
	
	
	
	

}
