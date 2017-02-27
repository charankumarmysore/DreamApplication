package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.repository.HostelRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class HostelService {

	@Autowired
	private HostelRepository hostelRepossitory;

	public ResponseVO hostelRequest(HostelDetails hostelDeails) {

		HostelDetails dbEmail = hostelRepossitory.findByEmail(hostelDeails.getEmailId());

		if (dbEmail != null) {
			return HttpStatusCode.ALREADY_EMAIL_EXISTS.getResponseVO("FAILURE");
		}
		HostelDetails dbphoneNumber = hostelRepossitory.findByPhone(hostelDeails.getPhoneNumber());
		if (dbphoneNumber != null) {
			return HttpStatusCode.ALREADY_PHONENUM_EXISTS.getResponseVO("FAILURE");
		}
		hostelRepossitory.save(hostelDeails);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
