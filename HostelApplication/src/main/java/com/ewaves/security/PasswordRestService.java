package com.ewaves.security;

import java.util.Arrays;
import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.PasswordResetToken;
import com.ewaves.entities.Student;
import com.ewaves.repository.LoginRepository;
import com.ewaves.repository.PasswordTokenRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class PasswordRestService {
	@Inject
	PasswordTokenRepository passwordTokenRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private LoginRepository loginRepository;

	public ResponseVO validatePasswordResetToken(Long id, String token) {
		System.out.println("in PasswordRestService class");

		PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
		System.out.println("password is : " + passToken.toString());

		if ((passToken == null) || (passToken.getUser().getId() != id)) {
			System.out.println("in if block");
			return HttpStatusCode.TOKEN_INVALID.getResponseVO("FAILURE");
		}

		final Calendar cal = Calendar.getInstance();
		if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			return HttpStatusCode.TOKEN_EXPIRED.getResponseVO("FAILURE");
		}

		final Student user = passToken.getUser();
		final Authentication auth = new UsernamePasswordAuthenticationToken(user, null,
				Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
		SecurityContextHolder.getContext().setAuthentication(auth);
		// ResponseVO responseVO =
		// HttpStatusCode.FOUND.getResponseVO("SUCCESS");
		return null;
	}

	public void changeUserPassword(final LoginDetails user, final String password) {
		System.out.println("lkklklklk");
		user.setPassword(passwordEncoder.encode(password));

	}

	public void changeUserPassword(Student loginDetils, String newPassword) {
		System.out.println("In  changeUserPassword " + loginDetils.getFirstName());

		LoginDetails cc = loginDetils.getUser();

		cc.setPassword(newPassword);
		System.out.println(newPassword);

		loginRepository.save(cc);

	}

}