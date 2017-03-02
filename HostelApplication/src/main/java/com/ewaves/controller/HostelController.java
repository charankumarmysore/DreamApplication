package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.HostelCityStateVO;
import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.service.HostelService;

@RestController
@RequestMapping(value = "/hostel")
public class HostelController {

	@Autowired
	private HostelService hostelService;

	@RequestMapping(value = "/hostelrequest", method = RequestMethod.POST)
	public @ResponseBody ResponseVO hostelRequest(@RequestBody HostelDetails hostelDeails) {
		System.out.println("In usercontroller : \n " + hostelDeails.toString());
		ResponseVO responseVO = hostelService.hostelRequest(hostelDeails);
		return responseVO;

	}

	@RequestMapping(value = "/getAllHostels", method = RequestMethod.GET)
	public @ResponseBody ResponseVO getAllHostels() {
		ResponseVO responseVO = hostelService.getAllHostels();
		return responseVO;

	}

	@RequestMapping(value = "/getAllCityAndState", method = RequestMethod.POST)
	public @ResponseBody ResponseVO getHostelDetalsByStateAndCity(@RequestBody HostelCityStateVO requestVO) {
		ResponseVO responseVO = hostelService.getAllHostels1(requestVO.getCity(), requestVO.getState());
		return responseVO;

	}

}
