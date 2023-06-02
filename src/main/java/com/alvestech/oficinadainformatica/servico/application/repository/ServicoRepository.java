package com.alvestech.oficinadainformatica.servico.application.repository;

import com.alvestech.oficinadainformatica.servico.domain.Servico;

import java.util.UUID;

public interface ServicoRepository {
    Servico saveServico(Servico servico);
    Servico findServicoById(UUID idServico);
}
