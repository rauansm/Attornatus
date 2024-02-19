package com.attornatus.AttornatusAPI.pessoa.application.repository;

import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);
}
