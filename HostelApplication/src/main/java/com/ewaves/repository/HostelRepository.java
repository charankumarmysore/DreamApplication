package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.HostelDetails;

@Repository
public interface HostelRepository extends CrudRepository<HostelDetails, Long>, JpaRepository<HostelDetails, Long> {
	@Query
	HostelDetails findByEmail(String emailId);

	// @Value("${spring.queries.roles-query}")
	// private String rolesQuery;

}
