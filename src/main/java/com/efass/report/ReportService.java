package com.efass.report;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.http.ResponseEntity;

public interface ReportService {
	public ResponseEntity<?> selectDate(LocalDate since);
	public Boolean checkDate(LocalDate Date);
	public ReportDAO findDate(LocalDate Date);
	
	public ResponseEntity<?> NoDateFound();
}
