package br.com.desafio.projeto.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.desafio.projeto.conversores.RiscoConverter;
import br.com.desafio.projeto.conversores.StatusConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_inicio")
    private Date dataInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "descricao", length = 5000)
    private String descricao;

    @Convert(converter = StatusConverter.class)
    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "orcamento")
    private Double orcamento;

    @Convert(converter = RiscoConverter.class)
    @Column(name = "risco", length = 45)
    private String risco;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private Pessoa gerente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "membros", joinColumns = @JoinColumn(name = "idprojeto"), inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    private List<Pessoa> membros = new ArrayList<>();
}