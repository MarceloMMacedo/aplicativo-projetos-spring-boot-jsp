package br.com.desafio.projeto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.desafio.projeto.conversores.StatusCondicionalConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "datanascimento")
    private Date dataNascimento;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Convert(converter = StatusCondicionalConverter.class)
    @Column(name = "funcionario")
    private String funcionario;

    @Convert(converter = StatusCondicionalConverter.class)
    @Column(name = "gerente")
    private String gerente;

}
