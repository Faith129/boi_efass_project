/*
 * package com.efass.specials;
 * 
 * import java.text.DateFormat; import java.text.ParseException; import
 * java.text.SimpleDateFormat; import java.util.Date; import java.util.Locale;
 * public class StringToDateDemo{ public static void main(String args[]) {
 * String testDateString = "02/04/2014"; String testDateString2 =
 * "02-04-2014 23:37:50"; String testDateString3 = "02-Apr-2014"; String
 * testDateString4 = "04 02, 2014"; String testDateString5 = "Thu, Apr 02 2014";
 * String testDateString6 = "Thu, Apr 02 2014 23:37:50"; DateFormat df = new
 * SimpleDateFormat("dd/MM/yyyy"); DateFormat df2 = new
 * SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); DateFormat df3 = new
 * SimpleDateFormat("dd-MMM-yyyy"); DateFormat df4 = new
 * SimpleDateFormat("MM dd, yyyy"); DateFormat df5 = new
 * SimpleDateFormat("E, MMM dd yyyy"); DateFormat df6 = new
 * SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
 * 
 * 
 * 
 * // String strDate = "9 Apr 1980"; String strDate = "24-JAN-20";
 * 
 * try { Date date = new SimpleDateFormat("d-MMM-yy").parse(strDate);
 * System.out.println("Date: " + date);
 * 
 * 
 * System.out.println("Date: "+df.format(date));
 * 
 * String _date = df.format(date);
 * 
 * Date mydate = new SimpleDateFormat("dd/mm/yyyy").parse(_date);
 * 
 * System.out.println("My Date: "+mydate);
 * 
 * // String string = "24-JAN-20"; // DateFormat format = new
 * SimpleDateFormat("d-MMM-yy").parse(strDate); // Date date =
 * format.parse(string); // System.out.println(date); // Sat Jan 02 00:00:00 GMT
 * 2010
 * 
 * } catch (ParseException e) { System.out.println("ParseException occured: " +
 * e.getMessage()); }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */