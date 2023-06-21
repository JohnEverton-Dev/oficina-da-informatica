package com.alvestech.oficinadainformatica.orcamento.application.service;

import com.alvestech.oficinadainformatica.cliente.application.repository.ClienteRepository;
import com.alvestech.oficinadainformatica.cliente.domain.Cliente;
import com.alvestech.oficinadainformatica.orcamento.application.api.OrcamentoRequest;
import com.alvestech.oficinadainformatica.orcamento.application.api.OrcamentoResponse;
import com.alvestech.oficinadainformatica.orcamento.application.repository.OrcamentoRepository;
import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;
import com.alvestech.oficinadainformatica.servico.application.repository.ServicoRepository;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrcamentoApplicationService implements OrcamentoService {
    private final OrcamentoRepository orcamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;

    @Override
    public OrcamentoResponse saveOrcamento(OrcamentoRequest orcamentoRequest) {
        log.info("[start] OrcamentoApplicationService - saveOrcamento");
        Servico servico = servicoRepository.findServicoById(orcamentoRequest.getIdServico());
        Cliente cliente = clienteRepository.findClienteById(orcamentoRequest.getIdCliente());
        Orcamento orcamento = orcamentoRepository.saveOrcamento(new Orcamento(cliente, servico, orcamentoRequest));
        log.info("[finish] OrcamentoApplicationService - saveOrcamento");
        return new OrcamentoResponse(orcamento);
    }
    @Override
    public OrcamentoResponse findOrcamentoById(Long idOrcamento) {
        log.info("[start] OrcamentoApplicationService - findOrcamentoById");
        Orcamento orcamento = orcamentoRepository.findOrcamentoById(idOrcamento);
        log.info("[finish] OrcamentoApplicationService - findOrcamentoById");
        return new OrcamentoResponse(orcamento);
    }
}