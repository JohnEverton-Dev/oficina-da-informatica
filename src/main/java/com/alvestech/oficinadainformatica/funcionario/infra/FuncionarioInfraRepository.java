package com.alvestech.oficinadainformatica.funcionario.infra;

import com.alvestech.oficinadainformatica.funcionario.application.repository.FuncionarioRepository;
import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import com.alvestech.oficinadainformatica.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private final FuncionarioSpringDataJPARepository funcionarioSpringDataJPARepository;

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        log.info("[start] FuncionarioInfraRepository - saveFuncionario");
        try{
            Funcionario funcionarioCriado = funcionarioSpringDataJPARepository.save(funcionario);
            log.info("[finish] FuncionarioInfraRepository - saveFuncionario");
            return funcionarioCriado;
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Funcionário já cadastrado!");
        }

    }
}