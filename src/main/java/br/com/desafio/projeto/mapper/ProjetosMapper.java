package br.com.desafio.projeto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import br.com.desafio.projeto.dtos.ProjetoDto;
import br.com.desafio.projeto.models.Projeto;

@Mapper(componentModel = "spring")
public interface ProjetosMapper {
    default List<ProjetoDto> toListDateDto(List<Projeto> projetos) {
        return projetos.stream().map(ProjetoDto::new).collect(Collectors.toList());
    }

    default ProjetoDto toDateDto(Projeto projeto) {
        return new ProjetoDto().projetoDtoYyyyMmDd(projeto);
    }
}
