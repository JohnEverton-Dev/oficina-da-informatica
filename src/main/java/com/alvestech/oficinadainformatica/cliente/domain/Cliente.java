package com.alvestech.oficinadainformatica.cliente.domain;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    private String nomeCompleto;
    @CPF
    private String cpf;
    private LocalDate dataNascimento;
    private String celular;
    @Email
    private String email;
    private String endereco;
    private String numero;
    private String bairro;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.cpf = clienteRequest.getCpf();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.celular = clienteRequest.getCelular();
        this.email = clienteRequest.getEmail();
        this.endereco = clienteRequest.getEndereco();
        this.numero = clienteRequest.getNumero();
        this.bairro = clienteRequest.getBairro();
    }
}