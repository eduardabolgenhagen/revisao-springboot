package br.senai.sc.revisaospring.DTO;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String bairro;
    private Long cep;
}
