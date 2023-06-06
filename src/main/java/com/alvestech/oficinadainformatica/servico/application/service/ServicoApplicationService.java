package com.alvestech.oficinadainformatica.servico.application.service;

import com.alvestech.oficinadainformatica.servico.application.api.ServicoRequest;
import com.alvestech.oficinadainformatica.servico.application.api.ServicoResponse;
import com.alvestech.oficinadainformatica.servico.application.repository.ServicoRepository;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Servico findServicoById(Long idServico) {
        log.info("[start] ServicoApplicationService - findServicoById");
        Servico servico = servicoRepository.findServicoById(idServico);
        log.info("[finish] ServicoApplicationService - findServicoById");
        return servico;
    }
    @Override
    public List<ServicoResponse> findAllServicos() {
        log.info("[start] ServicoApplicationService - findAllServicos");
        List<Servico> listServicos = servicoRepository.findAllServicos();
        log.info("[finish] ServicoApplicationService - findAllServicos");
        return ServicoResponse.converte(listServicos);
    }
    @Override
    public void deleteServico(Long idServico) {
        log.info("[start] ServicoApplicationService - deleteServico");
        Servico servico = servicoRepository.findServicoById(idServico);
        servicoRepository.deleteServico(servico.getIdServico());
        log.info("[finish] ServicoApplicationService - deleteServico");
    }
    @Override
    public void updateServico(Long idServico, ServicoRequest servicoRequest) {
        log.info("[start] ServicoApplicationService - updateServico");
        Servico servico = servicoRepository.findServicoById(idServico);
        servico.updateServico(servicoRequest);
        servicoRepository.saveServico(servico);
        log.info("[finish] ServicoApplicationService - updateServico");
    }
}
