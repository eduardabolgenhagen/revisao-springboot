package br.senai.sc.revisaospring.model.service;

import br.senai.sc.revisaospring.model.entity.Aluno;
import br.senai.sc.revisaospring.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {
    AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public <S extends Aluno> S save(S entity) {
        return alunoRepository.save(entity);
    }

    public Optional<Aluno> findById(Long aLong) {
        return alunoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return alunoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        alunoRepository.deleteById(aLong);
    }
}
