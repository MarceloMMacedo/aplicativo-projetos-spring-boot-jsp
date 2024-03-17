package br.com.desafio.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.projeto.models.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
