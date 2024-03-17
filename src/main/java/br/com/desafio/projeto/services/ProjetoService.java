package br.com.desafio.projeto.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.desafio.projeto.exceptions.EntityNotFoundException;
import br.com.desafio.projeto.exceptions.UnsavedEntityException;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.models.Projeto;
import br.com.desafio.projeto.repositories.PessoaRepository;
import br.com.desafio.projeto.repositories.ProjetoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final PessoaRepository pessoaRepository;

    public Projeto inserirProjeto(Projeto projeto) throws UnsavedEntityException {
        // Lógica para validar e inserir o projeto no banco de dados
        try {
            return projetoRepository.save(projeto);
        } catch (Exception ex) {
            throw new UnsavedEntityException("Houve um erro inesperado ao tentar salvar o registro");
        }
    }

    public void excluirProjeto(Long projetoId) throws EntityNotFoundException {
        // Lógica para excluir o projeto do banco de dados
        try {
            projetoRepository.deleteById(projetoId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Projeto não encontrado com o ID: " + projetoId);
        }
    }

    public Projeto alterarProjeto(long id, Projeto projeto) throws UnsavedEntityException {
        // Lógica para alterar os dados do projeto no banco de dados
        try {
            Projeto projeto2 = projetoRepository.findById(id).get();
            BeanUtils.copyProperties(projeto, projeto2, getNullPropertyNames(projeto));
            return projetoRepository.save(projeto2);
        } catch (Exception ex) {
            throw new UnsavedEntityException("Houve um erro inesperado ao tentar salvar o registro");
        }
    }

    public Projeto consultarProjeto(Long projetoId) throws EntityNotFoundException {
        // Lógica para consultar o projeto no banco de dados
        return projetoRepository.findById(projetoId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado com o ID: " + projetoId));
    }

    public void associarMembroAoProjeto(Long projetoId, Long membroId)
            throws EntityNotFoundException, UnsavedEntityException {
        // Lógica para associar um membro (Pessoa) ao projeto
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado com o ID: " + projetoId));
        Pessoa membro = pessoaRepository.findById(membroId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID: " + membroId));

        if (membro.getFuncionario()) {
            projeto.getMembros().add(membro);
            try {
                projetoRepository.save(projeto);
            } catch (Exception ex) {
                throw new UnsavedEntityException("Houve um erro inesperado ao tentar salvar o registro");
            }
        }
    }

    public void classificarProjeto(Long projetoId, String risco) throws EntityNotFoundException {
        // Lógica para classificar o projeto com um nível de risco
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado com o ID: " + projetoId));
        projeto.setRisco(risco);
        projetoRepository.save(projeto);
    }

    public void alterarStatusDoProjeto(Long projetoId, String status) throws EntityNotFoundException {
        // Lógica para alterar o status do projeto
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado com o ID: " + projetoId));
        projeto.setStatus(status);
        projetoRepository.save(projeto);
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || srcValue.toString().isEmpty())
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}