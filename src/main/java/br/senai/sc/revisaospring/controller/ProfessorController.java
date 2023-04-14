package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.ProfessorDTO;
import br.senai.sc.revisaospring.model.entity.Professor;
import br.senai.sc.revisaospring.model.service.ProfessorService;
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
@RequestMapping("/professor")
public class ProfessorController {
    ProfessorService professorService;

    // Buscar todos os professores
    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProfessorDTO professorDTO) {
        if (professorService.existsById(professorDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um Professor com esse ID.");
        }

        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professor));
    }

    // Editar objeto
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody @Valid ProfessorDTO professorDTO) {
        if (!professorService.existsById(professorDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe um Professor com esse ID.");
        }

        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professor));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Professor> professorOptional = professorService.findById(id);

        if (professorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(professorService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!professorService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe professor com esse ID");
        }

        professorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor excluído.");
    }
}
