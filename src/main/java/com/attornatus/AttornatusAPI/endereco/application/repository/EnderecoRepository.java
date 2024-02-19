package com.attornatus.AttornatusAPI.endereco.application.repository;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository {
    Endereco salva(Endereco endereco);

    List<Endereco> listaTodosEnderecosDaPessoa(Pessoa pessoa);
}
