package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.Role;
import com.ewaves.entities.Student;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * @Autowired private TokenRepository tokenRepository;
	 */

	public ResponseVO studentRegistration(Student studentVO) {

		Student dbPhoneNumber = studentRepository.findByphone(studentVO.getPhone());
		if (dbPhoneNumber != null) {
			return HttpStatusCode.ALREADY_PHONENUM_EXISTS.getResponseVO("FAILURE");
		}

		Student dbEmail = studentRepository.findByEmail(studentVO.getEmail());
		if (dbEmail != null) {
			return HttpStatusCode.ALREADY_EMAIL_EXISTS.getResponseVO("FAILURE");
		}
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
		// user.setPassword(bCryptPasswordEncoder.encode(studentVO.getUser().getPassword()));
		user.setPassword(passwordEncoder.encode(studentVO.getUser().getPassword()));
		studentRepository.save(studentVO);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

	/*public VerificationToken getVerificationToken(final String VerificationToken) {
		return tokenRepository.findByToken(VerificationToken);
	}*/

	/*public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
		VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
		vToken.updateToken(UUID.randomUUID().toString());
		vToken = tokenRepository.save(vToken);
		return vToken;
	}*/

	public Student findStudentByEmail(String userEmail) {

		return studentRepository.findByEmail(userEmail);

	}

	
}