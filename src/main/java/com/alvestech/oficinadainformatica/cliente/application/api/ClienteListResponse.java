package com.alvestech.oficinadainformatica.cliente.application.api;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {
    UUID idCliente;
    String nomeCompleto;
    String cpf;

    public static List<ClienteListResponse> converte(List<Cliente>clienteList) {
        return clienteList.stream()
                .map(ClienteListResponse::new)
                .collect((Collectors.toList()));
    }
    public ClienteListResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
    }
}