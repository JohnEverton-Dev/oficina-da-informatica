package com.alvestech.oficinadainformatica.cliente.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class EditaClienteRequest {
   @NotNull(message = "Campo Obrigatório!")
   String nomeCompleto;
   String celular;
   String email;
   String endereco;
   String numero;
   String bairro;
}