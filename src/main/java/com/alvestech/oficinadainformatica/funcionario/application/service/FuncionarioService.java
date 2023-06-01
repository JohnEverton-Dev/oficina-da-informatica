package com.alvestech.oficinadainformatica.funcionario.application.service;

import com.alvestech.oficinadainformatica.funcionario.application.api.EditaFuncionarioRequest;
import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioRequest;
import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioResponse;

import java.util.List;
import java.util.UUID;

public interface FuncionarioService {
    FuncionarioResponse saveFuncionario(FuncionarioRequest funcionarioRequest);
    FuncionarioResponse findFuncionarioById(UUID idFuncionario);
    List<FuncionarioResponse> findAllFuncionarios();
    void deleteFuncionario(UUID idFuncionario);
    void updateFuncionario(UUID idFuncionario, EditaFuncionarioRequest editaFuncionarioRequest);
}
