package br.senai.sc.revisaospring.DTO;

import br.senai.sc.revisaospring.model.entity.Endereco;
import lombok.Data;

@Data
public class AlunoDTO {
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;
}
