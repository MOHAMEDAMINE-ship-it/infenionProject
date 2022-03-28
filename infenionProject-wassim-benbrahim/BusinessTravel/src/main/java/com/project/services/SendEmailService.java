package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService  implements ISendEmailService{

	
		@Autowired
	    private JavaMailSender mailSender;
	    public void sendSimpleEmail( String toEmail,
	                                String body,
	                                String subject) {
	        System.out.println("sending Email");
	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setFrom("amine.benothmane1@gmail.com");
	        message.setTo(toEmail);
	        message.setText(body);
	        message.setSubject(subject);

	        mailSender.send(message);
	        System.out.println("Mail Send...");
	    }
		
	}


