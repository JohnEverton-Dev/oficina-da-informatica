package com.alvestech.oficinadainformatica.cliente.application.api;

import com.alvestech.oficinadainformatica.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}