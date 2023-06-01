package com.alvestech.oficinadainformatica.funcionario.application.api;

import com.alvestech.oficinadainformatica.funcionario.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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
    @Override
    public FuncionarioResponse findFuncionarioById(UUID idFuncionario) {
        log.info("[start] FuncionarioRestController - findFuncionarioById");
        FuncionarioResponse funcionarioResponse = funcionarioService.findFuncionarioById(idFuncionario);
        log.info("[finish] FuncionarioRestController - findFuncionarioById");
        return funcionarioResponse;
    }
    @Override
    public List<FuncionarioResponse> findAllFuncionario() {
        log.info("[start] FuncionarioRestController - findAllFuncionario");
        List<FuncionarioResponse> listFuncionarios = funcionarioService.findAllFuncionarios();
        log.info("[finish] FuncionarioRestController - findAllFuncionario");
        return listFuncionarios;
    }
    @Override
    public void deleteFuncionario(UUID idFuncionario) {
        log.info("[start] FuncionarioRestController - deleteFuncionario");
        funcionarioService.deleteFuncionario(idFuncionario);
        log.info("[finish] FuncionarioRestController - deleteFuncionario");
    }
    @Override
    public void updateFuncionario(UUID idFuncionario, EditaFuncionarioRequest editaFuncionarioRequest) {
        log.info("[start] FuncionarioRestController - updateFuncionario");
        funcionarioService.updateFuncionario(idFuncionario, editaFuncionarioRequest);
        log.info("[idFuncionario] {}", idFuncionario);
        log.info("[finsh] FuncionarioRestController - updateFuncionario");
    }
}
