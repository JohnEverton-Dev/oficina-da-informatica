package com.alvestech.oficinadainformatica.funcionario.infra;

import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioSpringDataJPARepository extends JpaRepository<Funcionario, UUID> {

}
