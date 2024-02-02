package com.attornatus.AttornatusAPI.endereco.infra;

import com.attornatus.AttornatusAPI.endereco.application.repository.EnderecoRepository;
import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
    private final EnderecoSpringDataJPA enderecoSpringDataJPA;
    @Override
    public Endereco salva(Endereco endereco) {
        log.info("[inicia] EnderecoInfraRepository - salva");
        Endereco enderecoSalvo = enderecoSpringDataJPA.save(endereco);
        log.info("[finaliza] EnderecoInfraRepository - salva");
        return enderecoSalvo;
    }

    @Override
    public List<Endereco> listaTodosEnderecosDaPessoa(Pessoa pessoa) {
        log.info("[inicia] EnderecoInfraRepository - listaTodosEnderecosDaPessoa");
        List<Endereco> enderecos = enderecoSpringDataJPA.findAllByPessoa(pessoa);
        log.info("[finaliza] EnderecoInfraRepository - listaTodosEnderecosDaPessoa");
        return enderecos;
    }

    @Override
    public Endereco buscaEnderecoDaPessoa(UUID idPessoa, UUID idEndereco) {
        log.info("[inicia] EnderecoInfraRepository - buscaEnderecoDaPessoa");
       Optional<Endereco> endereco = enderecoSpringDataJPA.findByPessoa(idPessoa,idEndereco);
        log.info("[finaliza] EnderecoInfraRepository - buscaEnderecoDaPessoa");
        return endereco.orElseThrow();
    }

    @Override
    public void defineTodosComoFalse(Pessoa pessoa) {
        log.info("[inicia] EnderecoInfraRepository - defineTodosComoFalse");
        enderecoSpringDataJPA.defineTodosComoFalse(pessoa);
        log.info("[finaliza] EnderecoInfraRepository - defineTodosComoFalse");
    }
}
