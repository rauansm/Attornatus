package com.attornatus.AttornatusAPI.pessoa.application.service;

import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResponse;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;
import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
