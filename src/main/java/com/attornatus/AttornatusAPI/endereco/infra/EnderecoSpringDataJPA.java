package com.attornatus.AttornatusAPI.endereco.infra;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoSpringDataJPA extends JpaRepository<Endereco, UUID> {
}
