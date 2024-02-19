package com.attornatus.AttornatusAPI.pessoa.application.repository;

import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaRepository {
    Pessoa salva(Pessoa pessoa);

    Pessoa buscaPessoaAtravesId(UUID idPessoa);

    List<Pessoa> listaTodasPessoas();
}
