package br.com.desafio.projeto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.desafio.projeto.enums.StatusCondicionalEnum;
import br.com.desafio.projeto.enums.StatusEnum;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.repositories.PessoaRepository;
import br.com.desafio.projeto.services.ProjetoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final PessoaRepository pessoaRepository;
    private final ProjetoService projetoService;

    @GetMapping("/")
    public String requestMethodName(Model model) {
        List<String> statusList = new ArrayList<>();
        statusList.add("Todos");
        for (final StatusEnum statuss : StatusEnum.values()) {
            statusList.add(statuss.getName());
        }

        model.addAttribute("status", statusList);
        List<Pessoa> gerentes = pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName());
        List<Pessoa> funcionarios = pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName());

        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("gerentes", gerentes);

        model.addAttribute("projetos", projetoService.obterTodosProjetos());
        return "projeto/listar-projetos";
    }

}
