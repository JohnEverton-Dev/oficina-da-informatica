package com.alvestech.oficinadainformatica.ordemservico.application.api;

import com.alvestech.oficinadainformatica.orcamento.domain.Status;
import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;
import com.alvestech.oficinadainformatica.servico.domain.TipoServico;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class OrdemServicoResponse {
    Long idOrdemServico;
    String funcionario;
    TipoServico tipoServico;
    String Observacao;
    Status status;
    String descricaoServico;
    BigDecimal valorFinal;

    public OrdemServicoResponse(OrdemServico ordemServico) {
        this.idOrdemServico = ordemServico.getIdOrdemServico();
        this.funcionario = ordemServico.getFuncionario().getNomeCompleto();
        this.tipoServico = ordemServico.getServico().getTipoServico();
        this.Observacao = ordemServico.getObservacao();
        this.status = ordemServico.getStatus();
        this.descricaoServico = ordemServico.getDescricaoServico();
        this.valorFinal = ordemServico.getValorFinal();
    }
}