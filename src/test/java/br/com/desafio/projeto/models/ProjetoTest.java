package br.com.desafio.projeto.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.projeto.conversores.RiscoConverter;
import br.com.desafio.projeto.conversores.StatusConverter;

@ExtendWith(MockitoExtension.class)
class ProjetoTest {

    @Mock
    private StatusConverter statusConverter;

    @Mock
    private RiscoConverter riscoConverter;

    @InjectMocks
    private Projeto projeto;

    @Test
    void testGettersAndSetters() {
        Long id = 1L;
        String nome = "Projeto Teste";
        Date dataInicio = new Date();
        Date dataPrevisaoFim = new Date();
        Date dataFim = new Date();
        String descricao = "Descrição do projeto";
        String status = "Em Andamento";
        Double orcamento = 10000.00;
        String risco = "Alto";
        Pessoa gerente = new Pessoa();
        List<Pessoa> membros = new ArrayList<>();

        projeto.setId(id);
        projeto.setNome(nome);
        projeto.setDataInicio(dataInicio);
        projeto.setDataPrevisaoFim(dataPrevisaoFim);
        projeto.setDataFim(dataFim);
        projeto.setDescricao(descricao);
        projeto.setStatus(status);
        projeto.setOrcamento(orcamento);
        projeto.setRisco(risco);
        projeto.setGerente(gerente);
        projeto.setMembros(membros);

        assertEquals(id, projeto.getId());
        assertEquals(nome, projeto.getNome());
        assertEquals(dataInicio, projeto.getDataInicio());
        assertEquals(dataPrevisaoFim, projeto.getDataPrevisaoFim());
        assertEquals(dataFim, projeto.getDataFim());
        assertEquals(descricao, projeto.getDescricao());
        assertEquals(status, projeto.getStatus());
        assertEquals(orcamento, projeto.getOrcamento());
        assertEquals(risco, projeto.getRisco());
        assertEquals(gerente, projeto.getGerente());
        assertEquals(membros, projeto.getMembros());
    }
 
}