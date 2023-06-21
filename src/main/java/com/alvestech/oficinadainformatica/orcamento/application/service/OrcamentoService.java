package com.alvestech.oficinadainformatica.orcamento.application.service;

import com.alvestech.oficinadainformatica.orcamento.application.api.OrcamentoRequest;
import com.alvestech.oficinadainformatica.orcamento.application.api.OrcamentoResponse;

public interface OrcamentoService {
    OrcamentoResponse saveOrcamento(OrcamentoRequest orcamentoRequest);
    OrcamentoResponse findOrcamentoById(Long idOrcamento);
}