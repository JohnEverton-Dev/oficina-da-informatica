package com.alvestech.oficinadainformatica.ordemservico.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Ordem Serviço", description = "Ordem Serviço APIs")
@RequestMapping("/v1/OrdemServico")
public interface OrdemServicoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OrdemServicoResponse saveOrdemServico (@Valid @RequestBody OrdemServicoRequest ordemServicoRequest);

    @GetMapping(value = "/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.OK)
    OrdemServicoResponse findOrdemServicoById (@Valid Long idOrdemServico);

    @PatchMapping(value = "/update/{idOrdemServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateOrdemServico (@PathVariable Long idOrdemServico, @Valid @RequestBody OSUpdateRequest osUpdateRequest);
}
