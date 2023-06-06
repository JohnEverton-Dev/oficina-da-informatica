package com.alvestech.oficinadainformatica.servico.application.api;

import com.alvestech.oficinadainformatica.servico.application.service.ServicoService;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ServicoResponse findServicoById(Long idServico) {
        log.info("[start] ServicoRestController - findServicoById");
        Servico servico = servicoService.findServicoById(idServico);
        log.info("[finish] ServicoRestController - findServicoById");
        return new ServicoResponse(servico);
    }
    @Override
    public List<ServicoResponse> findAllServicos() {
        log.info("[start] ServicoRestController - findAllServicos");
        List<ServicoResponse> listServicos = servicoService.findAllServicos();
        log.info("[finish] ServicoRestController - findAllServicos");
        return listServicos;
    }
    @Override
    public void deleteServico(Long idServico) {
        log.info("[start] ServicoRestController - deleteServico");
        servicoService.deleteServico(idServico);
        log.info("[finish] ServicoRestController - deleteServico");
    }

    @Override
    public void updateServico(Long idServico, ServicoRequest servicoRequest) {
        log.info("[start] ServicoRestController - updateServico");
        servicoService.updateServico(idServico, servicoRequest);
        log.info("[finish] ServicoRestController - updateServico");
    }
}