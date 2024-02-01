package com.attornatus.AttornatusAPI.pessoa.application.service;

import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResponse;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaResponse criaNovaPessoa(PessoaResquest pessoaResquest);

    PessoaResponse buscaPessoaAtravesId(UUID idPessoa);

    List<PessoaResponse> listaTodasPessoas();
}
