package com.alvestech.oficinadainformatica.servico.application.api;

import com.alvestech.oficinadainformatica.servico.domain.Servico;
import com.alvestech.oficinadainformatica.servico.domain.TipoServico;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class ServicoResponse {
    UUID idServico;
    TipoServico tipoServico;
    BigDecimal valorServico;

    public ServicoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.valorServico = servico.getValorServico();
        this.tipoServico = servico.getTipoServico();
    }
}