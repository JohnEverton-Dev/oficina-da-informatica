package com.alvestech.oficinadainformatica.servico.application.service;

import com.alvestech.oficinadainformatica.servico.domain.Servico;
import com.alvestech.oficinadainformatica.servico.application.api.ServicoRequest;
import com.alvestech.oficinadainformatica.servico.application.api.ServicoResponse;
import com.alvestech.oficinadainformatica.servico.application.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {
   private final ServicoRepository servicoRepository;

    @Override
    public ServicoResponse saveServico(ServicoRequest servicoRequest) {
        log.info("[start] ServicoApplicationService - saveServico");
        Servico servico = servicoRepository.saveServico(new Servico(servicoRequest));
        log.info("[finish] ServicoApplicationService - saveServico");
        return new ServicoResponse(servico);
    }
    @Override
    public Servico findServicoById(UUID idServico) {
        log.info("[start] ServicoApplicationService - findServicoById");
        Servico servico = servicoRepository.findServicoById(idServico);
        log.info("[finish] ServicoApplicationService - findServicoById");
        return servico;
    }
}
