package com.alvestech.oficinadainformatica.servico.application.service;

import com.alvestech.oficinadainformatica.servico.application.api.ServicoRequest;
import com.alvestech.oficinadainformatica.servico.application.api.ServicoResponse;
import com.alvestech.oficinadainformatica.servico.domain.Servico;

import java.util.UUID;

public interface ServicoService {
    ServicoResponse saveServico(ServicoRequest servicoRequest);
    Servico findServicoById(UUID idServico);
}
