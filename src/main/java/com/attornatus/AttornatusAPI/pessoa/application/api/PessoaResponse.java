package com.attornatus.AttornatusAPI.pessoa.application.api;

import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class PessoaResponse {
    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;

    public PessoaResponse(Pessoa pessoaCriada) {
        this.idPessoa = pessoaCriada.getIdPessoa();
        this.nome = pessoaCriada.getNome();
        this.dataNascimento = pessoaCriada.getDataNascimento();
    }
}
