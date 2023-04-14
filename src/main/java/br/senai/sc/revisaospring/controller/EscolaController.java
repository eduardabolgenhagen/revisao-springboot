package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.EscolaDTO;
import br.senai.sc.revisaospring.model.entity.Escola;
import br.senai.sc.revisaospring.model.service.EscolaService;
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
@RequestMapping("/escola")
public class EscolaController {
    EscolaService escolaService;

    // Buscar todos os endereços
    @GetMapping
    public ResponseEntity<List<Escola>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EscolaDTO escolaDTO) {
        if (escolaService.existsById(escolaDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma Escola com esse ID.");
        }

        Escola escola = new Escola();
        BeanUtils.copyProperties(escolaDTO, escola);
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.save(escola));
    }

    // Editar objeto
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody @Valid EscolaDTO escolaDTO) {
        if (!escolaService.existsById(escolaDTO.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe uma Escola com esse ID.");
        }

        Escola escola = new Escola();
        BeanUtils.copyProperties(escolaDTO, escola);
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.save(escola));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Escola> escolaOptional = escolaService.findById(id);

        if (escolaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Escola não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!escolaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe escola com esse ID");
        }

        escolaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Escola excluida.");
    }
}
