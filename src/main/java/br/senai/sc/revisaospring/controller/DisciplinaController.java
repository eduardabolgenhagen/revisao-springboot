package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.DisciplinaDTO;
import br.senai.sc.revisaospring.model.entity.Disciplina;
import br.senai.sc.revisaospring.model.service.DisciplinaService;
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
@RequestMapping("/disciplina")
public class DisciplinaController {
    DisciplinaService disciplinaService;

    // Buscar todos as disciplinas
    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        if (disciplinaService.existsById(disciplinaDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma Disciplina com esse ID.");
        }

        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.save(disciplina));
    }

    // Editar objeto
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        if (!disciplinaService.existsById(disciplinaDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe uma Disciplina com esse ID.");
        }

        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.save(disciplina));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);

        if (disciplinaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!disciplinaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe disciplina com esse ID");
        }

        disciplinaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina excluida.");
    }
}
