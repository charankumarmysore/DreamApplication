package com.ewaves.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.HostelDetails;
@Repository
@Transactional
public interface HostelRepossitory extends CrudRepository<HostelDetails, Long> {

	

	HostelDetails findByEmailId(String emailId);

}
