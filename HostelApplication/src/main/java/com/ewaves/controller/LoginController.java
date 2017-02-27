package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.LoginDetailsVO;
import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.StudentRequest;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public @ResponseBody ResponseVO userRequest(@RequestBody LoginDetailsVO requestVO) {
		System.out.println("In usercontroller : \n " + requestVO.toString());

		 ResponseVO responseVO = loginService.loginValidate(requestVO);

		return responseVO;

	}
}
