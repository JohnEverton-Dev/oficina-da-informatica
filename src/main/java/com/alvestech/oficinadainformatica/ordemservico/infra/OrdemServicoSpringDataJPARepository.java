package com.alvestech.oficinadainformatica.ordemservico.infra;

import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoSpringDataJPARepository extends JpaRepository<OrdemServico, Long> {
}
