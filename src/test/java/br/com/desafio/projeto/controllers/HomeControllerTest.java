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

import br.com.desafio.projeto.dtos.ProjetoDto;
import br.com.desafio.projeto.enums.StatusCondicionalEnum;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.repositories.PessoaRepository;
import br.com.desafio.projeto.services.ProjetoService;

class HomeControllerTest {
    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private ProjetoService projetoService;

    @Mock
    private Model model;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRequestMethodName() {
        List<Pessoa> mockGerentes = new ArrayList<>();
        final Pessoa gerente = new Pessoa();
        mockGerentes.add(gerente);

        List<Pessoa> mockFuncionarios = new ArrayList<>();
        final Pessoa funcionario = new Pessoa();
        mockFuncionarios.add(funcionario);

        List<ProjetoDto> mockProjetos = new ArrayList<>();
        final ProjetoDto projeto = new ProjetoDto();
        mockProjetos.add(projeto);

        when(pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName())).thenReturn(mockGerentes);
        when(pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName())).thenReturn(mockFuncionarios);
        when(projetoService.obterTodosProjetos()).thenReturn(mockProjetos);

        final String result = homeController.requestMethodName(model);

        verify(pessoaRepository, times(1)).findByGerente(StatusCondicionalEnum.SIM.getName());
        verify(pessoaRepository, times(1)).findByFuncionario(StatusCondicionalEnum.SIM.getName());
        verify(projetoService, times(1)).obterTodosProjetos();

        verify(model, times(1)).addAttribute("funcionarios", mockFuncionarios);
        verify(model, times(1)).addAttribute("gerentes", mockGerentes);
        verify(model, times(1)).addAttribute("projetos", mockProjetos);
        assertEquals("projeto/listar-projetos", result);
    }
}