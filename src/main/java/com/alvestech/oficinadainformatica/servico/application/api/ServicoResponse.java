package com.alvestech.oficinadainformatica.servico.application.api;

import com.alvestech.oficinadainformatica.servico.domain.Servico;
import com.alvestech.oficinadainformatica.servico.domain.TipoServico;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ServicoResponse {
    Long idServico;
    TipoServico tipoServico;
    BigDecimal valorServico;

    public ServicoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.valorServico = servico.getValorServico();
        this.tipoServico = servico.getTipoServico();
    }

    public static List<ServicoResponse> converte(List<Servico> listServicos) {
        return listServicos.stream()
                .map(ServicoResponse::new)
                .collect(Collectors.toList());
    }
}