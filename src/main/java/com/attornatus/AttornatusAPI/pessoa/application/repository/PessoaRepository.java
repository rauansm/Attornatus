package com.attornatus.AttornatusAPI.pessoa.application.repository;

import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;

import java.util.UUID;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);

    Pessoa buscaPessoaAtravesId(UUID idPessoa);
}
