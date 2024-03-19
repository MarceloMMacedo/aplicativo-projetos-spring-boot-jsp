package br.com.desafio.projeto.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.desafio.projeto.dtos.FuncionarioDto;
import br.com.desafio.projeto.exceptions.EntityNotFoundException;
import br.com.desafio.projeto.exceptions.UnsavedEntityException;
import br.com.desafio.projeto.mapper.FuncionarioMapper;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.repositories.PessoaRepository;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private FuncionarioMapper funcionarioMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarPessoa() throws UnsavedEntityException {
        final Pessoa pessoa = new Pessoa();
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        final Pessoa result = pessoaService.criarPessoa(pessoa);

        assertEquals(pessoa, result);
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testObterTodasPessoas() {
        final List<Pessoa> pessoas = new ArrayList<>();
        when(pessoaRepository.findAll()).thenReturn(pessoas);

        final List<FuncionarioDto> funcionarioDtos = new ArrayList<>();
        when(funcionarioMapper.toListDateDto(pessoas)).thenReturn(funcionarioDtos);

        final List<FuncionarioDto> result = pessoaService.obterTodasPessoas();

        assertEquals(funcionarioDtos, result);
        verify(pessoaRepository, times(1)).findAll();
        verify(funcionarioMapper, times(1)).toListDateDto(pessoas);
    }

    @Test
    void testAtualizarPessoa() throws EntityNotFoundException {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        when(pessoaRepository.existsById(id)).thenReturn(true);
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        assertDoesNotThrow(() -> pessoaService.atualizarPessoa(pessoa));
        verify(pessoaRepository, times(1)).existsById(id);
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testExcluirPessoa() throws EntityNotFoundException {
        Long id = 1L;
        when(pessoaRepository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> pessoaService.excluirPessoa(id));
        verify(pessoaRepository, times(1)).existsById(id);
        verify(pessoaRepository, times(1)).deleteById(id);
    }

    @Test
    void testAtualizarPessoaWithIdAndFuncionario() throws EntityNotFoundException {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        Pessoa funcionario = new Pessoa();
        when(pessoaRepository.existsById(id)).thenReturn(true);
        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        assertDoesNotThrow(() -> pessoaService.atualizarPessoa(id, funcionario));
        verify(pessoaRepository, times(1)).existsById(id);
        verify(pessoaRepository, times(1)).findById(id);
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testAtualizarPessoaWithIdAndFuncionarioNotFound() {
        Long id = 1L;
        Pessoa funcionario = new Pessoa();
        when(pessoaRepository.existsById(id)).thenReturn(false);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> pessoaService.atualizarPessoa(id, funcionario));

        assertEquals("Pessoa não encontrada com o ID: " + id, exception.getMessage());
        verify(pessoaRepository, times(1)).existsById(id);
        verify(pessoaRepository, never()).findById(id);
        verify(pessoaRepository, never()).save(any(Pessoa.class));
    }
}