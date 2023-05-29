package com.alvestech.oficinadainformatica.funcionario.application.api;

import com.alvestech.oficinadainformatica.funcionario.domain.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class FuncionarioRequest {
    String nomeCompleto;
    String cpf;
    LocalDate dataNascimento;
    String celular;
    String email;
    String endereco;
    String numero;
    String bairro;
    String cidade;
}
