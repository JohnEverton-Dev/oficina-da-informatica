package com.alvestech.oficinadainformatica.servico.application.api;

import com.alvestech.oficinadainformatica.servico.application.service.ServicoService;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServicoRestController implements ServicoAPI {
    private final ServicoService servicoService;

    @Override
    public ServicoResponse saveServico(ServicoRequest servicoRequest) {
        log.info("[start] ServicoRestController - saveServico");
        ServicoResponse servicoResponse = servicoService.saveServico(servicoRequest);
        log.info("[finish] ServicoRestController - saveServico");
        return servicoResponse;
    }
    @Override
    public ServicoResponse findServicoById(UUID idServico) {
        log.info("[start] ServicoRestController - findServicoById");
        Servico servico = servicoService.findServicoById(idServico);
        log.info("[finish] ServicoRestController - findServicoById");
        return new ServicoResponse(servico);
    }
}