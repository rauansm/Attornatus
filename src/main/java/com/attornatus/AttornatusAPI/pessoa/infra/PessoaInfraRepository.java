package com.attornatus.AttornatusAPI.pessoa.infra;

import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {

    private final PessoaSpringDataJPA pessoaSpringDataJPA;
    @Override
    public Pessoa salva(Pessoa pessoa) {
        log.info("[inicia] PessoaInfraRepository - salva");
        Pessoa pessoaSalva = pessoaSpringDataJPA.save(pessoa);
        log.info("[finaliza] PessoaInfraRepository - salva");
        return pessoaSalva;
    }
}
