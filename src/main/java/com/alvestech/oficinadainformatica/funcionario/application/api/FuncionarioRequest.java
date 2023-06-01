package com.alvestech.oficinadainformatica.funcionario.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class FuncionarioRequest {
    @NotBlank(message = "Campo Obrigatório!")
    String nomeCompleto;
    @CPF
    @NotBlank(message = "Campo Obrigatório!")
    String cpf;
    LocalDate dataNascimento;
    String celular;
    String email;
    String endereco;
    String numero;
    String bairro;
    String cidade;
}
