package com.efass.sheet.mmfbr300;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface sheet300Repository extends CrudRepository<sheet300DAO, Integer>{
	@Query(value = "SELECT * FROM EFASS.MMFBR300 where code=?", nativeQuery = true)
	Optional<sheet300DAO> findByCode(String code);
}
