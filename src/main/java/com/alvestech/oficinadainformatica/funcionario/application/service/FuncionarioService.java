package com.alvestech.oficinadainformatica.funcionario.application.service;

import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioRequest;
import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioResponse;

public interface FuncionarioService {
    FuncionarioResponse saveFuncionario(FuncionarioRequest funcionarioRequest);
}
