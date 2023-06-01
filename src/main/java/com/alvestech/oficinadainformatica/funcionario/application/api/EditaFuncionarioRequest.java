package com.alvestech.oficinadainformatica.funcionario.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EditaFuncionarioRequest {
    @NotBlank(message = "Campo Obrigatório!")
    String nomeCompleto;
    String celular;
    String email;
    String endereco;
    String numero;
    String bairro;
    String cidade;
}