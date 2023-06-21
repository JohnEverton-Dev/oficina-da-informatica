package com.alvestech.oficinadainformatica.orcamento.application.repository;

import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;

public interface OrcamentoRepository {
    Orcamento saveOrcamento(Orcamento orcamento);
    Orcamento findOrcamentoById(Long idOrcamento);
}