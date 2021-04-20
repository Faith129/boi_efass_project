package com.efass.sheet.mmfbr300;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface sheet300TemporaryRepository  extends CrudRepository<sheet300TemporaryDAO, Integer>{

	
	@Query(value = "SELECT * FROM EFASS.MMFBR_300 order by code asc", nativeQuery = true)
	ArrayList<sheet300TemporaryDAO> findAllOrderByCode();
	

}
