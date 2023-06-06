package com.alvestech.oficinadainformatica.servico.application.repository;

import com.alvestech.oficinadainformatica.servico.domain.Servico;

import java.util.List;
import java.util.UUID;

public interface ServicoRepository {
    Servico saveServico(Servico servico);
    Servico findServicoById(Long idServico);
    List<Servico> findAllServicos();
    void deleteServico(Long idServico);
}
