package com.attornatus.AttornatusAPI.endereco.infra;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoSpringDataJPA extends JpaRepository<Endereco, UUID> {
    List<Endereco> findAllByPessoa(Pessoa pessoa);
}
