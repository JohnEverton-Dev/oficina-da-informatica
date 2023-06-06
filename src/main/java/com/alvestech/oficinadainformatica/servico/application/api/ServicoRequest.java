package com.alvestech.oficinadainformatica.servico.application.api;

import com.alvestech.oficinadainformatica.servico.domain.TipoServico;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ServicoRequest {
    TipoServico tipoServico;
    BigDecimal valorServico;
}