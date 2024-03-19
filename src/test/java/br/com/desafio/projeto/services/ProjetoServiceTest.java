package br.com.desafio.projeto.services;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.desafio.projeto.dtos.ProjetoDto;
import br.com.desafio.projeto.exceptions.EntityNotFoundException;
import br.com.desafio.projeto.exceptions.UnsavedEntityException;
import br.com.desafio.projeto.mapper.ProjetosMapper;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.models.Projeto;
import br.com.desafio.projeto.repositories.PessoaRepository;
import br.com.desafio.projeto.repositories.ProjetoRepository;

public class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private ProjetosMapper projetoMapper;

    @InjectMocks
    private ProjetoService projetoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInserirProjeto() throws UnsavedEntityException {
        final Projeto projeto = new Projeto();
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        final Projeto result = projetoService.inserirProjeto(projeto);

        Assertions.assertNotNull(result);
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    public void testExcluirProjeto() throws EntityNotFoundException {
        Long projetoId = 1L;
        doNothing().when(projetoRepository).deleteById(projetoId);

        projetoService.excluirProjeto(projetoId);

        verify(projetoRepository, times(1)).deleteById(projetoId);
    }

    @Test
    public void testExcluirProjeto_ThrowsEntityNotFoundException() {
        Long projetoId = 1L;
        doThrow(EmptyResultDataAccessException.class).when(projetoRepository).deleteById(projetoId);

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            projetoService.excluirProjeto(projetoId);
        });

        verify(projetoRepository, times(1)).deleteById(projetoId);
    }

    @Test
    public void testAlterarProjeto() throws UnsavedEntityException {
        long id = 1L;
        Projeto projeto = new Projeto();
        projeto.setMembros(new ArrayList<>());
        Projeto projeto2 = new Projeto();
        projeto2.setMembros(new ArrayList<>());
        List<Pessoa> membros = new ArrayList<>();
        membros.add(new Pessoa());

        when(projetoRepository.findById(id)).thenReturn(Optional.of(projeto2));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto2);

        final Projeto result = projetoService.alterarProjeto(id, projeto);

        Assertions.assertNotNull(result);
        verify(projetoRepository, times(1)).findById(id);
        verify(projetoRepository, times(1)).save(projeto2);
    }

    @Test
    public void testConsultarProjeto() throws EntityNotFoundException {
        Long projetoId = 1L;
        Projeto projeto = new Projeto();
        ProjetoDto projetoDto = new ProjetoDto();

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.of(projeto));
        when(projetoMapper.toDateDto(projeto)).thenReturn(projetoDto);

        final ProjetoDto result = projetoService.consultarProjeto(projetoId);

        Assertions.assertNotNull(result);
        verify(projetoRepository, times(1)).findById(projetoId);
        verify(projetoMapper, times(1)).toDateDto(projeto);
    }

    @Test
    public void testConsultarProjeto_ThrowsEntityNotFoundException() {
        Long projetoId = 1L;

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            projetoService.consultarProjeto(projetoId);
        });

        verify(projetoRepository, times(1)).findById(projetoId);
        verify(projetoMapper, never()).toDateDto(any(Projeto.class));
    }

    @Test
    public void testAssociarMembroAoProjeto_ThrowsEntityNotFoundException() {
        Long projetoId = 1L;
        Long membroId = 2L;

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            projetoService.associarMembroAoProjeto(projetoId, membroId);
        });

        verify(projetoRepository, times(1)).findById(projetoId);
        verify(pessoaRepository, never()).findById(anyLong());
        verify(projetoRepository, never()).save(any(Projeto.class));
    }

    @Test
    public void testClassificarProjeto() throws EntityNotFoundException {
        Long projetoId = 1L;
        String risco = "Alto";
        Projeto projeto = new Projeto();

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.of(projeto));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        projetoService.classificarProjeto(projetoId, risco);

        verify(projetoRepository, times(1)).findById(projetoId);
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    public void testClassificarProjeto_ThrowsEntityNotFoundException() {
        Long projetoId = 1L;
        String risco = "Alto";

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            projetoService.classificarProjeto(projetoId, risco);
        });

        verify(projetoRepository, times(1)).findById(projetoId);
        verify(projetoRepository, never()).save(any(Projeto.class));
    }

    @Test
    public void testAlterarStatusDoProjeto() throws EntityNotFoundException {
        Long projetoId = 1L;
        String status = "Em Andamento";
        Projeto projeto = new Projeto();

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.of(projeto));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        projetoService.alterarStatusDoProjeto(projetoId, status);

        verify(projetoRepository, times(1)).findById(projetoId);
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    public void testAlterarStatusDoProjeto_ThrowsEntityNotFoundException() {
        Long projetoId = 1L;
        String status = "Em Andamento";

        when(projetoRepository.findById(projetoId)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            projetoService.alterarStatusDoProjeto(projetoId, status);
        });

        verify(projetoRepository, times(1)).findById(projetoId);
        verify(projetoRepository, never()).save(any(Projeto.class));
    }

    @Test
    public void testObterTodosProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        List<ProjetoDto> projetoDtos = new ArrayList<>();

        when(projetoRepository.findAll()).thenReturn(projetos);
        when(projetoMapper.toListDateDto(projetos)).thenReturn(projetoDtos);

        final List<ProjetoDto> result = projetoService.obterTodosProjetos();

        Assertions.assertNotNull(result);
        verify(projetoRepository, times(1)).findAll();
        verify(projetoMapper, times(1)).toListDateDto(projetos);
    }

}