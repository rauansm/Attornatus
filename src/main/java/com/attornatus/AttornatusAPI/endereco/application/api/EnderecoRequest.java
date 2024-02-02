package com.attornatus.AttornatusAPI.endereco.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EnderecoRequest {
    @NotBlank
    private String logradouro;
    @NotBlank
    private String cep;
    @NotBlank
    private String numero;
    @NotBlank
    private String cidade;
}
