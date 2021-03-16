package com.efass.sheet.mmfbr001;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBRM001")
public class sheet001DAO {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name="CODE")
	public String code;
	
	
	
	
	@Column(name="DESCRIPTION")
	public String description;
	
	
	@Column(name="NUMBER_1")
	public String NUMBER_1;
	
	
	@Column(name="VALUE_1")
	public String VALUE_1;
	
	
	
	
	
	@Column(name="NUMBER_2")
	public String NUMBER_2;
	
	
	
	@Column(name="VALUE_2")
	public String VALUE_2;
	
	
	





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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getNUMBER_1() {
		return NUMBER_1;
	}




	public void setNUMBER_1(String nUMBER_1) {
		NUMBER_1 = nUMBER_1;
	}




	public String getVALUE_1() {
		return VALUE_1;
	}




	public void setVALUE_1(String vALUE_1) {
		VALUE_1 = vALUE_1;
	}




	public String getNUMBER_2() {
		return NUMBER_2;
	}




	public void setNUMBER_2(String nUMBER_2) {
		NUMBER_2 = nUMBER_2;
	}




	public String getVALUE_2() {
		return VALUE_2;
	}




	public void setVALUE_2(String vALUE_2) {
		VALUE_2 = vALUE_2;
	}




	
	
}
