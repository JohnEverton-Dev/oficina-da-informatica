package com.alvestech.oficinadainformatica.ordemservico.application.api;

import com.alvestech.oficinadainformatica.ordemservico.application.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
