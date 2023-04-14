package br.senai.sc.revisaospring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "turma")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    private Escola escola;

    @OneToMany
    @JoinColumn(name = "turma", nullable = true)
    private List<Aluno> listaDeAlunos;
}
