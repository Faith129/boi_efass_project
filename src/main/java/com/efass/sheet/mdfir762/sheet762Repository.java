package com.efass.sheet.mmfbr762;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mmfbr501.sheet501DAO;
@Repository
public interface sheet762Repository extends CrudRepository<sheet762DAO, Integer>{
	
	@Query(value = "select * from EFASS.MMFBR762 order by ID ASC ", nativeQuery = true)
	ArrayList<sheet762DAO> findAllById();

}
