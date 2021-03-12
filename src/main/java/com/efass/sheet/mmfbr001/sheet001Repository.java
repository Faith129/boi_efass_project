package com.efass.sheet.mmfbr001;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface sheet001Repository extends CrudRepository <sheet001DAO, Integer>{

	
	
	
	@Query(value = "SELECT * FROM EFASS.MMFBRM001 where CODE=?", nativeQuery = true)
	sheet001DAO findColumnsByCode(String code);
	
	
	
	@Query(value = "SELECT * FROM EFASS.MMFBRM001 where CODE=?", nativeQuery = true)
	Optional<sheet001DAO> findByCode(String code);

}


