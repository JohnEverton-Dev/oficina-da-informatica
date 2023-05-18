package com.alvestech.oficinadainformatica.cliente.application.api;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
public class ClienteResponse {
    UUID idCliente;
    String nomeCompleto;
    String cpf;
    String celular;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
        this.celular = cliente.getCelular();
    }
}