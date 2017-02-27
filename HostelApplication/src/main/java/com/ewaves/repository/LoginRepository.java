package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ewaves.entities.LoginDetails;

public interface LoginRepository extends CrudRepository<LoginDetails, Long>, JpaRepository<LoginDetails, Long> {

	LoginDetails findUserName(String userName);

}
