package com.alvestech.oficinadainformatica.ordemservico.application.api;

import com.alvestech.oficinadainformatica.orcamento.domain.Status;
import lombok.Data;

@Data
public class OSUpdateRequest {
    Status status;
    String descricaoServico;
}
