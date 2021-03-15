package com.efass.procedures;

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
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;


@Repository
public class ProcedureImpl implements ProcedureService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	private SimpleJdbcCall simpleJdbcCall;
	
	
	
//	
//	public void setDataSource(DataSource dataSource) {
//
//		this.simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("efs_prepare_table");
//	}
	

	// Call Prepare Table Stored Procedure
	
	
	public String dateConversion(String date) throws ParseException {
		
		DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Date mydate = new SimpleDateFormat("yyyy-mm-dd").parse(date);

		String _date =df2.format(mydate);
		
		return _date;
	}
	
	
	
	
	
	
	
	public void callPrepareTableProcedure_221( String date) throws ParseException {
		
		try {
			
			
			String _date = dateConversion(date);
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
					.withProcedureName("PROC_MMFBR_221");

			jdbcCall.addDeclaredParameter(new SqlParameter("PV_TRANS_DATE", OracleTypes.DATE));
			SqlParameterSource input = new MapSqlParameterSource().addValue("PV_TRANS_DATE",_date);
			Map<String, Object> out = jdbcCall.execute(input);
			
		

		} catch (Exception ex) {
			System.out.println("PROC_MMFBR_221  Could not Execute" + ex.getMessage());
			ex.printStackTrace();
	
		}
		
	}
	
	
	
	public void callPrepareTableProcedure_311( String date) throws ParseException {
		
		try {
			
			
			String _date = dateConversion(date);
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
					.withProcedureName("PROC_MMFBR_311");

			jdbcCall.addDeclaredParameter(new SqlParameter("PV_TRANS_DATE", OracleTypes.DATE));
			SqlParameterSource input = new MapSqlParameterSource().addValue("PV_TRANS_DATE",_date);
			Map<String, Object> out = jdbcCall.execute(input);
			
		

		} catch (Exception ex) {
			System.out.println("PROC_MMFBR_311  Could not Execute" + ex.getMessage());
			ex.printStackTrace();
	
		}
		
	}
	
	
	

	public void callPrepareTableProcedure_141( String date) throws ParseException {
			

			try {
				
				
				String _date = dateConversion(date);
				SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("EFASS")
						.withProcedureName("PROC_MMFBR_141");

				jdbcCall.addDeclaredParameter(new SqlParameter("PV_TRANS_DATE", OracleTypes.DATE));
				SqlParameterSource input = new MapSqlParameterSource().addValue("PV_TRANS_DATE",_date);
				Map<String, Object> out = jdbcCall.execute(input);
				
			

			} catch (Exception ex) {
				System.out.println("PROC_MMFBR_141  Could not Execute" + ex.getMessage());
				ex.printStackTrace();
		
			}
			
	}
	   
	   
}
