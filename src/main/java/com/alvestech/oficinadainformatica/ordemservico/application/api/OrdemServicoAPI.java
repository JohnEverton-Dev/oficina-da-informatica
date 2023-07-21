package com.alvestech.oficinadainformatica.ordemservico.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Ordem Serviço", description = "Ordem Serviço APIs")
@RequestMapping("/v1/OrdemServico")
public interface OrdemServicoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrdemServicoResponse saveOrdemServico (@Valid @RequestBody OrdemServicoRequest ordemServicoRequest);


}
