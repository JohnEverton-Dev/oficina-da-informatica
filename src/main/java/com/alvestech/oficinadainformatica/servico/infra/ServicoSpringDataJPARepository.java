package com.alvestech.oficinadainformatica.servico.infra;

import com.alvestech.oficinadainformatica.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoSpringDataJPARepository extends JpaRepository<Servico, Long> {
}