package br.com.desafio.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.services.PessoaService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping("/")
    public String listarPessoas(Model model) {
        model.addAttribute("funcionarios", pessoaService.obterTodasPessoas());
        return "funcionario/listar-funcionarios";
    }

    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        model.addAttribute("funcionario", new Pessoa());
        return "funcionario/adicionar-funcionario";
    }

    @PostMapping("/adicionar")
    public String adicionarPessoa(@ModelAttribute Pessoa pessoaRequest) {

        pessoaService.criarPessoa(pessoaRequest);

        return "redirect:/funcionarios/";
    }

    @PostMapping("/atualizar")
    public String putMethodName(@ModelAttribute Pessoa pessoa) {
        pessoaService.atualizarPessoa(pessoa.getId(), pessoa);

        return "redirect:/funcionarios/";
    }

    @GetMapping("/{id}/editar")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {

        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        model.addAttribute("funcionario", pessoa);
        return "funcionario/editar-funcionario";

    }

    @PostMapping("/{id}/editar")
    public String atualizarPessoa(@PathVariable Long id, @ModelAttribute Pessoa pessoa) {
        pessoa.setId(id);

        pessoaService.atualizarPessoa(pessoa);

        return "redirect:/funcionarios/";
    }

    @GetMapping("/{id}/excluir")
    public String excluirPessoa(@PathVariable Long id) {

        pessoaService.excluirPessoa(id);

        return "redirect:/funcionarios/";
    }
}