package com.efass.sheet.mmfbr001;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.efass.sheet.mmfbr1000.sheet1000DAO;


public interface sheet001Repository extends CrudRepository <sheet001DAO, Integer>{

	
	
	
	@Query(value = "SELECT * FROM EFASS.MMFBRM001 where code=?", nativeQuery = true)
	sheet001DAO findColumnsByCode(String code);

}
