package com.alvestech.oficinadainformatica.cliente.domain;

import com.alvestech.oficinadainformatica.cliente.application.api.ClienteRequest;
import com.alvestech.oficinadainformatica.cliente.application.api.EditaClienteRequest;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
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
    public void update(EditaClienteRequest editaClienteRequest) {
        this.nomeCompleto = editaClienteRequest.getNomeCompleto();
        this.dataNascimento = editaClienteRequest.getDataNascimento();
        this.celular = editaClienteRequest.getCelular();
        this.email = editaClienteRequest.getEmail();
        this.endereco = editaClienteRequest.getEndereco();
        this.numero = editaClienteRequest.getNumero();
        this.bairro = editaClienteRequest.getBairro();
    }
}