package com.alvestech.oficinadainformatica.ordemservico.application.service;

import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoRequest;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoResponse;

public interface OrdemServicoService {
    OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest);
}
