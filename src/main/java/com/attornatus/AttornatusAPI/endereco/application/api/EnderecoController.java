package com.attornatus.AttornatusAPI.endereco.application.api;

import com.attornatus.AttornatusAPI.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI{
    private final EnderecoService enderecoService;

    @Override
    public EnderecoResponse postEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[inicia] EnderecoController - postEndereco");
        EnderecoResponse enderecoCriado = enderecoService.criaEndereco(idPessoa,enderecoRequest);
        log.info("[finaliza] EnderecoController - postEndereco");
        return enderecoCriado;
    }

    @Override
    public List<EnderecoResponse> getTodosEnderecosDaPessoa(UUID idPessoa) {
        log.info("[inicia] EnderecoController - getTodosEnderecosDaPessoa");
        List<EnderecoResponse> enderecos = enderecoService.listaTodosEnderecosDaPessoa(idPessoa);
        log.info("[finaliza] EnderecoController - getTodosEnderecosDaPessoa");
        return enderecos;
    }
}
