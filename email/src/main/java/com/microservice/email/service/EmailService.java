package com.microservice.email.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.microservice.email.entity.EmailEntity;
import com.microservice.email.enums.EmailStatus;
import com.microservice.email.repository.EmailRepository;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    public EmailEntity sendEmail(EmailEntity emailEntity) {

        emailEntity.setDataDeEnvio(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailOrigen());
            message.setTo(emailEntity.getEmailDestino());
            message.setSubject(emailEntity.getAssunto());
            message.setText(emailEntity.getConteudo());
            mailSender.send(message);

            emailEntity.setEmailStatus(EmailStatus.SENT);
            return emailRepository.save(emailEntity); 

        }catch (MailException e){
            emailEntity.setEmailStatus(EmailStatus.ERROR);
            return emailRepository.save(emailEntity); 
        }         
        
    }
    
    
}
