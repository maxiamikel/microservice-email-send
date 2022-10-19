package com.microservice.email.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.microservice.email.enums.EmailStatus;

import lombok.Data;

@Entity
@Data
@Table(name="emails")
public class EmailEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailOrigen;
    private String emailDestino;
    private String refDono;
    private String assunto;
    @Column(columnDefinition = "TEXT")
    private String conteudo;
    private LocalDateTime dataDeEnvio;
    private EmailStatus emailStatus;
}
