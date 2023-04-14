package br.senai.sc.revisaospring.DTO;

import br.senai.sc.revisaospring.model.entity.Disciplina;
import br.senai.sc.revisaospring.model.entity.Endereco;
import br.senai.sc.revisaospring.model.entity.Escola;
import lombok.Data;

import java.util.List;

@Data
public class ProfessorDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Escola escola;
    private List<Disciplina> listaDeDisciplinas;
    private Endereco endereco;
}
