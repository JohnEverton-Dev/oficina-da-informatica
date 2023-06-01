package com.alvestech.oficinadainformatica.orcamento.domain;

import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
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
    private BigDecimal valorEntrada;
    private int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    private int quantidadeParcelas;
    private String observacao;
    private LocalDate validade = dataOrcamento.plusDays(5);
    private BigDecimal valorFinal;

    @OneToOne
    @JsonIgnore
    private Cliente cliente;

    
}