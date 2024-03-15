package br.com.projeto.aplicacao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.aplicacao.models.Pessoa;
import br.com.projeto.aplicacao.services.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public String listarPessoas(Model model) {
        model.addAttribute("pessoas", pessoaService.obterTodasPessoas());
        return "listar-pessoas";
    }

    @GetMapping("/adicionar")
    public String exibirFormularioAdicionar(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "adicionar-pessoa";
    }

    @PostMapping("/adicionar")
    public String adicionarPessoa(@RequestBody Pessoa pessoaRequest) {

        pessoaService.criarPessoa(pessoaRequest);

        return "redirect:/pessoas/";
    }

    @PutMapping("/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody String entity) {
        pessoaService.atualizarPessoa(id, entity);

        return entity;
    }

    @GetMapping("/{id}")
    public String exibirDetalhesPessoa(@PathVariable Long id, Model model) {

        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        model.addAttribute("pessoa", pessoa);
        return "detalhes-pessoa";

    }

    @GetMapping("/{id}/editar")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {

        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        model.addAttribute("pessoa", pessoa);
        return "editar-pessoa";

    }

    @PostMapping("/{id}/editar")
    public String atualizarPessoa(@PathVariable Long id, @ModelAttribute Pessoa pessoa) {
        pessoa.setId(id);

        pessoaService.atualizarPessoa(pessoa);

        return "redirect:/pessoas/";
    }

    @GetMapping("/{id}/excluir")
    public String excluirPessoa(@PathVariable Long id) {

        pessoaService.excluirPessoa(id);

        return "redirect:/pessoas/";
    }
}