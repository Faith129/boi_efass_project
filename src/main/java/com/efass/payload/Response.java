package com.efass.payload;

import java.util.ArrayList;
import java.util.List;

import com.efass.report.ReportDAO;
import com.efass.sheet.mmfbr001.sheet001DAO;
import com.efass.sheet.mmfbr001.sheet001Data;
import com.efass.sheet.mmfbr1000.sheet1000DAO;
import com.efass.sheet.mmfbr1000.sheet1000Data;
import com.efass.sheet.mmfbr141.sheet141DAO;
import com.efass.sheet.mmfbr201.sheet201DAO;
import com.efass.sheet.mmfbr202.sheet202DAO;
import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr300.sheet300DAO;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr312.sheet312DAO;
import com.efass.sheet.mmfbr321.sheet321DAO;
import com.efass.sheet.mmfbr322.sheet322DAO;
import com.efass.sheet.mmfbr451.sheet451DAO;
import com.efass.sheet.mmfbr501.sheet501DAO;
import com.efass.sheet.mmfbr641.sheet641DAO;
import com.efass.sheet.mmfbr642.sheet642DAO;
import com.efass.sheet.mmfbr651.sheet651DAO;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.sheet.mmfbr762.sheet762DAO;
import com.efass.sheet.mmfbr763.sheet763DAO;
import com.efass.sheet.mmfbr764.sheet764DAO;
import com.efass.sheet.mmfbr771.sheet771DAO;
import com.efass.sheet.mmfbr811.sheet811DAO;
import com.efass.sheet.mmfbr933.sheet933DAO;
import com.efass.sheet.mmfbr951.sheet951DAO;
import com.efass.sheet.mmfbr980.sheet980DAO;
import com.efass.sheet.mmfbr996.sheet996DAO;
import com.efass.sheet.table.TabSheet;
import com.efass.user.UserDAO;

public class Response {

public String responseMessage;
public int responseCode;
public UserDAO user;
public Iterable<UserDAO> allUsers;
public String token;
public String filePath;

public String fileId;

public Iterable<sheet221DAO> sheet221;
public sheet221DAO s221Data;


public sheet311DAO s311Data;
public Iterable<sheet311DAO> sheet311;

public sheet321DAO s321Data;
public Iterable<sheet321DAO> sheet321;

public sheet641DAO s641Data;
public Iterable<sheet641DAO> sheet641;

public sheet711DAO s711Data;
public Iterable<sheet711DAO> sheet711;


public sheet746DAO s746Data;
public Iterable<sheet746DAO> sheet746;




public sheet761DAO s761Data;
public Iterable<sheet761DAO> sheet761;

public sheet762DAO s762Data;
public Iterable<sheet762DAO> sheet762;




public sheet771DAO s771Data;
public Iterable<sheet771DAO> sheet771;







public sheet763DAO s763Data;
public Iterable<sheet763DAO> sheet763;




public sheet764DAO s764Data;
public Iterable<sheet764DAO> sheet764;


public sheet811DAO s811Data;
public Iterable<sheet811DAO> sheet811;



public sheet141DAO s141Data;
public Iterable<sheet141DAO> sheet141;



public sheet201DAO s201Data;
public Iterable<sheet201DAO> sheet201;




public sheet202DAO s202Data;
public Iterable<sheet202DAO> sheet202;





public sheet300DAO s300Data;
public Iterable<sheet300DAO> sheet300;



public ArrayList<ReportDAO> ReportData;


public sheet312DAO s312Data;
public Iterable<sheet312DAO> sheet312;


public sheet322DAO s322Data;
public Iterable<sheet322DAO> sheet322;



public sheet451DAO s451Data;
public Iterable<sheet451DAO> sheet451;



public sheet501DAO s501Data;
public Iterable<sheet501DAO> sheet501;



public sheet996DAO s996Data;
public Iterable<sheet996DAO> sheet996;


public sheet980DAO s980Data;
public Iterable<sheet980DAO> sheet980;


public sheet642DAO s642Data;
public Iterable<sheet642DAO> sheet642;



public sheet933DAO s933Data;
public Iterable<sheet933DAO> sheet933;


public sheet951DAO s951Data;
public Iterable<sheet951DAO> sheet951;








public sheet1000DAO s1000Data;
public ArrayList<sheet1000Data> sheet1000;




public sheet001DAO s001Data;

public ArrayList<sheet001Data> sheet001;








//-----------------------------------------------------






public ArrayList<sheet001Data> getSheet001() {
return sheet001;
}

public void setSheet001(ArrayList<sheet001Data> sheet001) {
this.sheet001 = sheet001;
}


public sheet1000DAO getS1000Data() {
return s1000Data;
}

public void setS1000Data(sheet1000DAO s1000Data) {
this.s1000Data = s1000Data;
}





public sheet001DAO getS001Data() {
return s001Data;
}

public void setS001Data(sheet001DAO s001Data) {
this.s001Data = s001Data;
}























public sheet980DAO getS980Data() {
return s980Data;
}

public void setS980Data(sheet980DAO s980Data) {
this.s980Data = s980Data;
}

public sheet300DAO getS300Data() {
return s300Data;
}

public void setS300Data(sheet300DAO s300Data) {
this.s300Data = s300Data;
}

public Iterable<sheet300DAO> getSheet300() {
return sheet300;
}

public void setSheet300(Iterable<sheet300DAO> sheet300) {
this.sheet300 = sheet300;
}






public ArrayList<ReportDAO> getReportData() {
return ReportData;
}

public void setReportData(ArrayList<ReportDAO> reportData) {
ReportData = reportData;
}

public Iterable<sheet980DAO> getSheet980() {
return sheet980;
}

public void setSheet980(Iterable<sheet980DAO> sheet980) {
this.sheet980 = sheet980;
}



public sheet996DAO getS996Data() {
return s996Data;
}

public void setS996Data(sheet996DAO s996Data) {
this.s996Data = s996Data;
}

public Iterable<sheet996DAO> getSheet996() {
return sheet996;
}

public void setSheet996(Iterable<sheet996DAO> sheet996) {
this.sheet996 = sheet996;
}

public sheet951DAO getS951Data() {
return s951Data;
}

public void setS951Data(sheet951DAO s951Data) {
this.s951Data = s951Data;
}

public Iterable<sheet951DAO> getSheet951() {
return sheet951;
}

public void setSheet951(Iterable<sheet951DAO> sheet951) {
this.sheet951 = sheet951;
}

public sheet933DAO getS933Data() {
return s933Data;
}

public void setS933Data(sheet933DAO s933Data) {
this.s933Data = s933Data;
}

public Iterable<sheet933DAO> getSheet933() {
return sheet933;
}

public void setSheet933(Iterable<sheet933DAO> sheet933) {
this.sheet933 = sheet933;
}

public sheet651DAO s651Data;
public Iterable<sheet651DAO> sheet651;


public sheet651DAO getS651Data() {
return s651Data;
}

public void setS651Data(sheet651DAO s651Data) {
this.s651Data = s651Data;
}

public Iterable<sheet651DAO> getSheet651() {
return sheet651;
}

public void setSheet651(Iterable<sheet651DAO> sheet651) {
this.sheet651 = sheet651;
}

public sheet642DAO getS642Data() {
return s642Data;
}

public void setS642Data(sheet642DAO s642Data) {
this.s642Data = s642Data;
}

public Iterable<sheet642DAO> getSheet642() {
return sheet642;
}

public void setSheet642(Iterable<sheet642DAO> sheet642) {
this.sheet642 = sheet642;
}

public ArrayList<String> columnNames;


public ArrayList<String> getColumnNames() {
return columnNames;
}

public void setColumnNames(ArrayList<String> columnNames) {
this.columnNames = columnNames;
}

public sheet501DAO getS501Data() {
return s501Data;
}

public void setS501Data(sheet501DAO s501Data) {
this.s501Data = s501Data;
}

public Iterable<sheet501DAO> getSheet501() {
return sheet501;
}

public void setSheet501(Iterable<sheet501DAO> sheet501) {
this.sheet501 = sheet501;
}

public ArrayList<sheet1000Data> getSheet1000() {
return sheet1000;
}

public void setSheet1000(ArrayList<sheet1000Data> sheet1000) {
this.sheet1000 = sheet1000;
}

public sheet201DAO getS201Data() {
return s201Data;
}

public void setS201Data(sheet201DAO s201Data) {
this.s201Data = s201Data;
}

public Iterable<sheet201DAO> getSheet201() {
return sheet201;
}

public void setSheet201(Iterable<sheet201DAO> sheet201) {
this.sheet201 = sheet201;
}

public sheet764DAO getS764Data() {
return s764Data;
}

public void setS764Data(sheet764DAO s764Data) {
this.s764Data = s764Data;
}

public Iterable<sheet764DAO> getSheet764() {
return sheet764;
}

public void setSheet764(Iterable<sheet764DAO> sheet764) {
this.sheet764 = sheet764;
}

@Override
public String toString() {
return "Response [Sheet321Data=" + s321Data + "]";
}

public Response() {

}



public sheet746DAO getS746Data() {
return s746Data;
}

public void setS746Data(sheet746DAO s746Data) {
this.s746Data = s746Data;
}

public Iterable<sheet746DAO> getSheet746() {
return sheet746;
}

public void setSheet746(Iterable<sheet746DAO> sheet746) {
this.sheet746 = sheet746;
}


public String getResponseMessage() {
return responseMessage;
}

public void setResponseMessage(String responseMessage) {
this.responseMessage = responseMessage;
}

public int getResponseCode() {
return responseCode;
}

public void setResponseCode(int responseCode) {
this.responseCode = responseCode;
}

public sheet202DAO getS202Data() {
return s202Data;
}

public void setS202Data(sheet202DAO s202Data) {
this.s202Data = s202Data;
}

public Iterable<sheet202DAO> getSheet202() {
return sheet202;
}

public void setSheet202(Iterable<sheet202DAO> sheet202) {
this.sheet202 = sheet202;
}

public UserDAO getUser() {
return user;
}

public void setUser(UserDAO user) {
this.user = user;
}

public sheet322DAO getS322Data() {
return s322Data;
}

public void setS322Data(sheet322DAO s322Data) {
this.s322Data = s322Data;
}

public sheet451DAO getS451Data() {
return s451Data;
}

public void setS451Data(sheet451DAO s451Data) {
this.s451Data = s451Data;
}

public Iterable<sheet451DAO> getSheet451() {
return sheet451;
}

public void setSheet451(Iterable<sheet451DAO> sheet451) {
this.sheet451 = sheet451;
}

public Iterable<sheet322DAO> getSheet322() {
return sheet322;
}

public void setSheet322(Iterable<sheet322DAO> sheet322) {
this.sheet322 = sheet322;
}

public Iterable<UserDAO> getAllUsers() {
return allUsers;
}

public void setAllUsers(Iterable<UserDAO> allUsers) {
this.allUsers = allUsers;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public sheet312DAO getS312Data() {
return s312Data;
}

public void setS312Data(sheet312DAO s312Data) {
this.s312Data = s312Data;
}

public Iterable<sheet312DAO> getSheet312() {
return sheet312;
}

public void setSheet312(Iterable<sheet312DAO> sheet312) {
this.sheet312 = sheet312;
}

public Iterable<sheet221DAO> getSheet221() {
return sheet221;
}

public sheet761DAO getS761Data() {
return s761Data;
}

public void setS761Data(sheet761DAO s761Data) {
this.s761Data = s761Data;
}

public sheet811DAO getS811Data() {
return s811Data;
}

public void setS811Data(sheet811DAO s811Data) {
this.s811Data = s811Data;
}

public Iterable<sheet811DAO> getSheet811() {
return sheet811;
}

public void setSheet811(Iterable<sheet811DAO> sheet811) {
this.sheet811 = sheet811;
}

public sheet141DAO getS141Data() {
return s141Data;
}

public void setS141Data(sheet141DAO s141Data) {
this.s141Data = s141Data;
}

public Iterable<sheet141DAO> getSheet141() {
return sheet141;
}

public void setSheet141(Iterable<sheet141DAO> sheet141) {
this.sheet141 = sheet141;
}

public Iterable<sheet761DAO> getSheet761() {
return sheet761;
}

public void setSheet761(Iterable<sheet761DAO> sheet761) {
this.sheet761 = sheet761;
}

public void setSheet221(Iterable<sheet221DAO> sheet221) {
this.sheet221 = sheet221;
}



public sheet221DAO getS221Data() {
return s221Data;
}

public sheet763DAO getS763Data() {
return s763Data;
}

public void setS763Data(sheet763DAO s763Data) {
this.s763Data = s763Data;
}

public Iterable<sheet763DAO> getSheet763() {
return sheet763;
}

public void setSheet763(Iterable<sheet763DAO> sheet763) {
this.sheet763 = sheet763;
}

public void setS221Data(sheet221DAO s221Data) {
this.s221Data = s221Data;
}

public sheet762DAO getS762Data() {
return s762Data;
}

public void setS762Data(sheet762DAO s762Data) {
this.s762Data = s762Data;
}

public Iterable<sheet762DAO> getSheet762() {
return sheet762;
}

public void setSheet762(Iterable<sheet762DAO> sheet762) {
this.sheet762 = sheet762;
}

public sheet771DAO getS771Data() {
return s771Data;
}

public void setS771Data(sheet771DAO s771Data) {
this.s771Data = s771Data;
}

public String getFilePath() {
return filePath;
}

public void setFilePath(String filePath) {
this.filePath = filePath;
}



public Iterable<sheet311DAO> getSheet311() {
return sheet311;
}

public void setSheet311(Iterable<sheet311DAO> sheet311) {
this.sheet311 = sheet311;
}

public sheet311DAO getS311Data() {
return s311Data;
}

public void setS311Data(sheet311DAO s311Data) {
this.s311Data = s311Data;
}

public sheet641DAO getS641Data() {
return s641Data;
}

public void setS641Data(sheet641DAO s641Data) {
this.s641Data = s641Data;
}

public sheet711DAO getS711Data() {
return s711Data;
}

public void setS711Data(sheet711DAO s711Data) {
this.s711Data = s711Data;
}

public sheet321DAO getS321Data() {
return s321Data;
}

public void setS321Data(sheet321DAO s321Data) {
this.s321Data = s321Data;
}

public Iterable<sheet321DAO> getSheet321() {
return sheet321;
}

public void setSheet321(Iterable<sheet321DAO> sheet321) {
this.sheet321 = sheet321;
}



public Iterable<sheet641DAO> getSheet641() {
return sheet641;
}

public void setSheet641(Iterable<sheet641DAO> sheet641) {
this.sheet641 = sheet641;
}



public Iterable<sheet711DAO> getSheet711() {
return sheet711;
}

public void setSheet711(Iterable<sheet711DAO> sheet711) {
this.sheet711 = sheet711;
}



public Iterable<sheet771DAO> getSheet771() {
return sheet771;
}

public void setSheet771(Iterable<sheet771DAO> sheet771) {
this.sheet771 = sheet771;
}

public String getFileId() {
	return fileId;
}

public void setFileId(String fileId) {
	this.fileId = fileId;
}

}