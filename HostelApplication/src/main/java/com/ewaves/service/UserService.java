package com.ewaves.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.StudentRequest;
import com.ewaves.repository.UserRequestRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class UserService {

	@Autowired
	private UserRequestRepository userRequestRepository;

	public ResponseVO addUserRequest(StudentRequest userRequest) {
		userRequest.setInsertedOn(LocalDateTime.now());
		StudentRequest dbUserRequest = userRequestRepository.save(userRequest);

		if (dbUserRequest == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");

		}
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
