package com.attornatus.AttornatusAPI.pessoa.dominio;

import com.attornatus.AttornatusAPI.endereco.dominio.Endereco;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(PessoaResquest pessoaResquest) {
        this.idPessoa = UUID.randomUUID();
        this.nome = pessoaResquest.getNome();
        this.dataNascimento = pessoaResquest.getDataNascimento();
    }

    public void altera(PessoaResquest pessoaResquest) {
        this.nome = pessoaResquest.getNome();
        this.dataNascimento = pessoaResquest.getDataNascimento();
    }
}
