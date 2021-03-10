package com.efass;

import org.springframework.stereotype.Service;

@Service
public class Validation {

	
public String checkDataType(String value) {
		
		String 	data=null;
		Boolean date = isDate(value);
		Boolean alpha = isAlpha(value);
		Boolean num = isNum(value);
	
	if (value.equals(null)) {
		data = "Null";	
	}

	else if (alpha) {
		data= "Alpha";
	}else if(num) {
		
		data= "Num";
	}else if(date) {
		data= "Date";
	}
	else if(date) {
		data= "Date";
	}
	

	return data;
	
		
	}
	
	
	
	
	public Boolean isAlphaNum(String str){
		
		  for (int i=0; i<str.length(); i++) {
		        char c = str.charAt(i);
		        if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
		            return false;
		    }

		    return true;
		
		
	}
	
	
	public Boolean isAlpha(String Value) {
		
		if (Value.matches(".*[a-zA-Z]+.*")) {
			
			return true;
		}else {
			return false;
		}	
	}
	
	public Boolean isDate(String Value) {
		
		if (Value.matches("^([1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/([12][0-9]{3})$")) {
			
			return true;
		}else {
			return false;
		}	
	}
	
	
	
	
	public Boolean isNum(String strNum) {
		
		if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	

}
