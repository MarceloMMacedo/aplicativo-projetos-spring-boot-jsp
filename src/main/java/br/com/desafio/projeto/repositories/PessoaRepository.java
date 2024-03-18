package br.com.desafio.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.projeto.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByGerente(String gerente);

    List<Pessoa> findByFuncionario(String funcionario);

}
