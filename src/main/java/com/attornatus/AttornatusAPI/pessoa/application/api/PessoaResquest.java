package com.attornatus.AttornatusAPI.pessoa.application.api;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PessoaResquest {
    private String nome;
    private LocalDate dataNascimento;
}
