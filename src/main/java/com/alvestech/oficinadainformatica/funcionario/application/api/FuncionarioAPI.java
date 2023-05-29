package com.alvestech.oficinadainformatica.funcionario.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Funcionário", description = "Funcionário APIs")
@RequestMapping("/v1/Funcionario")
public interface FuncionarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FuncionarioResponse saveFuncionario (@Valid @RequestBody FuncionarioRequest funcionarioRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    FuncionarioResponse
}