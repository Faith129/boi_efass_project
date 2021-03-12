package com.efass.sheet.mmfbr300;

import java.util.ArrayList;

import javax.persistence.Column;

public class CodeColData {

	@Column(name="ID")
	public int id;
	
	public ArrayList<String> value;
	
	//	@Column(name="AMOUNT_1")
	public String code;
	

	
public ArrayList<String> getValue() {
		return value;
	}

	public void setValue(ArrayList<String> value) {
		this.value = value;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getCol1() {
//		return col1;
//	}
//
//	public void setCol1(String col1) {
//		this.col1 = col1;
//	}
	
	
}
