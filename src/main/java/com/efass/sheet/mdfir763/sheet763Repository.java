package com.efass.sheet.mmfbr763;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sheet763Repository extends CrudRepository<sheet763DAO, Integer> {

	
	@Query(value = "select * from EFASS.MMFBR763 where DURATION=?", nativeQuery = true)
	ArrayList<sheet763DAO> findByDuration(String duration);

}
