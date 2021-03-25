package com.efass.specials;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateConverter {

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public Date changeDateToGregorian(String strDate) {
    	  Date newDate=null;
    	  
        try {            
            Date date = new SimpleDateFormat("d-MMM-yy").parse(strDate);

            newDate = date;
        } catch (ParseException e) {
            System.out.println("ParseException occured: " + e.getMessage());
        }
		return newDate;  
        
    	}
    
    
    public String changeDateToGregorian2(String dateStr, String format) throws ParseException{



    	String newDate=null;
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	try {
    	Date date = sdf.parse(dateStr);
    	sdf = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf.format(date);
    	System.out.println(sdf.format(date));


    	} catch (ParseException e) {


    	try {
    	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/mm/yyyy");
    	Date date = sdf2.parse(dateStr);
    	sdf2 = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf2.format(date);
    	System.out.println(sdf2.format(date));

    	}catch(ParseException ex) {

    	try {
    	SimpleDateFormat sdf3 = new SimpleDateFormat("dd-mm-yyyy");
    	Date date = sdf3.parse(dateStr);
    	sdf3 = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf3.format(date);
    	System.out.println(sdf3.format(date));




    	}catch(ParseException ex3) {

    	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-mm-dd");
    	Date date = sdf3.parse(dateStr);
    	sdf3 = new SimpleDateFormat("dd/mm/yyyy");
    	newDate = sdf3.format(date);
    	System.out.println(sdf3.format(date));

    	}


    	}



    	// e.printStackTrace();
    	}
    	return newDate;
    	}
    
    
    
    public String changeDateTime(String dateStr){
        
   	 String newDate=null;
   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
   	 try {
   	  Date date = sdf.parse(dateStr);
   	  sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");
   	  newDate = sdf.format(date);
   	  System.out.println(sdf.format(date));
   	  
   	  
   	 } catch (ParseException e) {
   	  e.printStackTrace();
   	 }
		return newDate;
   }
    
}
