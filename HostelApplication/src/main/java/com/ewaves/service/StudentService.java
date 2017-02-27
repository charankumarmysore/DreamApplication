package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.entities.Role;
import com.ewaves.entities.Student;
import com.ewaves.entities.LoginDetails;
import com.ewaves.repository.RoleRepository;
import com.ewaves.repository.StudentRepository;
import com.ewaves.repository.UserRepository;

@Service
public class StudentService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private StudentRepository studentRepository;

	public void add(Student studentVO) {

		LoginDetails userByName = userRepository.findByUsername(studentVO.getUser().getUsername());

		if (userByName != null) {
			throw new RuntimeException("Användarnamn finns redan.");
		}

		LoginDetails user = studentVO.getUser();

		user.setStudent(studentVO);

		if (user.getRole() != null) {
			Role dbRole = roleRepository.findOne(user.getRole().getId());
			LoginDetails user1 = studentVO.getUser();
			user1.setRole(dbRole);
			studentVO.setUser(user1);
		}

		studentRepository.save(studentVO);

	}

}
