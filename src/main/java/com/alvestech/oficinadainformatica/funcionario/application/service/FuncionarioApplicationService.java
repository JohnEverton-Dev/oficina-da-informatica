package com.alvestech.oficinadainformatica.funcionario.application.service;

import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioRequest;
import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioResponse;
import com.alvestech.oficinadainformatica.funcionario.application.repository.FuncionarioRepository;
import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioResponse saveFuncionario(FuncionarioRequest funcionarioRequest) {
        log.info("[start] FuncionarioApplicationService - saveFuncionario");
        Funcionario funcionario = funcionarioRepository.saveFuncionario(new Funcionario(funcionarioRequest));
        log.info("[finish] FuncionarioApplicationService - saveFuncionario");
        return new FuncionarioResponse(funcionario);
    }
    @Override
    public FuncionarioResponse findFuncionarioById(UUID idFuncionario) {
        log.info("[start] FuncionarioApplicationService - findFuncionarioById");
        Funcionario funcionario = funcionarioRepository.findFuncionarioById(idFuncionario);
        log.info("[finish] FuncionarioApplicationService - findFuncionarioById");
        return new FuncionarioResponse(funcionario);
    }
    @Override
    public List<FuncionarioResponse> findAllFuncionarios() {
        log.info("[start] FuncionarioApplicationService - findAllFuncionarios");
        List<Funcionario> funcionarios = funcionarioRepository.findAllFuncionarios();
        log.info("[finish] FuncionarioApplicationService - findAllFuncionarios");
        return FuncionarioResponse.converte(funcionarios);
    }
}