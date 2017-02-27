package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.UserRequest;
import com.ewaves.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userregistration", method = RequestMethod.POST)
	public @ResponseBody ResponseVO userRegistration(@RequestBody LoginDetails userVO) {
		System.out.println("In usercontroller : \n " + userVO.toString());

		ResponseVO s = userService.saveUserRegistration(userVO);

		return s;

	}

	@RequestMapping(value = "/userRequest", method = RequestMethod.POST)
	public @ResponseBody ResponseVO userRequest(@RequestBody UserRequest userRequest) {
		System.out.println("In usercontroller : \n " + userRequest.toString());

		ResponseVO s = userService.save(userRequest);

		return s;

	}
}
