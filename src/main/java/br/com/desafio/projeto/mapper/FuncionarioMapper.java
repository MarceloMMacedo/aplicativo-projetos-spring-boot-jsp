package br.com.desafio.projeto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import br.com.desafio.projeto.dtos.FuncionarioDto;
import br.com.desafio.projeto.models.Pessoa;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    default List<FuncionarioDto> toListDateDto(List<Pessoa> pessoas) {
        return pessoas.stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }

}
