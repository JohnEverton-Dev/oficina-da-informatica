package com.alvestech.oficinadainformatica.servico.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Serviço", description = "Serviço APIs")
@RequestMapping("/v1/Servico")
public interface ServicoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ServicoResponse saveServico (@Valid @RequestBody ServicoRequest servicoRequest);

    @GetMapping(value = "/{idServico}")
    @ResponseStatus(code = HttpStatus.OK)
    ServicoResponse findServicoById (@PathVariable Long idServico);

    @GetMapping("/allServicos")
    @ResponseStatus(code = HttpStatus.OK)
    List<ServicoResponse> findAllServicos();

    @DeleteMapping("/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteServico (@PathVariable Long idServico);

    @PatchMapping("/update/{idServico}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateServico (@PathVariable Long idServico, ServicoRequest servicoRequest);
}