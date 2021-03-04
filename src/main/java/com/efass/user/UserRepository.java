package com.efass.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface UserRepository extends JpaRepository<UserDAO, Integer>{


	  
	
	  
		@Query(value = "SELECT USER_ID FROM EFASS.EFASS_USERS where username=?", nativeQuery = true)  
	String findByUsername(String username);	
	  

	  
	  
		@Query(value = "SELECT * FROM EFASS.EFASS_USERS where username=?", nativeQuery = true)  
	UserDAO findUserdetails(String username);


		@Query(value = "SELECT * FROM EFASS.EFASS_USERS where username=?", nativeQuery = true) 
		Optional<UserDAO> findUserdetails2(String username);

	  
	
	  
	    
}
