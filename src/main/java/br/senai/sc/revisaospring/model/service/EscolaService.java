package br.senai.sc.revisaospring.model.service;

import br.senai.sc.revisaospring.model.entity.Escola;
import br.senai.sc.revisaospring.repository.EscolaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EscolaService {
    EscolaRepository escolaRepository;

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public <S extends Escola> S save(S entity) {
        return escolaRepository.save(entity);
    }

    public Optional<Escola> findById(Long aLong) {
        return escolaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return escolaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        escolaRepository.deleteById(aLong);
    }
}