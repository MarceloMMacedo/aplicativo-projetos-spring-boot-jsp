package br.com.desafio.projeto.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import br.com.desafio.projeto.dtos.FuncionarioDto;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.services.PessoaService;

class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @Mock
    private Model model;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarPessoas() {
        List<FuncionarioDto> pessoas = new ArrayList<>();
        FuncionarioDto pessoa = new FuncionarioDto();
        pessoa.setId(1L);
        pessoa.setNome("João");
        pessoas.add(pessoa);
        pessoa.setId(2L);
        pessoa.setNome("Maria");
        pessoas.add(pessoa);

        when(pessoaService.obterTodasPessoas()).thenReturn(pessoas);

        String viewName = pessoaController.listarPessoas(model);

        verify(pessoaService, times(1)).obterTodasPessoas();
        verify(model, times(1)).addAttribute("funcionarios", pessoas);

        assertEquals("funcionario/listar-funcionarios", viewName);
    }

    @Test
    void testExibirFormularioAdicionar() {
        String viewName = pessoaController.exibirFormularioAdicionar(model);

        verify(model, times(1)).addAttribute("funcionario", new Pessoa());
        assertEquals("funcionario/adicionar-funcionario", viewName);
    }

    @Test
    void testAtualizarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");

        String viewName = pessoaController.atualizarPessoa(1L, pessoa);

        verify(pessoaService, times(1)).atualizarPessoa(pessoa);
        assertEquals("redirect:/funcionarios/", viewName);
    }

    @Test
    void testExibirFormularioEditar() {
        Long id = 1L;
        FuncionarioDto funcionario = new FuncionarioDto();
        funcionario.setId(id);
        funcionario.setNome("João");

        when(pessoaService.obterPessoaPorId(id)).thenReturn(funcionario);

        String viewName = pessoaController.exibirFormularioEditar(id, model);

        verify(pessoaService, times(1)).obterPessoaPorId(id);
        verify(model, times(1)).addAttribute("funcionario", funcionario);
        assertEquals("funcionario/editar-funcionario", viewName);
    }

    @Test
    void testExcluirPessoa() {
        Long id = 1L;

        String viewName = pessoaController.excluirPessoa(id);

        verify(pessoaService, times(1)).excluirPessoa(id);
        assertEquals("redirect:/funcionarios/", viewName);
    }
}