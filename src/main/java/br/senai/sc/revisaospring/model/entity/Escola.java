package br.senai.sc.revisaospring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "escola")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Endereco endereco;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "escola")
    private List<Professor> listaDeProfessores;

    @OneToMany
    @JoinColumn(name = "idEscola", nullable = false)
    private List<Curso> listaDeCursos;

}
