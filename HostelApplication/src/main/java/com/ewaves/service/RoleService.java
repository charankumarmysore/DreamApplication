package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.Role;
import com.ewaves.repository.RoleRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepositry;

	public ResponseVO addRole(Role roleDeails) {

		Role dbRole = roleRepositry.save(roleDeails);
		if (dbRole == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");
		}

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
