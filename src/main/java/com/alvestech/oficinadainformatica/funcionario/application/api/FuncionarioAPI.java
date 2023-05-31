package com.alvestech.oficinadainformatica.funcionario.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Funcionário", description = "Funcionário APIs")
@RequestMapping("/v1/Funcionario")
public interface FuncionarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FuncionarioResponse saveFuncionario (@Valid @RequestBody FuncionarioRequest funcionarioRequest);

    @GetMapping(value = "/{idFuncionario}")
    @ResponseStatus(code = HttpStatus.OK)
    FuncionarioResponse findFuncionarioById (@PathVariable UUID idFuncionario);

    @GetMapping(value = "/allFuncionarios")
    @ResponseStatus(code = HttpStatus.OK)
    List<FuncionarioResponse> findAllFuncionario();
}