package com.alvestech.oficinadainformatica.ordemservico.application.service;

import com.alvestech.oficinadainformatica.ordemservico.application.api.OSUpdateRequest;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoRequest;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoResponse;

import java.util.List;

public interface OrdemServicoService {
    OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest);
    OrdemServicoResponse findOrdemServico(Long idOrdemServico);
    void updateOrdemServico(Long idOrdemServico, OSUpdateRequest osUpdateRequest);
    List<OrdemServicoResponse> findAllOrdemServico();
}