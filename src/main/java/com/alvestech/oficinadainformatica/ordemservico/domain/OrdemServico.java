package com.alvestech.oficinadainformatica.ordemservico.domain;

import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;
import com.alvestech.oficinadainformatica.orcamento.domain.Status;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OSUpdateRequest;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoRequest;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_ordem_servico")
    @SequenceGenerator(name = "sequence_ordem_servico", sequenceName = "sequence_ordem_servico")
    private Long idOrdemServico;
    private String descricaoServico;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String observacao;
    private BigDecimal valorFinal;

    private LocalDate dataEntrega;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    @JsonIgnore
    private Funcionario funcionario;

    @OneToOne
    @JsonIgnore
    private Servico servico;

    public OrdemServico(Funcionario funcionario, Orcamento orcamento, Servico servico, OrdemServicoRequest ordemServicoRequest) {
        this.funcionario = funcionario;
        this.servico = servico;
        this.descricaoServico = ordemServicoRequest.getDescricaoServico();
        this.status = ordemServicoRequest.getStatus();
        this.observacao = orcamento.getObservacao();
        this.valorFinal = orcamento.getValorFinal();
    }
    public OrdemServico(OSUpdateRequest request){
        if (request.getStatus().equals(Status.ENTREGUE)){
            this.dataEntrega = LocalDate.now();
        }
        this.status = request.getStatus();
        this.descricaoServico = request.getDescricaoServico();
    }
}