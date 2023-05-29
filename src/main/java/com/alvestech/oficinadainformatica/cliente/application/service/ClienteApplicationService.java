package com.alvestech.oficinadainformatica.cliente.application.service;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteListResponse;
import com.alvestech.oficinadainformatica.cliente.application.api.ClienteRequest;
import com.alvestech.oficinadainformatica.cliente.application.api.ClienteResponse;
import com.alvestech.oficinadainformatica.cliente.application.api.EditaClienteRequest;
import com.alvestech.oficinadainformatica.cliente.application.repository.ClienteRepository;
import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - saveCliente");
        Cliente cliente = clienteRepository.saveCliente(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - saveCliente");
        return new ClienteResponse(cliente);
    }
    @Override
    public ClienteResponse findFuncionarioById(UUID idCliente) {
        log.info("[start] ClienteApplicationService - findClienteById");
        Cliente cliente = clienteRepository.findClienteById(idCliente);
        log.info("[finish] ClienteApplicationService - findClienteById");
        return new ClienteResponse(cliente);
    }
    @Override
    public List<ClienteListResponse> findAllFuncionario() {
        log.info("[start] ClienteApplicationService - findAllClientes");
        List<Cliente> clienteList = clienteRepository.findAllClientes();
        log.info("[finash] ClienteApplicationService - findAllClientes");
        return ClienteListResponse.converte(clienteList);
    }
    @Override
    public void deleteFuncionario(UUID idCliente) {
        log.info("[start] ClienteApplicationService - deleteCliente");
        Cliente cliente = clienteRepository.findClienteById(idCliente);
        clienteRepository.deleteCliente(cliente.getIdCliente());
        log.info("[finish] ClienteApplicationService - deleteCliente");
    }
    @Override
    public void updateCliente(UUID idCliente, EditaClienteRequest editaClienteRequest) {
        log.info("[start] ClienteApplicationService - updateCliente");
        Cliente cliente = clienteRepository.findClienteById(idCliente);
        cliente.update(editaClienteRequest);
        clienteRepository.saveCliente(cliente);
        log.info("[finish] ClienteApplicationService - updateCliente");
    }
}