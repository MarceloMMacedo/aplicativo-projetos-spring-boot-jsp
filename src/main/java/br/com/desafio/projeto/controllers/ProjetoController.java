package br.com.desafio.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.desafio.projeto.models.Projeto;
import br.com.desafio.projeto.services.ProjetoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping("/adicionar")
    public String inserirProjeto(@ModelAttribute Projeto projeto) {
        projetoService.inserirProjeto(projeto);
        return "redirect:/projetos/";
    }

    @PostMapping("/{projetoId}/excluir")
    public String excluirProjeto(@PathVariable Long projetoId) {
        projetoService.excluirProjeto(projetoId);
        return "redirect:/projetos/";
    }

    @PutMapping("/{id}")
    public String alterarProjeto(@PathVariable Long id, @ModelAttribute Projeto projeto) {
        projetoService.alterarProjeto(id, projeto);
        return "redirect:/projetos/";
    }

    @GetMapping("/{projetoId}")
    public String consultarProjeto(@PathVariable Long projetoId, Model model) {
        Projeto projeto = projetoService.consultarProjeto(projetoId);
        model.addAttribute("projeto", projeto);
        return "detalhes-projeto";
    }

    @PostMapping("/{projetoId}/associar/{membroId}")
    public String associarMembroAoProjeto(@PathVariable Long projetoId, @PathVariable Long membroId) {
        projetoService.associarMembroAoProjeto(projetoId, membroId);
        return "redirect:/projetos/" + projetoId;
    }

    @PostMapping("/{projetoId}/classificar")
    public String classificarProjeto(@PathVariable Long projetoId, @RequestParam String risco) {
        projetoService.classificarProjeto(projetoId, risco);
        return "redirect:/projetos/" + projetoId;
    }

    @PostMapping("/{projetoId}/status")
    public String alterarStatusDoProjeto(@PathVariable Long projetoId, @RequestParam String status) {
        projetoService.alterarStatusDoProjeto(projetoId, status);
        return "redirect:/projetos/" + projetoId;
    }
}