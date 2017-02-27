package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ewaves.domain.LoginDetailsVO;
import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.repository.LoginRepository;
import com.ewaves.util.HttpStatusCode;

public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public ResponseVO loginValidate(LoginDetailsVO requestVO) {

		LoginDetails dbLoign = loginRepository.findUserName(requestVO.getUserName());
		if (dbLoign != null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");
		}

		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUsername(requestVO.getUserName());
		loginDetails.setPassword(requestVO.getPassword());

		loginRepository.save(loginDetails);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");
	}

}
