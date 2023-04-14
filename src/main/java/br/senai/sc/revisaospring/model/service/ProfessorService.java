package br.senai.sc.revisaospring.model.service;

import br.senai.sc.revisaospring.model.entity.Professor;
import br.senai.sc.revisaospring.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public <S extends Professor> S save(S entity) {
        return professorRepository.save(entity);
    }

    public Optional<Professor> findById(Long aLong) {
        return professorRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return professorRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        professorRepository.deleteById(aLong);
    }
}
