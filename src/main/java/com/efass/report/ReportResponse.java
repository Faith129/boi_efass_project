package com.efass.report;

import java.util.ArrayList;

public class ReportResponse {

	
	public String responseMessage;
	public int responseCode;
	
	ArrayList<ReportDAO> reportData;

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

	public ArrayList<ReportDAO> getReportData() {
		return reportData;
	}

	public void setReportData(ArrayList<ReportDAO> reportData) {
		this.reportData = reportData;
	}

	
	
	
}
