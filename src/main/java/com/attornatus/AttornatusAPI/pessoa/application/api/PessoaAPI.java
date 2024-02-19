package com.attornatus.AttornatusAPI.pessoa.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse postPessoa (@Valid @RequestBody PessoaResquest pessoaResquest);
}
