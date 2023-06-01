package com.alvestech.oficinadainformatica.funcionario.infra;

import com.alvestech.oficinadainformatica.funcionario.application.repository.FuncionarioRepository;
import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import com.alvestech.oficinadainformatica.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @Override
    public Funcionario findFuncionarioById(UUID idFuncionario) {
        log.info("[start] FuncionarioInfraRepository - findFuncionarioById");
        Optional<Funcionario> optionalFuncionario = funcionarioSpringDataJPARepository.findById(idFuncionario);
        Funcionario funcionario = optionalFuncionario.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Funcionario não encontrado!"));
        log.info("[finish] FuncionarioInfraRepository - findFuncionarioById");
        return funcionario;
    }
    @Override
    public List<Funcionario> findAllFuncionarios() {
        log.info("[start] FuncionarioInfraRepository - findAllFuncionarios");
        List<Funcionario> allFuncionarios = funcionarioSpringDataJPARepository.findAll();
        log.info("[finish] FuncionarioInfraRepository - findAllFuncionarios");
        return allFuncionarios;
    }
    @Override
    public void deleteFuncionario(UUID idFuncionario) {
        log.info("[start] FuncionarioInfraRepository - deleteFuncionario");
        funcionarioSpringDataJPARepository.deleteById(idFuncionario);
        log.info("[finish] FuncionarioInfraRepository - deleteFuncionario");
    }
}