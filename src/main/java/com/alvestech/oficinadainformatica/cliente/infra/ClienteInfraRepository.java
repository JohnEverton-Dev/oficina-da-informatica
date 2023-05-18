package com.alvestech.oficinadainformatica.cliente.infra;

import com.alvestech.oficinadainformatica.cliente.application.repository.ClienteRepository;
import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import com.alvestech.oficinadainformatica.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

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
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "Cliente já cadastrado! CPF: " + cliente.getCpf());
        }
    }
}