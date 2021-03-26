package com.efass.sheet.mmfbr501;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mmfbr201.sheet201DAO;

@Repository
public interface sheet501Repository extends CrudRepository<sheet501DAO, Integer>{
	

	@Query(value = "select * from EFASS.MMFBR501 order by BANK_CODE ASC ", nativeQuery = true)
	ArrayList<sheet501DAO> findAllByBankCode();


}
