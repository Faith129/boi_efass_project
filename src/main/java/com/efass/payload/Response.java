package com.efass.payload;

import java.util.ArrayList;

import com.efass.user.UserDAO;

public class Response {

	
	public String responseMessage;
	public int responseCode;
	public UserDAO user;
	public Iterable<UserDAO> allUsers;
	public String token; 
	
	
	
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
	public ArrayList<Object> getData() {
		return data;
	}
	public void setData(ArrayList<Object> data) {
		this.data = data;
	}
	
	
	
	public UserDAO getUser() {
		return user;
	}
	public void setUser(UserDAO user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Iterable<UserDAO> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(Iterable<UserDAO> allUsers) {
		this.allUsers = allUsers;
	}
	public ArrayList<Object> data;
	
	
}
