package com.alvestech.oficinadainformatica.cliente.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Cliente", description = "Cliente APIs")
@RequestMapping("/v1/Cliente")
public interface ClienteAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse saveCliente (@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse findClienteById(@PathVariable UUID idCliente);

    @GetMapping(value = "/findAllClientes")
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> findAllClientes();

    @DeleteMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteCliente (@PathVariable UUID idCliente);

    @PatchMapping(value = "/update/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateCliente (@PathVariable UUID idCliente, @Valid @RequestBody EditaClienteRequest editaClienteRequest);

    @GetMapping(value = "/cpf")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse findByCpf (@RequestParam String cpf);
}