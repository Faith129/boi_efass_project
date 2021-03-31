package com.efass.sheet.mmfbr980;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mmfbr201.sheet201DAO;

@Repository
public interface sheet980Repository extends CrudRepository<sheet980DAO, Integer>{


	@Query(value = "select * from EFASS.MMFBR980 where DURATION=? order by CREATE_DT ", nativeQuery = true)
	ArrayList<sheet980DAO> findByDuration(String duration);
	
	
}
