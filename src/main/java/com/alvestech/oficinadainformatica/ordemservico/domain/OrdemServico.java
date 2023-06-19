package com.alvestech.oficinadainformatica.ordemservico.domain;

import com.alvestech.oficinadainformatica.servico.domain.TipoPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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

}