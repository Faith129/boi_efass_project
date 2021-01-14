package com.efass.payload;

import java.util.ArrayList;

import com.efass.sheet.mmfbr221.sheet221DAO;
import com.efass.sheet.mmfbr311.sheet311DAO;
import com.efass.sheet.mmfbr321.sheet321DAO;
import com.efass.sheet.mmfbr641.sheet641DAO;
import com.efass.sheet.mmfbr711.sheet711DAO;
import com.efass.sheet.mmfbr746.sheet746DAO;
import com.efass.sheet.mmfbr761.sheet761DAO;
import com.efass.user.UserDAO;

public class Response {

	public String responseMessage;
	public int responseCode;
	public UserDAO user;
	public Iterable<UserDAO> allUsers;
	public String token;
	public String filePath;
	
	
	
	public Iterable<sheet221DAO> sheet211;
	public sheet221DAO s211Data;


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

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
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

	public Iterable<sheet221DAO> getSheet211() {
		return sheet211;
	}

	public sheet761DAO getS761Data() {
		return s761Data;
	}

	public void setS761Data(sheet761DAO s761Data) {
		this.s761Data = s761Data;
	}

	public Iterable<sheet761DAO> getSheet761() {
		return sheet761;
	}

	public void setSheet761(Iterable<sheet761DAO> sheet761) {
		this.sheet761 = sheet761;
	}

	public void setSheet211(Iterable<sheet221DAO> sheet211) {
		this.sheet211 = sheet211;
	}

	

	public sheet221DAO getS211Data() {
		return s211Data;
	}

	public void setS211Data(sheet221DAO s211Data) {
		this.s211Data = s211Data;
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

}
