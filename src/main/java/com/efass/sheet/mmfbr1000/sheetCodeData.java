package com.efass.sheet.mmfbr1000;

import java.util.ArrayList;

import javax.persistence.Column;

public class sheetCodeData {

	
	public String code;
	
	
	public ArrayList<String> value;

	public int id;



	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public ArrayList<String> getValue() {
		return value;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setValue(ArrayList<String> value) {
		this.value = value;
	}
	
	
	

	
	
	
	
}
