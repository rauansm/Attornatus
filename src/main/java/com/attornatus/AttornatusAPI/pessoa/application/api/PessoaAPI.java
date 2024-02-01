package com.attornatus.AttornatusAPI.pessoa.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PessoaResponse postPessoa (@Valid @RequestBody PessoaResquest pessoaResquest);

    @GetMapping(value = "/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    PessoaResponse getPessoaAtravesId(@PathVariable UUID idPessoa);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PessoaResponse> getTodasPessoas();

    @PutMapping("/{idPessoa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void putAlteraPessoa(@PathVariable UUID idPessoa,
            @Valid @RequestBody PessoaResquest pessoaResquest);
}
