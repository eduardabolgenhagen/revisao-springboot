package br.senai.sc.revisaospring.model.service;

import br.senai.sc.revisaospring.model.entity.Turma;
import br.senai.sc.revisaospring.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TurmaService {
    TurmaRepository turmaRepository;

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public <S extends Turma> S save(S entity) {
        return turmaRepository.save(entity);
    }

    public Optional<Turma> findById(Long aLong) {
        return turmaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return turmaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        turmaRepository.deleteById(aLong);
    }
}
