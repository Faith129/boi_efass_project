
package com.efass.sheet.mmfbr300;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.efass.sheet.mmfbr1000.sheet1000DAO;

@Transactional
@Repository
public interface sheet300Repository extends CrudRepository<sheet300DAO, Integer>{
	
	
	@Query(value = "SELECT * FROM EFASS.MMFBR300 where code=?", nativeQuery = true)
	Optional<sheet300DAO> findByCode(String code);
	

	@Query(value = "SELECT * FROM EFASS.MMFBR300 where code=?", nativeQuery = true)
	sheet300DAO findColumnsByCode(String code);


}
