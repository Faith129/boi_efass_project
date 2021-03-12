package com.efass.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportCall {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	
	
	
	public List<ReportDAO> fetchDate(String date) {
		List<ReportDAO> listReport = null;
		
		try {
			String sql = "SELECT * FROM  EFASS.Activity  where report_date= ?";
			listReport = jdbcTemplate.query(sql, new Object[] { date },
					BeanPropertyRowMapper.newInstance(ReportDAO.class));
			return listReport;
		} catch (EmptyResultDataAccessException e) {
			return listReport;
		}
		
		
		
		
//		 String sql = "SELECT * FROM FROM EFASS.Activity  where report_date= ? ";
//		 Object[] inputs = new Object[] { date };
//	        List data = jdbcTemplate.query(
//	                sql,inputs,
//	                new BeanPropertyRowMapper(ReportDAO.class));
//	        return data;
//	        
		
		
		
//		
//		String query = "SELECT report_date FROM EFASS.Activity where report_date= ? LIMIT 1";
//		Object[] inputs = new Object[] { date };
//		String _date = jdbcTemplate.queryForObject(query, inputs, String.class);
//		return _date;
	}

}
