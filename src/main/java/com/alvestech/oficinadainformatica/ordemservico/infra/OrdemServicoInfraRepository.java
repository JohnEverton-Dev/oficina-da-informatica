package com.alvestech.oficinadainformatica.ordemservico.infra;

import com.alvestech.oficinadainformatica.ordemservico.application.repository.OrdemServicoRepository;
import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class OrdemServicoInfraRepository implements OrdemServicoRepository {
    private final OrdemServicoSpringDataJPARepository ordemServicoSpringDataJPARepository;

    @Override
    public OrdemServico saveOrdemServico(OrdemServico ordemServico) {
        log.info("[start] OrdemServicoInfraRepository - saveOrdemServico");
        OrdemServico ordemServicoCriado = ordemServicoSpringDataJPARepository.save(ordemServico);
        log.info("[finish] OrdemServicoInfraRepository - saveOrdemServico");
        return ordemServicoCriado;
    }
}
