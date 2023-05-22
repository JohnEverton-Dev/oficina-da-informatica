package com.alvestech.oficinadainformatica.cliente.application.api;

import com.alvestech.oficinadainformatica.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteRestController - saveCliente");
        ClienteResponse clienteResponse = clienteService.saveCliente(clienteRequest);
        log.info("[finish] ClienteRestController - saveCliente");
        return clienteResponse;
    }
    @Override
    public ClienteResponse findClienteById(UUID idCliente) {
        log.info("[start] ClienteRestController - findClienteById");
        ClienteResponse findCliente = clienteService.findClienteById(idCliente);
        log.info("[finish] ClienteRestController - findClienteById");
        return findCliente;
    }
    @Override
    public List<ClienteListResponse> findAllClientes() {
        log.info("[start] ClienteRestController - findAllClientes");
        List<ClienteListResponse> clienteList = clienteService.findAllClientes();
        log.info("[finish] ClienteRestController - findAllClientes");
        return clienteList;
    }

}