package com.ewaves.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.UserRequest;
import com.ewaves.repository.UserRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	String message;

	public ResponseVO save(UserRequest userRequest) {
		userRequest.setInsertedOn(LocalDateTime.now());
		UserRequest s = userRepository.save(userRequest);

		if (s == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");

		}
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
