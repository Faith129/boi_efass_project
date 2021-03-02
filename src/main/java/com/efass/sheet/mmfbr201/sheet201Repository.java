package com.efass.sheet.mmfbr201;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.report.ReportDAO;

@Repository
public interface sheet201Repository extends CrudRepository<sheet201DAO, Integer>{

	
	
	@Query(value = "select * from EFASS.MMFBR201 where DURATION=? order by CREATE_DT ", nativeQuery = true)
	ArrayList<sheet201DAO> findByDuration(String duration);
	
	
//	@Query(value = "SELECT * FROM EFASS.Activity where report_date= ?", nativeQuery = true)
//	ReportDAO findByDate(String Date);



}
