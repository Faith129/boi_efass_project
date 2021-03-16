package com.efass.sheet.mmfbr300;

import java.util.ArrayList;

import javax.persistence.Column;

public class codeData {

	@Column(name="ID")
	public int id;
	
	@Column(name="AMOUNT_1")
	public String col1;
	
	public String code;
	
	public ArrayList<String> value;
	

	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<String> getValue() {
		return value;
	}
	public void setValue(ArrayList<String> value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCol1() {
		return col1;
	}
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	
}
