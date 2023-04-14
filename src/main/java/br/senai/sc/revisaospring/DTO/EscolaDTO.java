package br.senai.sc.revisaospring.DTO;

import br.senai.sc.revisaospring.model.entity.Curso;
import br.senai.sc.revisaospring.model.entity.Endereco;
import br.senai.sc.revisaospring.model.entity.Professor;
import lombok.Data;

import java.util.List;

@Data
public class EscolaDTO {
    private Long id;
    private String nome;
    private Endereco endereco;
    private String email;
    private List<Professor> listaDeProfessores;
    private List<Curso> listaDeCursos;
}
