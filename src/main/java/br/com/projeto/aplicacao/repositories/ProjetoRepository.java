package br.com.projeto.aplicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.aplicacao.models.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
