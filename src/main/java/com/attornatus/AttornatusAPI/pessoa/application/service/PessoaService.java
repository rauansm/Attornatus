package com.attornatus.AttornatusAPI.pessoa.application.service;

import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResponse;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;

public interface PessoaService {
    PessoaResponse criaNovaPessoa(PessoaResquest pessoaResquest);
}
