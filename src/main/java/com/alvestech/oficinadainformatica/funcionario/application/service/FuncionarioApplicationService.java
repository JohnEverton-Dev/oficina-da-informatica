package com.alvestech.oficinadainformatica.funcionario.application.service;

import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioRequest;
import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioResponse;
import com.alvestech.oficinadainformatica.funcionario.application.repository.FuncionarioRepository;
import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
