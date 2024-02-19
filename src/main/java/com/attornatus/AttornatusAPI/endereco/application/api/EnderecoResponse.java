package com.attornatus.AttornatusAPI.endereco.application.api;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Value;

import java.util.UUID;

@Value
public class EnderecoResponse {

    private UUID idEndereco;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private UUID idPessoa;
    private Boolean enderecoPrincipal = false;

    public EnderecoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.idPessoa = endereco.getPessoa().getIdPessoa();
    }
}
