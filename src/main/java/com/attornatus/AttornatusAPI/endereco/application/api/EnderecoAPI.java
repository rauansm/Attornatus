package com.attornatus.AttornatusAPI.endereco.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
@RestController
public interface EnderecoAPI {
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    EnderecoResponse postEndereco (@PathVariable UUID idPessoa,
                                   @Valid @RequestBody EnderecoRequest enderecoRequest);
}
