package br.senai.sc.revisaospring.DTO;

import br.senai.sc.revisaospring.model.entity.Professor;
import lombok.Data;

import java.util.List;

@Data
public class DisciplinaDTO {
    private Long id;
    private String nome;
    private List<Professor> listaDeProfessores;
}
