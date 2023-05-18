package com.alvestech.oficinadainformatica.cliente.application.api;

import jakarta.validation.constraints.Email;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class ClienteRequest {
    String nomeCompleto;
    String cpf;
    LocalDate dataNascimento;
    String celular;
    String email;
    String endereco;
    String numero;
    String bairro;

}