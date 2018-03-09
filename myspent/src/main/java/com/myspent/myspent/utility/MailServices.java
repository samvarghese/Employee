package com.myspent.myspent.utility;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServices {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("sam.v@saasvaap.in");
		message.setSubject("subject");
		message.setText("text");

	}

}
