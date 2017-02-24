package com.ewaves.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.UserRequest;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserRequest, Long> {

}
