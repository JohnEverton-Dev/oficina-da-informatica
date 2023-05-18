package com.alvestech.oficinadainformatica.cliente.application.repository;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;

public interface ClienteRepository {
    Cliente saveCliente(Cliente cliente);
}