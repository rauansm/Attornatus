package com.attornatus.AttornatusAPI.pessoa.dominio;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPessoa", updatable = false, unique = true, nullable = false)
    private UUID idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    @Embedded
    private Endereco endereco;

}
