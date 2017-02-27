package com.ewaves.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.LoginDetails;

@Repository("userRepository")
@Transactional
public interface UserRepository extends CrudRepository<LoginDetails, Long>, JpaRepository<LoginDetails, Long> {
	@Query("SELECT e FROM LoginDetails e where e.username=(:username)")
	LoginDetails findByUsername(@Param(value = "username") String username);

}
