package br.com.desafio.projeto.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.models.Projeto;
import br.com.desafio.projeto.util.UtilDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDto {
    private Long id;

    private String nome;

    private String dataInicio;

    private String dataPrevisaoFim;

    private String dataFim;

    private String descricao;

    private String status;

    private Double orcamento;

    private String risco;

    private Pessoa gerente;
    private List<String> primeiroInicialNomeMembros;

    private List<Pessoa> membros = new ArrayList<>();

    public ProjetoDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.dataInicio = UtilDate.converterDataParaStringDdMmYyyy(projeto.getDataInicio());
        this.dataPrevisaoFim = UtilDate.converterDataParaStringDdMmYyyy(projeto.getDataPrevisaoFim());
        this.dataFim = UtilDate.converterDataParaStringDdMmYyyy(projeto.getDataFim());
        this.descricao = projeto.getDescricao();
        this.status = projeto.getStatus();
        this.orcamento = projeto.getOrcamento();
        this.risco = projeto.getRisco();
        this.gerente = projeto.getGerente();
        this.primeiroInicialNomeMembros = projeto.getMembros().stream().map(p -> inicalNome(p.getNome()))
                .collect(Collectors.toList());

        this.membros = projeto.getMembros();

    }

    public ProjetoDto projetoDtoYyyyMmDd(Projeto projeto) {
        ProjetoDto dto = new ProjetoDto();
        dto.setId(projeto.getId());
        dto.setNome(projeto.getNome());
        dto.setDataInicio(UtilDate.converterDataParaStringYyyyMmDd(projeto.getDataInicio()));
        dto.setDataPrevisaoFim(UtilDate.converterDataParaStringYyyyMmDd(projeto.getDataPrevisaoFim()));
        dto.setDataFim(UtilDate.converterDataParaStringYyyyMmDd(projeto.getDataFim()));
        dto.setDescricao(projeto.getDescricao());
        dto.setStatus(projeto.getStatus());
        dto.setOrcamento(projeto.getOrcamento());
        dto.setRisco(projeto.getRisco());
        dto.setGerente(projeto.getGerente());
        dto.setPrimeiroInicialNomeMembros(projeto.getMembros().stream().map(p -> inicalNome(p.getNome()))
                .collect(Collectors.toList()));

        dto.setMembros(projeto.getMembros());
        return dto;
    }

    public String inicalNome(String nomeCompleto) {
        String[] partesNome = nomeCompleto.split(" ");
        String primeiroNome = partesNome[0];
        String iniciais = primeiroNome.substring(0, 1).toUpperCase();
        return iniciais;

    }
}
