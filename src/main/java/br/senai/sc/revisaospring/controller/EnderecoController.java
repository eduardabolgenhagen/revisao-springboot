package br.senai.sc.revisaospring.controller;

import br.senai.sc.revisaospring.DTO.EnderecoDTO;
import br.senai.sc.revisaospring.model.entity.Endereco;
import br.senai.sc.revisaospring.model.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {
    EnderecoService enderecoService;

    // Buscar todos os endereços
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    // Salvar objeto
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    // Editar objeto
    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@PathVariable(value = "id") Long id, @RequestBody @Valid EnderecoDTO enderecoDTO) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não existe um Endereço com esse ID.");
        }

        Endereco endereco = enderecoService.findById(id).get();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    // Bucar através do ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Endereco> enderecoOptional = enderecoService.findById(id);

        if (enderecoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findById(id));
    }

    // Deletar objeto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!enderecoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe endereço com esse ID");
        }

        enderecoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço excluido.");
    }
}
