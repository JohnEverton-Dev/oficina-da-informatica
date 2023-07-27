package com.alvestech.oficinadainformatica.funcionario.domain;

import com.alvestech.oficinadainformatica.funcionario.application.api.EditaFuncionarioRequest;
import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioRequest;
import com.alvestech.oficinadainformatica.ordemservico.domain.OrdemServico;
import com.alvestech.oficinadainformatica.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFuncionario;
    @NotBlank(message = "Campo Obrigatório!")
    private String nomeCompleto;
    @NotBlank(message = "Campo Obrigatório!")
    @CPF
    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private String celular;
    @Email
    private String email;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "funcionario")
    @JsonIgnore
    private List<Servico> servicos;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "funcionario")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;

    public Funcionario(FuncionarioRequest funcionarioRequest) {
        this.nomeCompleto = funcionarioRequest.getNomeCompleto();
        this.cpf = funcionarioRequest.getCpf();
        this.dataNascimento = funcionarioRequest.getDataNascimento();
        this.celular = funcionarioRequest.getCelular();
        this.endereco = funcionarioRequest.getEndereco();
        this.numero = funcionarioRequest.getNumero();
        this.bairro = funcionarioRequest.getBairro();
        this.cidade = funcionarioRequest.getCidade();
    }

    public void update(EditaFuncionarioRequest editaFuncionarioRequest) {
        this.nomeCompleto = editaFuncionarioRequest.getNomeCompleto();
        this.celular = editaFuncionarioRequest.getCelular();
        this.email = editaFuncionarioRequest.getEmail();
        this.endereco = editaFuncionarioRequest.getEndereco();
        this.numero = editaFuncionarioRequest.getNumero();
        this.bairro = editaFuncionarioRequest.getBairro();
        this.cidade = editaFuncionarioRequest.getCidade();
    }
}