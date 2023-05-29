package com.alvestech.oficinadainformatica.funcionario.application.api;

import com.alvestech.oficinadainformatica.funcionario.domain.Cargo;
import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import lombok.Value;

import java.util.UUID;

@Value
public class FuncionarioResponse {

    UUID idFuncionario;
    String nomeCompleto;
    String cpf;
    String celular;
    Cargo cargo;

    public FuncionarioResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nomeCompleto = funcionario.getNomeCompleto();
        this.cpf = funcionario.getCpf();
        this.celular = funcionario.getCelular();
        this.cargo = funcionario.getCargo();
    }
}