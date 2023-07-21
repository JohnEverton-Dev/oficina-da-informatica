package com.alvestech.oficinadainformatica.ordemservico.application.service;

import com.alvestech.oficinadainformatica.funcionario.application.repository.FuncionarioRepository;
import com.alvestech.oficinadainformatica.funcionario.domain.Funcionario;
import com.alvestech.oficinadainformatica.orcamento.application.repository.OrcamentoRepository;
import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoRequest;
import com.alvestech.oficinadainformatica.ordemservico.application.api.OrdemServicoResponse;
import com.alvestech.oficinadainformatica.ordemservico.application.repository.OrdemServicoRepository;
import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;
import com.alvestech.oficinadainformatica.servico.application.repository.ServicoRepository;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrdemServicoAplicattionService implements OrdemServicoService {
    public final OrdemServicoRepository ordemServicoRepository;
    public final ServicoRepository servicoRepository;
    public final FuncionarioRepository funcionarioRepository;
    public final OrcamentoRepository orcamentoRepository;

    @Override
    public OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest) {
        log.info("[start] OrdemServicoAplicattionService - saveOrdemServico");
        Funcionario funcionario = funcionarioRepository.findFuncionarioById(ordemServicoRequest.getIdFuncionario());
        Orcamento orcamento = orcamentoRepository.findOrcamentoById(ordemServicoRequest.getIdOrcamento());
        Servico servico = servicoRepository.findServicoById(ordemServicoRequest.getIdServico());
        OrdemServico ordemServico = ordemServicoRepository.saveOrdemServico(new OrdemServico(funcionario, orcamento, servico, ordemServicoRequest));
        orcamentoRepository.delete(ordemServicoRequest.getIdOrcamento());
        log.info("[finish] OrdemServicoAplicattionService - saveOrdemServico");
        return new OrdemServicoResponse(ordemServico);
    }
}
