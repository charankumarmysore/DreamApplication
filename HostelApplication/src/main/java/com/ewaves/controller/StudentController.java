package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.entities.Student;
import com.ewaves.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void add(@RequestBody Student employee) {
		studentService.add(employee);
	}

}
