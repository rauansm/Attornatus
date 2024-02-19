package com.attornatus.AttornatusAPI.pessoa.application.api;

import com.attornatus.AttornatusAPI.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
    private final PessoaService pessoaService;
    @Override
    public PessoaResponse postPessoa(PessoaResquest pessoaResquest) {
        log.info("[inicia] PessoaController - postPessoa");
        PessoaResponse novaPessoa = pessoaService.criaNovaPessoa(pessoaResquest);
        log.info("[finaliza] PessoaController - postPessoa");
        return novaPessoa;
    }

    @Override
    public PessoaResponse getPessoaAtravesId(UUID idPessoa) {
        log.info("[inicia] PessoaController - getPessoaAtravesId");
        PessoaResponse pessoa = pessoaService.buscaPessoaAtravesId(idPessoa);
        log.info("[finaliza] PessoaController - getPessoaAtravesId");
        return pessoa;
    }

    @Override
    public List<PessoaResponse> getTodasPessoas() {
        log.info("[inicia] PessoaController - getTodasPessoas");
        List<PessoaResponse> pessoas = pessoaService.listaTodasPessoas();
        log.info("[finaliza] PessoaController - getTodasPessoas");
        return pessoas;
    }

    @Override
    public void patchAlteraPessoa(UUID idPessoa, PessoaResquest pessoaResquest) {
        log.info("[inicia] PessoaController - putAlteraPessoa");
        pessoaService.alteraPessoa(idPessoa,pessoaResquest);
        log.info("[finaliza] PessoaController - putAlteraPessoa");

    }
}
