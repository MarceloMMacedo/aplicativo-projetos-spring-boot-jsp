package br.com.desafio.projeto.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desafio.projeto.conversores.StatusCondicionalConverter;

@ExtendWith(MockitoExtension.class)
class PessoaTest {

    @Mock
    private StatusCondicionalConverter statusCondicionalConverter;

    @InjectMocks
    private Pessoa pessoa;

    @Test
    void testGettersAndSetters() {
        Long id = 1L;
        String nome = "João";
        Date dataNascimento = new Date();
        String cpf = "123456789";
        String funcionario = "SIM";
        String gerente = "NÃO";

        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setCpf(cpf);
        pessoa.setFuncionario(funcionario);
        pessoa.setGerente(gerente);

        assertEquals(id, pessoa.getId());
        assertEquals(nome, pessoa.getNome());
        assertEquals(dataNascimento, pessoa.getDataNascimento());
        assertEquals(cpf, pessoa.getCpf());
        assertEquals(funcionario, pessoa.getFuncionario());
        assertEquals(gerente, pessoa.getGerente());
    }
 

}