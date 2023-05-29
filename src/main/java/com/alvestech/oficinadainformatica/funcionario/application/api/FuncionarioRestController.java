package com.alvestech.oficinadainformatica.funcionario.application.api;

import com.alvestech.oficinadainformatica.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class FuncionarioRestController implements FuncionarioAPI {
    private final FuncionarioService funcionarioService;

    @Override
    public FuncionarioResponse saveFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[start] FuncionarioRestController - saveFuncionario");
        FuncionarioResponse funcionarioResponse = funcionarioService.saveFuncionario(funcionarioRequest);
        log.info("[finish] FuncionarioRestController - saveFuncionario");
        return funcionarioResponse;
    }
}
