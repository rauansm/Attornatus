package com.attornatus.AttornatusAPI.pessoa.infra;

import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaSpringDataJPA extends JpaRepository<Pessoa, UUID> {
}
