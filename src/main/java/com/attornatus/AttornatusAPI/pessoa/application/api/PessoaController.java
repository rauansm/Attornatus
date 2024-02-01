package com.attornatus.AttornatusAPI.pessoa.application.api;

import com.attornatus.AttornatusAPI.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
