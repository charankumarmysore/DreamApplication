package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.repository.HostelRepossitory;
import com.ewaves.util.HttpStatusCode;

@Service
public class HostelService {
	@Autowired
	private HostelRepossitory hostelRepossitory;

	public ResponseVO save(HostelDetails hostelDeails) {

		HostelDetails details = hostelRepossitory.findByEmailId(hostelDeails.getEmailId());

		if (details == null) {
			return HttpStatusCode.ALREADY_EMAIL_EXISTS.getResponseVO("FAILURE");
		}
		hostelRepossitory.save(hostelDeails);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");
	}

}
