package com.alvestech.oficinadainformatica.orcamento.domain;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import com.alvestech.oficinadainformatica.orcamento.application.api.OrcamentoRequest;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrcamento;
    protected LocalDate dataOrcamento = LocalDate.now();
    private String observacao;
    private BigDecimal valorFinal;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JsonIgnore
    private Cliente cliente;

    @OneToOne
    @JsonIgnore
    private Servico servico;

    public Orcamento(Cliente cliente, Servico servico, OrcamentoRequest orcamentoRequest) {
        this.observacao = orcamentoRequest.getObservacao();
        this.valorFinal = orcamentoRequest.getValorFinal();
        this.status =  orcamentoRequest.getStatus();
        this.cliente = cliente;
        this.servico = servico;
    }
}