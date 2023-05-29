package com.alvestech.oficinadainformatica.funcionario.domain;

import com.alvestech.oficinadainformatica.funcionario.application.api.FuncionarioRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
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
}