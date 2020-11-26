package com.ies.kentucky.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String to, String subject, String body) {
		
		boolean isSent=false;
		
		try {
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper= new MimeMessageHelper(mimeMessage);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			helper.setText(body, true);
			mailSender.send(mimeMessage);
			isSent=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return isSent;
	}
}
