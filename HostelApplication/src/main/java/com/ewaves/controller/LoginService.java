package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.repository.LoginRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public ResponseVO loginValidate(LoginDetails requestVO) {

		LoginDetails dbUser = loginRepository.findByUsernameAndPassword(requestVO.getUsername(),
				requestVO.getPassword());

		if (dbUser == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");
		}

		System.out.println(dbUser.toString());
		ResponseVO responseVO = HttpStatusCode.FOUND.getResponseVO("SUCCESS");
		responseVO.setResponseObjects(dbUser);
		return responseVO;
	}

}
