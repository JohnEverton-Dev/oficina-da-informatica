package com.alvestech.oficinadainformatica.ordemservico.application.repository;

import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;

import java.util.List;

public interface OrdemServicoRepository {
    OrdemServico saveOrdemServico(OrdemServico ordemServico);
    OrdemServico findOrdemServicoById(Long idOrdemServico);
    List<OrdemServico> findAllOrdemServico();
}