package com.microservice.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.email.entity.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long>{
    
}
