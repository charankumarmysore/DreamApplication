package com.ewaves.service;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.UserRequest;
import com.ewaves.repository.UserRepository;
import com.ewaves.repository.UserRequestRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRequestRepository userRequestRepository;

	public ResponseVO saveUserRegistration(LoginDetails userVO) {

		/*
		 * User dbUserName =
		 * userRepository.findByUsername(userVO.getUserName()); if (dbUserName
		 * == null) { return
		 * HttpStatusCode.ALREADY_USERNAME_EXISTS.getResponseVO("FAILURE"); }
		 */
		// userVO.setInsertedOn(new Date());
		userRepository.save(userVO);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

	public ResponseVO save(UserRequest userRequest) {
		userRequest.setInsertedOn(LocalDateTime.now());
		UserRequest dbUserRequest = userRequestRepository.save(userRequest);

		if (dbUserRequest == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");

		}
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
