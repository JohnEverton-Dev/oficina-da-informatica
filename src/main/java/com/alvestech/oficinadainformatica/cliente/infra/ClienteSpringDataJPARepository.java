package com.alvestech.oficinadainformatica.cliente.infra;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>{
    Optional<Cliente> findByCpf(String cpf);
}