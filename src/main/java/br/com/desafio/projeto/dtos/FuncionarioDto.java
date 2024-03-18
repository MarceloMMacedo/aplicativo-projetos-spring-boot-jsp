package br.com.desafio.projeto.dtos;

import br.com.desafio.projeto.models.Pessoa;
import br.com.desafio.projeto.util.UtilDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto {
    private Long id;

    private String nome;

    private String dataNascimento;

    private String cpf;

    private String funcionario;

    private String gerente;

    public FuncionarioDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = UtilDate.converterDataParaStringDdMmYyyy(pessoa.getDataNascimento());
        this.cpf = maskCPF(pessoa.getCpf());
        this.funcionario = pessoa.getFuncionario();
        this.gerente = pessoa.getGerente();
    }

    public FuncionarioDto funcionarioDtoYyyyMmDd(Pessoa pessoa) {
        FuncionarioDto dto = new FuncionarioDto();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setDataNascimento(UtilDate.converterDataParaStringYyyyMmDd(pessoa.getDataNascimento()));
        dto.setCpf(maskCPF(pessoa.getCpf()));
        dto.setFuncionario(pessoa.getFuncionario());
        dto.setGerente(pessoa.getGerente());
        return dto;

    }

    public String maskCPF(String cpf) {
        if (cpf == null) {
            return null;
        }
        return cpf.substring(0, 3) + "********-" + cpf.substring(cpf.length() - 2, cpf.length());
    }
}
