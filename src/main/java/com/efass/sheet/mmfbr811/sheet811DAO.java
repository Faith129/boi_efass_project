package com.efass.sheet.mmfbr811;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMFBR811")
public class sheet811DAO {

	
	  
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	
	
	@Column(name = "CODE")
	public String code;
	
	@Column(name = "ITEM")
	public String item;
	
	
	@Column(name = "PERFORMING")
	public String performing;
	
	
	@Column(name = "NONPERFFORMING")
	public String nonPerforming;


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


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getPerforming() {
		return performing;
	}


	public void setPerforming(String performing) {
		this.performing = performing;
	}


	public String getNonPerforming() {
		return nonPerforming;
	}


	public void setNonPerforming(String nonPerforming) {
		this.nonPerforming = nonPerforming;
	}
	
	
	
	
	
	
	
	
}
