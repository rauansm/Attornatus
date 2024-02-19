package com.attornatus.AttornatusAPI.pessoa.application.api;

import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public static List<PessoaResponse> converte(List<Pessoa> pessoas) {
      return  pessoas.stream()
                .map(PessoaResponse::new)
                .collect(Collectors.toList());
    }
}
