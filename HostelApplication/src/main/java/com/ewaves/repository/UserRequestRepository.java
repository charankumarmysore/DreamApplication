package com.ewaves.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.StudentRequest;

@Repository
@Transactional
public interface UserRequestRepository extends CrudRepository<StudentRequest, Long>, JpaRepository<StudentRequest, Long> {

}
