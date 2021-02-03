package com.efass.report;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReportRepository extends CrudRepository<ReportDAO, Integer>{


//	@Query(value = "SELECT report_date FROM U WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//	String findByDate(String Date);
	
	
	
	@Query(value = "SELECT * FROM EFASS.Activity where report_date= ?", nativeQuery = true)
	ReportDAO findByDate(String Date);

	
	
	@Query(value = "SELECT file_path FROM EFASS.Activity where report_date= ?1", nativeQuery = true)
	String findByPathDate(String Date);
	
	
}
