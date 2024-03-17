package br.com.desafio.projeto.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import br.com.desafio.projeto.exceptions.EntityNotFoundException;
import br.com.desafio.projeto.exceptions.UnsavedEntityException;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) throws UnsavedEntityException {
        try {
            return pessoaRepository.save(pessoa);
        } catch (Exception e) {
            throw new UnsavedEntityException("Houve um erro inesperado ao tentar salvar a pessoa", e);
        }
    }

    public Pessoa obterPessoaPorId(Long id) throws EntityNotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID: " + id));
    }

    public List<Pessoa> obterTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public void atualizarPessoa(Pessoa pessoa) throws EntityNotFoundException {
        if (!pessoaRepository.existsById(pessoa.getId())) {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + pessoa.getId());
        }
        pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(Long id) throws EntityNotFoundException {
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }

    public void atualizarPessoa(Long id, Pessoa entity) {

        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + id);
        }
        try {
            Pessoa pessoa = pessoaRepository.findById(id).get();
            BeanUtils.copyProperties(entity, pessoa, getNullPropertyNames(entity));
            pessoaRepository.save(pessoa);
        } catch (Exception ex) {
            throw new UnsavedEntityException("Houve um erro inesperado ao tentar salvar o registro");
        }

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