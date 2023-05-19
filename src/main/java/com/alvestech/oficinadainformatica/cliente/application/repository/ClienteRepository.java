package com.alvestech.oficinadainformatica.cliente.application.repository;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteRepository {
    Cliente saveCliente(Cliente cliente);
    Cliente findClienteById(UUID idCliente);
}