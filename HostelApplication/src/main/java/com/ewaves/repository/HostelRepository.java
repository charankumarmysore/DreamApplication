package com.ewaves.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.HostelDetails;

@Repository("hostelRepossitory")
@Transactional
public interface HostelRepository extends CrudRepository<HostelDetails, Long>, JpaRepository<HostelDetails, Long> {

	
	
	
	
	
	// @Value("${spring.queries.roles-query}")
	// private String rolesQuery;

}
