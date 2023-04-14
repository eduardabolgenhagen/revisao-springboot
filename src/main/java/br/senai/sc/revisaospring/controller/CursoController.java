package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.CursoDTO;
import br.senai.sc.revisaospring.model.entity.Curso;
import br.senai.sc.revisaospring.model.service.CursoService;
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
@RequestMapping("/curso")
public class CursoController {
    CursoService cursoService;

    // Buscar todos os cursos
    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CursoDTO cursoDTO) {
        if (cursoService.existsById(cursoDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um Curso com esse ID.");
        }

        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.save(curso));
    }

    // Editar objeto
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody @Valid CursoDTO cursoDTO) {
        if (!cursoService.existsById(cursoDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe um Curso com esse ID.");
        }

        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.save(curso));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Curso> cursoOptional = cursoService.findById(id);

        if (cursoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!cursoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe curso com esse ID");
        }

        cursoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Curso excluído.");
    }
}
