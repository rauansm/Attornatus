package com.attornatus.AttornatusAPI.pessoa.application.service;

import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResponse;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;
import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService{
    private final PessoaRepository pessoaRepository;
    @Override
    public PessoaResponse criaNovaPessoa(PessoaResquest pessoaResquest) {
        log.info("[inicia] PessoaApplicationService - criaNovaPessoa");
        Pessoa pessoaCriada = pessoaRepository.salva(new Pessoa(pessoaResquest));
        log.info("[finaliza] PessoaApplicationService - criaNovaPessoa");
        return new PessoaResponse(pessoaCriada);
    }

    @Override
    public PessoaResponse buscaPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
        Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
        log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
        return new PessoaResponse(pessoa);
    }

    @Override
    public List<PessoaResponse> listaTodasPessoas() {
        log.info("[inicia] PessoaApplicationService - listaTodasPessoas");
        List<Pessoa> pessoas = pessoaRepository.listaTodasPessoas();
        log.info("[finaliza] PessoaApplicationService - listaTodasPessoas");
        return PessoaResponse.converte(pessoas);
    }

    @Override
    public void alteraPessoa(UUID idPessoa, PessoaResquest pessoaResquest) {
        log.info("[inicia] PessoaApplicationService - alteraPessoa");
        Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
        pessoa.altera(pessoaResquest);
        pessoaRepository.salva(pessoa);
        log.info("[finaliza] PessoaApplicationService - alteraPessoa");

    }
}
