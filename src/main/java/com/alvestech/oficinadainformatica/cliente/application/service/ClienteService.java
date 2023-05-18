package com.alvestech.oficinadainformatica.cliente.application.service;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteRequest;
import com.alvestech.oficinadainformatica.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse saveCliente(ClienteRequest clienteRequest);
}