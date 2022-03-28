package com.project.batch.processor;

import com.project.email.EmailServiceImpl;
import com.project.entities.Invitation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.SendFailedException;

@Slf4j
public class InvitationItemProcessor implements ItemProcessor<Invitation, Invitation> {
	
    @Autowired
    EmailServiceImpl emailService;
    
    

    @Override
    public Invitation process(Invitation invitation) throws Exception {
        log.debug(String.valueOf(invitation.getEmailEmpl()));

        try {
        	 String title="Invitaion of business travel";
        	 String description="Thank you for registering with us \n merci..";
        	 
            emailService.sendSimpleMessage(invitation.getEmailEmpl(), title, description);
            invitation.setEmailSent(true);
        } catch (SendFailedException sendFailedException) {
            log.debug("error: {}", sendFailedException.getMessage());
        }
        return invitation;
    }
}