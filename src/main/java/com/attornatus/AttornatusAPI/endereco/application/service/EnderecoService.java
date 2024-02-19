package com.attornatus.AttornatusAPI.endereco.application.service;

import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoRequest;
import com.attornatus.AttornatusAPI.endereco.application.api.EnderecoResponse;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {
    EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);

    List<EnderecoResponse> listaTodosEnderecosDaPessoa(UUID idPessoa);
}
