package com.attornatus.AttornatusAPI.pessoa.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class PessoaResquest {
    @NotBlank(message = "Nome não pode estar em branco!")
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
}
