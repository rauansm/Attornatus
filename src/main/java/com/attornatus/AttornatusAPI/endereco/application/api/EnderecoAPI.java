package com.attornatus.AttornatusAPI.endereco.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
@RestController
public interface EnderecoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoResponse postEndereco (@PathVariable UUID idPessoa,
                                   @Valid @RequestBody EnderecoRequest enderecoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EnderecoResponse> getTodosEnderecosDaPessoa(@PathVariable UUID idPessoa);
}
