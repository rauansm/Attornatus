package com.attornatus.AttornatusAPI.pessoa.infra;

import com.attornatus.AttornatusAPI.handler.APIException;
import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Pessoa buscaPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaInfraRepository - buscaPessoaAtravesId");
        Optional<Pessoa> pessoa = pessoaSpringDataJPA.findById(idPessoa);
        log.info("[finaliza] PessoaInfraRepository - buscaPessoaAtravesId");
        return pessoa.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
    }

    @Override
    public List<Pessoa> listaTodasPessoas() {
        log.info("[inicia] PessoaInfraRepository - listaTodasPessoas");
        List<Pessoa> pessoas = pessoaSpringDataJPA.findAll();
        log.info("[finaliza] PessoaInfraRepository - listaTodasPessoas");
        return pessoas;
    }
}
