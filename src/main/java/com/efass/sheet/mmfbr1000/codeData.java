package com.efass.sheet.mmfbr1000;

import javax.persistence.Column;

public class codeData {

	@Column(name="ID")
	public int id;
	
	@Column(name="AMOUNT_1")
	public String col1;
	
	
	
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
