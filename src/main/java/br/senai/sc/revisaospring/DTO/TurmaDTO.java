package br.senai.sc.revisaospring.DTO;

import br.senai.sc.revisaospring.model.entity.Aluno;
import br.senai.sc.revisaospring.model.entity.Escola;
import lombok.Data;

import java.util.List;

@Data
public class TurmaDTO {
    private Long id;
    private String nome;
    private Escola escola;
    private List<Aluno> listaDeAlunos;
}
