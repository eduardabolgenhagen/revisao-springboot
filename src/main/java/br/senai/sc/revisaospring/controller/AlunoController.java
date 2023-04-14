package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.AlunoDTO;
import br.senai.sc.revisaospring.model.entity.Aluno;
import br.senai.sc.revisaospring.model.service.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {
    AlunoService alunoService;

    // Buscar todos os alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    // Editar objeto
    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@PathVariable(value = "id") Long id, @RequestBody @Valid AlunoDTO alunoDTO) {
        if (!alunoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe um Aluno com esse ID.");
        }

        Aluno aluno = alunoService.findById(id).get();
        BeanUtils.copyProperties(alunoDTO, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!alunoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe aluno com esse ID");
        }

        alunoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno excluído.");
    }
}
