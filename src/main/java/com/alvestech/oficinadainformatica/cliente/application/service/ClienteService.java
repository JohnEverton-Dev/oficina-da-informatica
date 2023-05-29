package com.alvestech.oficinadainformatica.cliente.application.service;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteListResponse;
import com.alvestech.oficinadainformatica.cliente.application.api.ClienteRequest;
import com.alvestech.oficinadainformatica.cliente.application.api.ClienteResponse;
import com.alvestech.oficinadainformatica.cliente.application.api.EditaClienteRequest;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse saveCliente(ClienteRequest clienteRequest);
    ClienteResponse findFuncionarioById(UUID idCliente);
    List<ClienteListResponse> findAllFuncionario();
    void deleteFuncionario(UUID idCliente);
    void updateCliente(UUID idCliente, EditaClienteRequest editaClienteRequest);
}