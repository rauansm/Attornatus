package com.attornatus.AttornatusAPI.endereco.infra;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnderecoSpringDataJPA extends JpaRepository<Endereco, UUID> {
    List<Endereco> findAllByPessoa(Pessoa pessoa);
    @Query("from Endereco e where e.pessoa.id = :pessoa and e.idEndereco = :idEndereco")
    Optional<Endereco> findByPessoa(@Param("pessoa") UUID idPessoa,
                                    @Param("idEndereco") UUID idEndereco);

    @Modifying
    @Query("UPDATE Endereco e SET e.enderecoPrincipal = false WHERE e.pessoa = :pessoa")
    void defineTodosComoFalse(Pessoa pessoa);
}
