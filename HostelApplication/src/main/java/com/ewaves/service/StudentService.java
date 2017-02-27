package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.entities.Role;
import com.ewaves.entities.Student;
import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.repository.RoleRepository;
import com.ewaves.repository.StudentRepository;
import com.ewaves.repository.UserRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class StudentService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private StudentRepository studentRepository;

	public ResponseVO studentRegistration(Student studentVO) {

		LoginDetails userByName = userRepository.findByUsername(studentVO.getUser().getUsername());

		if (userByName != null) {
			return HttpStatusCode.ALREADY_USERNAME_EXISTS.getResponseVO("FAILURE");
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

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
