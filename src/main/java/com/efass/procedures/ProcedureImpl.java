package com.efass.procedures;

import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.efass.specials.DateConverter;

import oracle.jdbc.OracleTypes;


@Repository
public class ProcedureImpl implements ProcedureService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	private SimpleJdbcCall simpleJdbcCall;
	

	
	
	
	
	
	public void callPrepareTableProcedure( String date, String procedureName) throws ParseException {
		

	
		try {
	    simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
	            .withProcedureName(procedureName)
	            .declareParameters(
	                new SqlOutParameter("PV_TRANS_DATE", OracleTypes.DATE));
	    
	   
	     
	     

	    
		SqlParameterSource input = new MapSqlParameterSource().addValue("PV_TRANS_DATE",date);
		
		Map<String, Object> out = simpleJdbcCall.execute(input);
	         
	        
	        out.entrySet().forEach(entry->{
	            System.out.println(procedureName+ "Execution Success: "+ entry.getKey() + " " + entry.getValue());  
	         });
	        
			} catch (Exception ex) {
			System.out.println(procedureName + "Could not Execute" + ex.getMessage());
			ex.printStackTrace();
	
		}
	     	  
		
	}
	
	
//	
//	public void callPrepareTableProcedure_311( String date) throws ParseException {
//		
//		
//		
//		
//		
//		try {
//	    simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
//	            .withProcedureName("PROC_MMFBR_311")
//	            .declareParameters(
//	                new SqlOutParameter("PV_TRANS_DATE", Types.DATE));
//	        
//	        
//	        Map<String, Object> out = simpleJdbcCall.execute(
//	            new MapSqlParameterSource()
//	            .addValue("PV_TRANS_DATE", date));
//	         
//			} catch (Exception ex) {
//			System.out.println("PROC_MMFBR_221  Could not Execute" + ex.getMessage());
//			ex.printStackTrace();
//	
//		}
//	     
//		
//		
//		
//		try {
//			
//			
//			String _date =  dateSvc.changeDateToGregorian2(date);
//			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
//					.withProcedureName("PROC_MMFBR_311");
//
//			jdbcCall.addDeclaredParameter(new SqlParameter("PV_TRANS_DATE", OracleTypes.DATE));
//			SqlParameterSource input = new MapSqlParameterSource().addValue("PV_TRANS_DATE",_date);
//			Map<String, Object> out = jdbcCall.execute(input);
//			
//		
//
//		} catch (Exception ex) {
//			System.out.println("PROC_MMFBR_311  Could not Execute" + ex.getMessage());
//			ex.printStackTrace();
//	
//		}
//		
//	}
//	
	
	

//	public void callPrepareTableProcedure_141( String date) throws ParseException {
//			
//
//			try {
//				
//				
//				String _date =  dateSvc.changeDateToGregorian2(date);
//				SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
//						.withProcedureName("PROC_MMFBR_141");
//
//				jdbcCall.addDeclaredParameter(new SqlParameter("PV_TRANS_DATE", OracleTypes.DATE));
//				SqlParameterSource input = new MapSqlParameterSource().addValue("PV_TRANS_DATE",_date);
//				Map<String, Object> out = jdbcCall.execute(input);
//				
//			
//
//			} catch (Exception ex) {
//				System.out.println("PROC_MMFBR_141  Could not Execute" + ex.getMessage());
//				ex.printStackTrace();
//		
//			}
//			
//	}
	   
	   
}
