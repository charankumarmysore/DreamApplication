package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ewaves.entities.HostelDetails;
import com.ewaves.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>, JpaRepository<Role, Long> {

}
