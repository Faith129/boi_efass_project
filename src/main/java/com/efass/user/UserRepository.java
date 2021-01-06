package com.efass.user;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserDAO, Integer>{

	
	
	//@Query(value="select * from efass_users e where e.username= 1?")
	//UserDAO findByUsername(String username);

	
	  @Query("SELECT e.USER_ID FROM EFASS_USERS e where e.USERNAME = :username") 
	  String findByUsername(@Param("username") String username);

	  
	
	  
	    
}
