package com.ewaves.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.LoginDetails;

@Repository("userRepository")
@Transactional
public interface UserRepository extends CrudRepository<LoginDetails, Long>, JpaRepository<LoginDetails, Long> {

	LoginDetails findByUsername(String username);

	/*
	 * @Query("SELECT e FROM User e where e.userName=(:userName)") User
	 * findByUsername(@Param(value = "userName") String userName);
	 */

	 
}
