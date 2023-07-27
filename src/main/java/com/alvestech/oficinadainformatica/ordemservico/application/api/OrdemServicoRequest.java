package com.alvestech.oficinadainformatica.ordemservico.application.api;

import com.alvestech.oficinadainformatica.orcamento.domain.Status;
import lombok.Value;

import java.util.UUID;

@Value
public class OrdemServicoRequest {
    Long idOrcamento;
    Long idServico;
    UUID idFuncionario;
    Status status;
    String descricaoServico;
}