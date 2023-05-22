package com.alvestech.oficinadainformatica.cliente.application.repository;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteListResponse;
import com.alvestech.oficinadainformatica.cliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente saveCliente(Cliente cliente);
    Cliente findClienteById(UUID idCliente);
    List<Cliente> findAllClientes();
    void deleteCliente(UUID idCliente);
}