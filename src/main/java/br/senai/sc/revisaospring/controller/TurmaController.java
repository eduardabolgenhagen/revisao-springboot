package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.AlunoDTO;
import br.senai.sc.revisaospring.DTO.TurmaDTO;
import br.senai.sc.revisaospring.model.entity.Aluno;
import br.senai.sc.revisaospring.model.entity.Turma;
import br.senai.sc.revisaospring.model.service.AlunoService;
import br.senai.sc.revisaospring.model.service.TurmaService;
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
@RequestMapping("/turma")
public class TurmaController {
    TurmaService turmaService;

    // Buscar todos as turmas
    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TurmaDTO turmaDTO) {
        if (turmaService.existsById(turmaDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma Turma com esse ID.");
        }

        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }

    // Editar objeto
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody @Valid TurmaDTO turmaDTO) {
        if (!turmaService.existsById(turmaDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe uma Turma com esse ID.");
        }

        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Turma> turmaOptional = turmaService.findById(id);

        if (turmaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!turmaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe turma com esse ID");
        }

        turmaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Turma excluída.");
    }
}
