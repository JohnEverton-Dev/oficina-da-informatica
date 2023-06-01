package com.alvestech.oficinadainformatica.funcionario.application.repository;

import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;

import java.util.List;
import java.util.UUID;

public interface FuncionarioRepository {
    Funcionario saveFuncionario(Funcionario funcionario);
    Funcionario findFuncionarioById(UUID idFuncionario);
    List<Funcionario> findAllFuncionarios();
    void deleteFuncionario(UUID idFuncionario);
}
