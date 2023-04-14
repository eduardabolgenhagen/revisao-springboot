package br.senai.sc.revisaospring.model.service;

import br.senai.sc.revisaospring.model.entity.Curso;
import br.senai.sc.revisaospring.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CursoService {
    CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public <S extends Curso> S save(S entity) {
        return cursoRepository.save(entity);
    }

    public Optional<Curso> findById(Long aLong) {
        return cursoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return cursoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        cursoRepository.deleteById(aLong);
    }
}
