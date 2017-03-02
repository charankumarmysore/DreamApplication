package com.ewaves.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.Student;
import com.ewaves.service.StudentService;

@RestController

public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/studentregistration/", method = RequestMethod.POST)
	public ResponseVO studentRegistration(@RequestBody Student employee, HttpServletRequest request) {
		final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		System.out.println(appUrl.toString());
		ResponseVO responseVO = studentService.studentRegistration(employee);
		return responseVO;
	}

}
