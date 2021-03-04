package com.efass.sheet.mmfbr1000;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface sheet1000Repository extends CrudRepository<sheet1000DAO, Integer>{


@Query(value = "SELECT * FROM EFASS.MMFBR1000 where code=?", nativeQuery = true)
Optional<sheet1000DAO> findByCode(String code);



@Query(value = "SELECT AMOUNT_1 FROM EFASS.MMFBR1000 where code=?", nativeQuery = true)
ArrayList<String> findColumnsByCode(String code);

}


