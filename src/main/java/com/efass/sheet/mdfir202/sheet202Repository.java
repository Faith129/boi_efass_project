package com.efass.sheet.mmfbr202;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.efass.sheet.mmfbr201.sheet201DAO;
@Repository
public interface sheet202Repository extends CrudRepository<sheet202DAO, Integer>{
	
	@Query(value = "select * from EFASS.MMFBR202 where PRICE_RANGE=? order by CREATE_DT ", nativeQuery = true)
	ArrayList<sheet202DAO> findByPriceRange(String pricerange);

}