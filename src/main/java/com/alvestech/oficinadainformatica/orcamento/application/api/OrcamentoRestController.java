package com.alvestech.oficinadainformatica.orcamento.application.api;

import com.alvestech.oficinadainformatica.orcamento.application.service.OrcamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class OrcamentoRestController implements OrcamentoAPI {
    private final OrcamentoService orcamentoService;

    @Override
    public OrcamentoResponse saveOrcamento(OrcamentoRequest orcamentoRequest) {
        log.info("[start] OrcamentoRestController - saveOrcamento");
        OrcamentoResponse orcamentoResponse = orcamentoService.saveOrcamento(orcamentoRequest);
        log.info("[finish] OrcamentoRestController - saveOrcamento");
        return orcamentoResponse;
    }
    @Override
    public OrcamentoResponse findOrcamentoById(Long idOrcamento) {
        log.info("[start] OrcamentoRestController - findOrcamentoById");
        OrcamentoResponse orcamentoResponse = orcamentoService.findOrcamentoById(idOrcamento);
        log.info("[finish] OrcamentoRestController - findOrcamentoById");
        return orcamentoResponse;
    }
}