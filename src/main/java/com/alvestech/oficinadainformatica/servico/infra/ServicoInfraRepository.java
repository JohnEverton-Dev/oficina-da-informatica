package com.alvestech.oficinadainformatica.servico.infra;

import com.alvestech.oficinadainformatica.handler.APIException;
import com.alvestech.oficinadainformatica.servico.application.repository.ServicoRepository;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ServicoInfraRepository implements ServicoRepository {
    private final ServicoSpringDataJPARepository servicoSpringDataJPARepository;

    @Override
    public Servico saveServico(Servico servico) {
        log.info("[start] ServicoInfraRepository - saveServico");
        try{
            servicoSpringDataJPARepository.save(servico);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"Serviço já Cadastrado!", e);
        }
        log.info("[finish] ServicoInfraRepository - saveServico");
        return servico;
    }
    @Override
    public Servico findServicoById(UUID idServico) {
        log.info("[start] ServicoInfraRepository - findServicoById");
        Optional<Servico> optionalServico = servicoSpringDataJPARepository.findById(idServico);
        Servico servico = optionalServico.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Serviço não encontrado!"));
        log.info("[finish] ServicoInfraRepository - findServicoById");
        return servico;
    }
}