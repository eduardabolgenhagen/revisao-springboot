package br.senai.sc.revisaospring.model.service;

import br.senai.sc.revisaospring.model.entity.Disciplina;
import br.senai.sc.revisaospring.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DisciplinaService {
    DisciplinaRepository disciplinaRepository;

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public <S extends Disciplina> S save(S entity) {
        return disciplinaRepository.save(entity);
    }

    public Optional<Disciplina> findById(Long aLong) {
        return disciplinaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return disciplinaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        disciplinaRepository.deleteById(aLong);
    }
}