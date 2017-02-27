package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.StudentRequest;
import com.ewaves.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userRequest", method = RequestMethod.POST)
	public @ResponseBody ResponseVO userRequest(@RequestBody StudentRequest userRequest) {
		System.out.println("In usercontroller : \n " + userRequest.toString());

		ResponseVO responseVO = userService.addUserRequest(userRequest);

		return responseVO;

	}
}
