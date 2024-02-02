package com.attornatus.AttornatusAPI.pessoa.application.service;

import com.attornatus.AttornatusAPI.DataHelper;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResponse;
import com.attornatus.AttornatusAPI.pessoa.application.api.PessoaResquest;
import com.attornatus.AttornatusAPI.pessoa.application.repository.PessoaRepository;
import com.attornatus.AttornatusAPI.pessoa.dominio.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessoaApplicationServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;
    @InjectMocks
    private PessoaApplicationService pessoaApplicationService;
    @Mock
    private Pessoa pessoa;
    @InjectMocks
    DataHelper dataHelper;


    @Test
    public void deveRetornarUmaPessoaNovaCriada() {
    PessoaResquest resquest = DataHelper.getPessoaRequest();

    when(pessoaRepository.salva(any())).thenReturn(new Pessoa(resquest));
    PessoaResponse response = pessoaApplicationService.criaNovaPessoa(resquest);

        assertNotNull(response);
        assertEquals(PessoaResponse.class, response.getClass());
        assertEquals(resquest.getNome(), response.getNome());
        assertEquals(resquest.getDataNascimento(), response.getDataNascimento());
        assertEquals(UUID.class, response.getIdPessoa().getClass());;
    }

    @Test
    public void deveRetornarListaDePessoas() {
        List<Pessoa> pessoas = DataHelper.createListPessoa();
        when(pessoaRepository.listaTodasPessoas()).thenReturn(pessoas);
        List<PessoaResponse> pessoaResponses = pessoaApplicationService.listaTodasPessoas();

        assertEquals(4,pessoaResponses.size());
        assertNotNull(pessoaResponses);
    }

    @Test
    public void deveRetornarRepresentacaoDePessoa(){
        Pessoa pessoa1 = DataHelper.createPessoa();
        UUID idPessoa = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
        when(pessoaRepository.buscaPessoaAtravesId(any(UUID.class))).thenReturn(pessoa1);
        PessoaResponse response = pessoaApplicationService.buscaPessoaAtravesId(idPessoa);

        assertNotNull(response);
        assertEquals(PessoaResponse.class, response.getClass());
        assertEquals(idPessoa, response.getIdPessoa());;
    }

    @Test
    public void deveAlterarUmaPessoa() {
        PessoaResquest pessoaResquest = DataHelper.getPessoaRequest();
        UUID idPessoa = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
        Pessoa pessoa = DataHelper.createPessoa();
        when(pessoaRepository.buscaPessoaAtravesId(any(UUID.class))).thenReturn(pessoa);
        pessoaApplicationService.alteraPessoa(idPessoa,pessoaResquest);
        verify(pessoaRepository, times(1)).salva(pessoa);
    }
    
}
