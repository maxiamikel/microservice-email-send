

package com.microservice.email.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.email.DTO.EmailDto;
import com.microservice.email.entity.EmailEntity;
import com.microservice.email.service.EmailService;

@RestController
public class EmailController {

     @Autowired
     EmailService emailService;

     @PostMapping("/enviar")
     public ResponseEntity<EmailEntity> enviarEmail(@RequestBody @Valid EmailDto emailDto){
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDto, emailEntity);
        emailService.sendEmail(emailEntity);
        return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
     }
}
