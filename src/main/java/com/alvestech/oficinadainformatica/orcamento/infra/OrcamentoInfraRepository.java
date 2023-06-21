package com.alvestech.oficinadainformatica.orcamento.infra;

import com.alvestech.oficinadainformatica.handler.APIException;
import com.alvestech.oficinadainformatica.orcamento.application.repository.OrcamentoRepository;
import com.alvestech.oficinadainformatica.orcamento.domain.Orcamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class OrcamentoInfraRepository implements OrcamentoRepository {
    private final OrcamentoSpringDataJPARepository orcamentoSpringDataJPARepository;

    @Override
    public Orcamento saveOrcamento(Orcamento orcamento) {
        log.info("[start] OrcamentoInfraRepository - saveOrcamento");
        Orcamento orcamentoCriado = orcamentoSpringDataJPARepository.save(orcamento);
        log.info("[finish] OrcamentoInfraRepository - saveOrcamento");
        return orcamentoCriado;
    }
    @Override
    public Orcamento findOrcamentoById(Long idOrcamento) {
        log.info("[start] OrcamentoInfraRepository - findOrcamentoById");
        Optional<Orcamento> optionalOrcamento = orcamentoSpringDataJPARepository.findById(idOrcamento);
        Orcamento orcamento = optionalOrcamento.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                "Orçamento não encontrado!"));
        log.info("[finish] OrcamentoInfraRepository - findOrcamentoById");
        return orcamento;
    }
//    public Orcamento findByCpf(String cpf) {
//        log.info("[inicia] OrcamentoInfraRepository - deleteById");
//        Optional<Orcamento> optionalOrcamento = orcamentoSpringDataJPARepository.findByClienteCpf(cpf);
//        Orcamento orcamento = optionalOrcamento
//                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
//                        "Orçamento não encontrado!"));
//        log.info("[finaliza] OrcamentoInfraRepository - deleteById");
//        return orcamento;
//    }
}