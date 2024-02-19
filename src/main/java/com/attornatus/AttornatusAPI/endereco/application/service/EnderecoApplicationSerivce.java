package com.attornatus.AttornatusAPI.endereco.application.service;

import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoRequest;
import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoResponse;
import com.attornatus.AttornatusAPI.endereco.application.repository.EnderecoRepository;
import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class EnderecoApplicationSerivce implements EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    @Override
    public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
        log.info("[inicia] EnderecoController - criaEndereco");
        Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
        Endereco endereco = enderecoRepository.salva(new Endereco(pessoa,enderecoRequest));
        log.info("[finaliza] EnderecoController - criaEndereco");
        return new EnderecoResponse(endereco);
    }
}
