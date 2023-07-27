package com.alvestech.oficinadainformatica.ordemservico.application.api;

import com.alvestech.oficinadainformatica.ordemservico.application.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class OrdemServicoRestController implements OrdemServicoAPI {
    private final OrdemServicoService ordemServicoService;

    @Override
    public OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest) {
        log.info("[start] OrdemServicoRestController - saveOrdemServico");
        OrdemServicoResponse ordemServicoResponse = ordemServicoService.saveOrdemServico(ordemServicoRequest);
        log.info("[finish] OrdemServicoRestController - saveOrdemServico");
        return ordemServicoResponse;
    }
    @Override
    public OrdemServicoResponse findOrdemServicoById(Long idOrdemServico) {
        log.info("[start] OrdemServicoRestController - findOrdemServicoById");
        OrdemServicoResponse ordemServicoResponse = ordemServicoService.findOrdemServico(idOrdemServico);
        log.info("[finish] OrdemServicoRestController - findOrdemServicoById");
        return ordemServicoResponse;
    }
    @Override
    public List<OrdemServicoResponse> findAllOrdemServico() {
        log.info("[start] OrdemServicoRestController - findAllOrdemServico");
        List<OrdemServicoResponse> listOrdemServico = ordemServicoService.findAllOrdemServico();
        log.info("[finish] OrdemServicoRestController - findAllOrdemServico");
        return listOrdemServico;
    }
    @Override
    public void updateOrdemServico(Long idOrdemServico, OSUpdateRequest osUpdateRequest) {
        log.info("[start] OrdemServicoRestController - updateOrdemServico");
        ordemServicoService.updateOrdemServico(idOrdemServico, osUpdateRequest);
        log.info("[idOrdemServico] {}", idOrdemServico);
        log.info("[finish] OrdemServicoRestController - updateOrdemServico");
    }
}