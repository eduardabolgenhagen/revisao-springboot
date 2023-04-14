package br.senai.sc.revisaospring.DTO;

import br.senai.sc.revisaospring.model.entity.Disciplina;
import lombok.Data;

import java.util.List;

@Data
public class CursoDTO {
    private Long id;
    private String nome;
    private List<Disciplina> listaDeDisciplinas;
}
