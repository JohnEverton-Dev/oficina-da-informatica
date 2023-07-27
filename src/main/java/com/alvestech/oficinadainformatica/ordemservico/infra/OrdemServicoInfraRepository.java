package com.alvestech.oficinadainformatica.ordemservico.infra;

import com.alvestech.oficinadainformatica.handler.APIException;
import com.alvestech.oficinadainformatica.ordemservico.application.repository.OrdemServicoRepository;
import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    @Override
    public OrdemServico findOrdemServicoById(Long idOrdemServico) {
        log.info("[start] OrdemServicoInfraRepository - findOrdemServicoById");
        Optional<OrdemServico> optionalOrdemServico = ordemServicoSpringDataJPARepository.findById(idOrdemServico);
        OrdemServico ordemServico = optionalOrdemServico.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Ordem de Serviço não encotrada!"));
        log.info("[finish] OrdemServicoInfraRepository - findOrdemServicoById");
        return ordemServico;
    }
    @Override
    public List<OrdemServico> findAllOrdemServico() {
        log.info("[start] OrdemServicoInfraRepository - findAllOrdemServico");
        List<OrdemServico> allOrdemServicos = ordemServicoSpringDataJPARepository.findAll();
        log.info("[finish] OrdemServicoInfraRepository - findAllOrdemServico");
        return allOrdemServicos;
    }
}