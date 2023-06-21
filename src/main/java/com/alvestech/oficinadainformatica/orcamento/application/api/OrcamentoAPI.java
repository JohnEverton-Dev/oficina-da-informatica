package com.alvestech.oficinadainformatica.orcamento.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Orçamento", description = "Orçamento APIs")
@RequestMapping("/v1/Orcamento")
public interface OrcamentoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrcamentoResponse saveOrcamento (@Valid @RequestBody OrcamentoRequest orcamentoRequest);

    @GetMapping(value = "/{idOrcamento}")
    @ResponseStatus(code = HttpStatus.OK)
    OrcamentoResponse findOrcamentoById(@PathVariable Long idOrcamento);
}