package br.com.desafio.projeto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.desafio.projeto.dtos.ProjetoDto;
import br.com.desafio.projeto.enums.StatusCondicionalEnum;
import br.com.desafio.projeto.enums.StatusEnum;
import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.models.Projeto;
import br.com.desafio.projeto.repositories.PessoaRepository;
import br.com.desafio.projeto.services.ProjetoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;
    private final PessoaRepository pessoaRepository;

    @PostMapping("/adicionar")
    public String inserirProjeto(@ModelAttribute Projeto projeto, Model model) {
        model.addAttribute("success", true);
        model.addAttribute("message", "Projeto adicionado com sucesso!");
        Projeto projetoInserido = projetoService.inserirProjeto(projeto);
        return consultarProjeto(projetoInserido.getId(), model);
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Projeto projeto, Model model) {
        projetoService.alterarProjeto(projeto.getId(), projeto);
        model.addAttribute("success", true);
        model.addAttribute("message", "Projeto atualizado com sucesso!");
        return getMethodName(model);
    }

    @GetMapping("/")
    public String getMethodName(Model model) {
        List<Pessoa> gerentes = pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName());
        List<Pessoa> funcionarios = pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName());
        List<String> statusList = new ArrayList<>();
        statusList.add("Todos");
        for (final StatusEnum statuss : StatusEnum.values()) {
            statusList.add(statuss.getName());
        }

        model.addAttribute("status", statusList);
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("gerentes", gerentes);

        model.addAttribute("projetos", projetoService.obterTodosProjetos());
        return "projeto/listar-projetos";
    }

    @GetMapping("/status/{status}")
    public String getFiltroStatus(@PathVariable String status, Model model) {
        List<String> statusList = new ArrayList<>();
        statusList.add("Todos");
        for (final StatusEnum statuss : StatusEnum.values()) {
            statusList.add(statuss.getName());
        }
        List<Pessoa> gerentes = pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName());
        List<Pessoa> funcionarios = pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName());

        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("gerentes", gerentes);

        model.addAttribute("status", statusList);

        model.addAttribute("projetos", projetoService.fimtroPorStatus(status));
        return "projeto/listar-projetos";
    }

    @PostMapping("/{projetoId}/excluir")
    public String excluirProjeto(@PathVariable Long projetoId) {
        projetoService.excluirProjeto(projetoId);
        return "redirect:/projetos/";
    }

    @GetMapping("/{projetoId}")
    public String consultarProjeto(@PathVariable Long projetoId, Model model) {

        ProjetoDto projeto = projetoService.consultarProjeto(projetoId);
        List<Pessoa> gerentes = pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName());
        List<Pessoa> funcionarios = pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName());

        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("gerentes", gerentes);
        model.addAttribute("projeto", projeto);
        return "projeto/editar-projeto";
    }

    @GetMapping("/{projetoId}/associar/{membroId}")
    public String associarMembroAoProjeto(@PathVariable Long projetoId, @PathVariable Long membroId, Model model) {
        projetoService.associarMembroAoProjeto(projetoId, membroId);

        model.addAttribute("success", true);
        model.addAttribute("message", "Membro adicionado ao projeto com sucesso!");
        return consultarProjeto(projetoId, model);
    }

    @GetMapping("/{projetoId}/adicionar-membros")
    public String associarMembroPage(@PathVariable Long projetoId, Model model) {
        List<Pessoa> gerentes = pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName());
        List<Pessoa> funcionarios = pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName());

        model.addAttribute("projetoId", projetoId);
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("gerentes", gerentes);
        return "projeto/adicionar-membro";
    }

    @PostMapping("/{projetoId}/excluir-membro/{membroId}")
    public ResponseEntity<String> excluirMenbro(@PathVariable Long projetoId, @PathVariable Long membroId) {

        projetoService.excluirMembroProjeto(projetoId, membroId);
        return ResponseEntity.ok("Membro excluido com sucesso!");
    }

    @PostMapping("/mudar-status-projeto/{projetoId}")
    public ResponseEntity<String> mudarStatusProjeto(@PathVariable Long projetoId) {
        ModelAndView modelAndView = new ModelAndView("projeto/editar-projeto");
        if (projetoService.alterarStatusEmSequencia(projetoId)) {
            ProjetoDto projeto = projetoService.consultarProjeto(projetoId);
            List<Pessoa> gerentes = pessoaRepository.findByGerente(StatusCondicionalEnum.SIM.getName());
            List<Pessoa> funcionarios = pessoaRepository.findByFuncionario(StatusCondicionalEnum.SIM.getName());

            modelAndView.addObject("funcionarios", funcionarios);
            modelAndView.addObject("gerentes", gerentes);
            modelAndView.addObject("projeto", projeto);
            modelAndView.addObject("success", true);
            modelAndView.addObject("message",
                    "O projeto foi alterado para o estadocom sucesso");
            return ResponseEntity.ok("O projeto foi alterado para o estado com sucesso");
        } else {
            modelAndView.addObject("failure", true);
            modelAndView.addObject("message",
                    "O projeto não pode ser alterado para o estado final");
            return ResponseEntity.ok("O projeto não pode ser alterado para o estado final");
        }

    }

    @PostMapping("/cancelar-projeto/{projetoId}")
    public ResponseEntity<String> cancelarProjeto(@PathVariable Long projetoId) {
        projetoService.cancelarProjeto(projetoId);
        return ResponseEntity.ok("O projeto foi cancelado com sucesso");
    }

}