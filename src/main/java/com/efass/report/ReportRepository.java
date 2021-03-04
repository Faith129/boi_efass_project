package com.efass.report;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ReportRepository extends JpaRepository<ReportDAO, Integer>{

	
	
	
	@Query(value = "SELECT * FROM EFASS.Activity where report_date= ?", nativeQuery = true)
	ReportDAO findByDate(String Date);
//
//	
//	
//	
//	
//
	@Query(value = "SELECT * FROM EFASS.Activity where report_date= ?", nativeQuery = true)
	ReportDAO findByPathDate(String Date);
	
	
}
