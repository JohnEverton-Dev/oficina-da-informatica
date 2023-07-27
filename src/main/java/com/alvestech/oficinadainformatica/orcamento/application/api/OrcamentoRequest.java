package com.alvestech.oficinadainformatica.orcamento.application.api;

import com.alvestech.oficinadainformatica.orcamento.domain.Status;
import com.alvestech.oficinadainformatica.servico.domain.TipoPagamento;
import com.alvestech.oficinadainformatica.servico.domain.TipoServico;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class OrcamentoRequest {
    UUID idCliente;
    Long idServico;
    @NotBlank(message = "Campo Obrigatório!")
    @CPF
    String cpf;
    @NotNull(message = "Campo Obrigatório!")
    String nomeCompleto;
    String telefone;
    @Enumerated(EnumType.STRING)
    TipoServico tipoServico;
    @Enumerated(EnumType.STRING)
    TipoPagamento tipoPagamento;
    String observacao;
    BigDecimal valorFinal;
    @Enumerated(EnumType.STRING)
    Status status;

}
