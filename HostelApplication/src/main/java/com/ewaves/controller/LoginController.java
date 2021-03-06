package com.ewaves.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.ewaves.domain.PasswordDto;
import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.Student;
import com.ewaves.security.PasswordRestService;
import com.ewaves.service.EmailService;
import com.ewaves.service.LoginService;

@RestController
// @RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private EmailService emailSerive;
	@Autowired
	private PasswordRestService passwordRestService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseVO userRequest(@RequestBody LoginDetails requestVO) {
		System.out.println("In usercontroller : \n " + requestVO.toString());

		ResponseVO responseVO = loginService.loginValidate(requestVO);

		return responseVO;

	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody ResponseVO forgotPassword(final HttpServletRequest request,
			@RequestParam("email") final String email) {

		ResponseVO responseVO = emailSerive.forgotPasswordMail(email, request);

		return responseVO;

	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public RedirectView showChangePasswordPage(final Locale locale, final HttpServletRequest request,
			@RequestParam("id") final long id, @RequestParam("token") final String token) {
		System.out.println("In showChangePasswordPage -------->\n" + token);
		final ResponseVO result = passwordRestService.validatePasswordResetToken(id, token);
		RedirectView redirectView = new RedirectView();

		if (result != null) {

			redirectView.setUrl("/login?lang=" + locale.getLanguage());

		}
		final String redirectUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
				+ "/views/updatePassword.html?lang=" + locale.getLanguage();

		redirectView.setUrl(redirectUrl);
		return redirectView;
	}

	@RequestMapping(value = "/savePassword", method = RequestMethod.POST)
	public @ResponseBody ResponseVO savePassword(@RequestBody PasswordDto passwordDto) {
		System.out.println("123");
		final Student loginDetils = (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("jkjkjkjkj" + passwordDto.getNewPassword());
		passwordRestService.changeUserPassword(loginDetils, passwordDto.getNewPassword());
		// return new
		// GenericResponse(messages.getMessage("message.resetPasswordSuc", null,
		// locale));
		return null;
	}

}
