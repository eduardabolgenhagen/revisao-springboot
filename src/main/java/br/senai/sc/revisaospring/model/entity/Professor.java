package br.senai.sc.revisaospring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "professor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_escola", nullable = false)
    private Escola escola;

    @ManyToMany
    private List<Disciplina> listaDeDisciplinas;

    @OneToOne
    private Endereco endereco;
}
