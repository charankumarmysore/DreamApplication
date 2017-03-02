package com.ewaves.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.Student;
import com.ewaves.repository.PasswordTokenRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class EmailService {

	@Autowired
	PasswordTokenRepository passwordTokenRepository;
	@Autowired
	private StudentService studentService;

	@Autowired
	private PasswordTokenService PasswordTokenService;

	private static Properties props = null;
	{
		InputStream is = null;
		try {
			props = new Properties();
			is = this.getClass().getResourceAsStream("/emailserver.properties");
			if (is == null) {
				System.err.println("Error reading server configuration of the right files");
			}
			props.load(is);
			if (props == null) {
				System.err.println("error reading server configuration");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private Session getEmailSession() {
		return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("mail.username"),
						props.getProperty("mail.password"));
			}
		});
	}

	public ResponseVO forgotPasswordMail(String email, HttpServletRequest request) {

		try {
			Student student = studentService.findStudentByEmail(email);
			if (student == null) {
				// log.info("Invalid User Id" + user.getUserId());

				// return "redirect:/login.html?lang=" +
				// request.getLocale().getLanguage();
				return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");
			}

			String token = UUID.randomUUID().toString();
			PasswordTokenService.createPasswordResetTokenForUser(student, token);
			final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			MimeMessage message = constructResetTokenEmail(appUrl, request.getLocale(), token, student);
			Transport.send(message);

		} catch (final MessagingException mex) {
			System.err.println("exception occurred in sendemail" + mex.getMessage());

			// return "redirect:/emailError.html?lang=" +
			// request.getLocale().getLanguage();
		} catch (final Exception e) {

			// return "redirect:/login.html?lang=" +
			// request.getLocale().getLanguage();
		}
		// return "redirect:/login.html?lang=" +
		// request.getLocale().getLanguage();
		return HttpStatusCode.FOUND.getResponseVO("SUCCESS");
	}

	private final MimeMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final Student user) {
	
		Session session = getEmailSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

			final String url = contextPath + "/changepassword?id=" + user.getId() + "&token=" + token;
			message.setSubject("Welcome to Cin-Cin Admin Panel", "UTF-8");
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			String emailContentType = "text/html" + "; charset=UTF-8";
			String content = "Please click below link for rest password" + " \r\n" + url;
			message.setContent(content, emailContentType);
		} catch (AddressException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());

		} catch (MessagingException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());
		}
		return message;
	}

}
