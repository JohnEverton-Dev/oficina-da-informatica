package com.alvestech.oficinadainformatica.servico.domain;

import com.alvestech.oficinadainformatica.servico.application.api.ServicoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idServico;
    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;
    private BigDecimal valorServico;

    public Servico(ServicoRequest servicoRequest) {
        this.tipoServico = servicoRequest.getTipoServico();
        this.valorServico = servicoRequest.getValorServico();
    }
    public void updateServico(ServicoRequest servicoRequest) {
        this.tipoServico = servicoRequest.getTipoServico();
        this.valorServico = servicoRequest.getValorServico();
    }
}