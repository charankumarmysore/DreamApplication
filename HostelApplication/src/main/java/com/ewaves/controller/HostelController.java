package com.ewaves.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.util.HttpStatusCode;

@RestController
@RequestMapping(value = "/hostel")
public class HostelController {

	@RequestMapping(value = "/addHostel", method = RequestMethod.POST)
	public @ResponseBody ResponseVO addHostel(@RequestBody HostelDetails hostelDeails) {
		System.out.println("In usercontroller : \n " + hostelDeails.toString());

		// ResponseVO s = userService.save(userRequest);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
