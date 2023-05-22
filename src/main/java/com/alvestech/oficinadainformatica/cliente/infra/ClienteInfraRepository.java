package com.alvestech.oficinadainformatica.cliente.infra;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteListResponse;
import com.alvestech.oficinadainformatica.cliente.application.repository.ClienteRepository;
import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import com.alvestech.oficinadainformatica.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - saveCliente");
        try {
            Cliente clienteCriado = clienteSpringDataJPARepository.save(cliente);
            log.info("[finash] ClienteInfraRepository - saveCliente");
            return clienteCriado;
        }catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Cliente já cadastrado!");
        }
    }
    @Override
    public Cliente findClienteById(UUID idCliente) {
        log.info("[start] ClienteInfraRepository - findClienteById");
        Optional<Cliente> optionalCliente = clienteSpringDataJPARepository.findById(idCliente);
        Cliente cliente = optionalCliente.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Cliente não encontrado!"));
        log.info("[finish] ClienteInfraRepository - findClienteById");
        return cliente;
    }
    @Override
    public List<Cliente> findAllClientes() {
        log.info("[start] ClienteInfraRepository - findAllClientes");
        List<Cliente> allClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finish] ClienteInfraRepository - findAllClientes");
        return allClientes;
    }
    @Override
    public void deleteCliente(UUID idCliente) {
        log.info("[start] ClienteInfraRepository - deleteCliente");
        clienteSpringDataJPARepository.deleteById(idCliente);
        log.info("[finish] ClienteInfraRepository - deleteCliente");
    }
}