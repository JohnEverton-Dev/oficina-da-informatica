package com.alvestech.oficinadainformatica.orcamento.application.api;

import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;
import com.alvestech.oficinadainformatica.orcamento.domain.Status;
import com.alvestech.oficinadainformatica.servico.domain.TipoPagamento;
import com.alvestech.oficinadainformatica.servico.domain.TipoServico;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class OrcamentoResponse {
    Long idOrcamento;
    UUID idCliente;
    String cpf;
    String nomeCompleto;
    String celular;
    LocalDate dataOrcamento;
    TipoServico tipoServico;
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    BigDecimal valorFinal;
    Status status;

    public OrcamentoResponse(Orcamento orcamento) {
        this.idOrcamento = orcamento.getIdOrcamento();
        this.idCliente = orcamento.getCliente().getIdCliente();
        this.cpf = orcamento.getCliente().getCpf();
        this.nomeCompleto = orcamento.getCliente().getNomeCompleto();
        this.celular = orcamento.getCliente().getCelular();
        this.dataOrcamento = orcamento.getDataOrcamento();
        this.tipoServico = orcamento.getServico().getTipoServico();
        this.tipoPagamento = orcamento.getServico().getTipoPagamento();
        this.valorEntrada = orcamento.getValorEntrada();
        this.desconto = orcamento.getDesconto();
        this.quantidadeParcelas = orcamento.getQuantidadeParcelas();
        this.observacao = orcamento.getObservacao();
        this.valorFinal = orcamento.getValorFinal();
        this.status = orcamento.getStatus();
    }
}