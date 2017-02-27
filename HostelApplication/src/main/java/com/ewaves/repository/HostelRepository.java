package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.HostelDetails;

@Repository
public interface HostelRepository
		extends PagingAndSortingRepository<HostelDetails, Long>, JpaSpecificationExecutor<HostelDetails> {
	@Query("SELECT e FROM HostelDetails e where e.emailId=(:emailId)")
	HostelDetails findByEmail(@Param(value = "emailId") String emailId);

	@Query("SELECT e FROM HostelDetails e where e.phoneNumber=(:phoneNumber)")
	HostelDetails findByPhone(String phoneNumber);

	// @Value("${spring.queries.roles-query}")
	// private String rolesQuery;

}



