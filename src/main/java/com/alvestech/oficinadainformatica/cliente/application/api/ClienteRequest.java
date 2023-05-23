package com.alvestech.oficinadainformatica.cliente.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class ClienteRequest {
    @NotNull(message = "Campo Obrigatório!")
    String nomeCompleto;
    @CPF
    @NotNull(message = "Campo Obrigatório!")
    String cpf;
    LocalDate dataNascimento;
    String celular;
    String email;
    String endereco;
    String numero;
    String bairro;

}