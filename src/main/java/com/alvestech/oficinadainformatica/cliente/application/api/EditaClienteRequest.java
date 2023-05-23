package com.alvestech.oficinadainformatica.cliente.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EditaClienteRequest {
    @NotNull(message = "Campo Obrigatório!")
   private String nomeCompleto;
   private LocalDate dataNascimento;
   private String celular;
   private String email;
   private String endereco;
   private String numero;
   private String bairro;
}
