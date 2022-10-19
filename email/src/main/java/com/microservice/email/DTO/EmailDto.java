package com.microservice.email.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    @Email
    private String emailOrigen;

    @NotBlank
    @Email
    private String emailDestino;

    @NotBlank
    private String refDono;

    @NotBlank
    private String assunto;
    
    @NotBlank
    private String conteudo;
    
}
