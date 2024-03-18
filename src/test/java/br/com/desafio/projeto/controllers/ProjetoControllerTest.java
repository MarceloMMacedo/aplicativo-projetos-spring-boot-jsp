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
import br.com.desafio.projeto.models.Projeto;
import br.com.desafio.projeto.repositories.PessoaRepository;
import br.com.desafio.projeto.services.ProjetoService;

class ProjetoControllerTest {

    @Mock
    private ProjetoService projetoService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private Model model;

    @InjectMocks
    private ProjetoController projetoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInserirProjeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto 1");
        when(projetoService.inserirProjeto(projeto)).thenReturn(projeto);

        String viewName = projetoController.inserirProjeto(projeto, model);

        verify(projetoService, times(1)).inserirProjeto(projeto);
        verify(model, times(1)).addAttribute("success", true);
        verify(model, times(1)).addAttribute("message", "Projeto adicionado com sucesso!");

        assertEquals("projeto/editar-projeto", viewName);
    }

    @Test
    void testAtualizar() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto 1");

        String viewName = projetoController.atualizar(projeto, model);

        verify(projetoService, times(1)).alterarProjeto(projeto.getId(), projeto);
        verify(model, times(1)).addAttribute("success", true);
        verify(model, times(1)).addAttribute("message", "Projeto atualizado com sucesso!");

        assertEquals("projeto/listar-projetos", viewName);
    }

    @Test
    void testGetMethodName() {
        List<Pessoa> gerentes = new ArrayList<>();
        Pessoa gerente = new Pessoa();
        gerente.setId(1L);
        gerente.setNome("Gerente 1");
        gerentes.add(gerente);

        List<Pessoa> funcionarios = new ArrayList<>();
        Pessoa funcionario = new Pessoa();
        funcionario.setId(2L);
        funcionario.setNome("Funcionário 1");
        funcionarios.add(funcionario);
        List<ProjetoDto> projetos = new ArrayList<>();
        ProjetoDto projeto = new ProjetoDto();
        projeto.setId(1L);
        projeto.setNome("Projeto 1");
        projetos.add(projeto);
        projeto.setId(2L);
        projeto.setNome("Projeto 2");
        projetos.add(projeto);

        when(pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName())).thenReturn(gerentes);
        when(pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName())).thenReturn(funcionarios);
        when(projetoService.obterTodosProjetos()).thenReturn(projetos);

        String viewName = projetoController.getMethodName(model);

        verify(pessoaRepository, times(1)).findByGerente(StatusCondicionalEnum.SIM.getName());
        verify(pessoaRepository, times(1)).findByFuncionario(StatusCondicionalEnum.SIM.getName());
        verify(projetoService, times(1)).obterTodosProjetos();
        verify(model, times(1)).addAttribute("funcionarios", funcionarios);
        verify(model, times(1)).addAttribute("gerentes", gerentes);
        verify(model, times(1)).addAttribute("projetos", projetos);

        assertEquals("projeto/listar-projetos", viewName);
    }

    @Test
    void testExcluirProjeto() {
        Long projetoId = 1L;

        String viewName = projetoController.excluirProjeto(projetoId);

        verify(projetoService, times(1)).excluirProjeto(projetoId);

        assertEquals("redirect:/projetos/", viewName);
    }

    @Test
    void testConsultarProjeto() {
        Long projetoId = 1L;
        ProjetoDto projetoDto = new ProjetoDto().projetoDtoYyyyMmDd(new Projeto());

        when(projetoService.consultarProjeto(projetoId)).thenReturn(projetoDto);
        when(pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName())).thenReturn(new ArrayList<>());
        when(pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName())).thenReturn(new ArrayList<>());

        List<Pessoa> gerentes = new ArrayList<>();
        Pessoa gerente = new Pessoa();
        gerente.setId(1L);
        gerente.setNome("Gerente 1");
        gerentes.add(gerente);

        List<Pessoa> funcionarios = new ArrayList<>();
        Pessoa funcionario = new Pessoa();
        funcionario.setId(2L);
        funcionario.setNome("Funcionário 1");
        funcionarios.add(funcionario);

        when(projetoService.consultarProjeto(projetoId)).thenReturn(projetoDto);
        when(pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName())).thenReturn(gerentes);
        when(pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName())).thenReturn(funcionarios);

        String viewName = projetoController.consultarProjeto(projetoId, model);

        verify(projetoService, times(1)).consultarProjeto(projetoId);
        verify(pessoaRepository, times(1)).findByGerente(StatusCondicionalEnum.SIM.getName());
        verify(pessoaRepository, times(1)).findByFuncionario(StatusCondicionalEnum.SIM.getName());
        verify(model, times(1)).addAttribute("funcionarios", funcionarios);
        verify(model, times(1)).addAttribute("gerentes", gerentes);
        verify(model, times(1)).addAttribute("projeto", projetoDto);

        assertEquals("projeto/editar-projeto", viewName);
    }

    @Test
    void testAssociarMembroAoProjeto() {
        Long projetoId = 1L;
        Long membroId = 2L;

        String viewName = projetoController.associarMembroAoProjeto(projetoId, membroId, model);

        verify(projetoService, times(1)).associarMembroAoProjeto(projetoId, membroId);
        verify(model, times(1)).addAttribute("success", true);
        verify(model, times(1)).addAttribute("message", "Membro adicionado ao projeto com sucesso!");

        assertEquals("projeto/editar-projeto", viewName);
    }

    @Test
    void testAssociarMembroPage() {
        Long projetoId = 1L;

        List<Pessoa> gerentes = new ArrayList<>();
        Pessoa gerente = new Pessoa();
        gerente.setId(1L);
        gerente.setNome("Gerente 1");
        gerentes.add(gerente);
        gerentes.add(gerente);

        List<Pessoa> funcionarios = new ArrayList<>();
        Pessoa funcionario = new Pessoa();
        funcionario.setId(2L);
        funcionario.setNome("Funcionário 1");
        funcionarios.add(funcionario);
        funcionarios.add(funcionario);

        String viewName = projetoController.associarMembroPage(projetoId, model);

        verify(pessoaRepository, times(1)).findByGerente(StatusCondicionalEnum.SIM.getName());
        verify(pessoaRepository, times(1)).findByFuncionario(StatusCondicionalEnum.SIM.getName());
        verify(model, times(1)).addAttribute("projetoId", projetoId);
        assertEquals("projeto/adicionar-membro", viewName);
    }

}