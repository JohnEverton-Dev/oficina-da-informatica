package com.alvestech.oficinadainformatica.servico.application.service;

import com.alvestech.oficinadainformatica.servico.application.api.ServicoRequest;
import com.alvestech.oficinadainformatica.servico.application.api.ServicoResponse;
import com.alvestech.oficinadainformatica.servico.domain.Servico;

import java.util.List;

public interface ServicoService {
    ServicoResponse saveServico(ServicoRequest servicoRequest);
    Servico findServicoById(Long idServico);
    List<ServicoResponse> findAllServicos();
    void deleteServico(Long idServico);
    void updateServico(Long idServico, ServicoRequest servicoRequest);
}
