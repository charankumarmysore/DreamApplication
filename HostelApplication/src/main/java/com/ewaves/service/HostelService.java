package com.ewaves.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	/*public ResponseVO save(HostelDetails hostelDeails) {

		HostelDetails details = hostelRepossitory.findOneByEmail(hostelDeails.getEmailId());

		if (details == null) {
			return HttpStatusCode.ALREADY_EMAIL_EXISTS.getResponseVO("FAILURE");
		}
		hostelRepossitory.save(hostelDeails);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");
	}*/

}
