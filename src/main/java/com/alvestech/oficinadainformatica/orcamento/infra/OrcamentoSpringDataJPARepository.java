package com.alvestech.oficinadainformatica.orcamento.infra;

import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoSpringDataJPARepository extends JpaRepository<Orcamento, Long> {
}
