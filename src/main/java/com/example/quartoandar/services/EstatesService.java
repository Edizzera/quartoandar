package com.example.quartoandar.services;

import com.example.quartoandar.entities.Estate;
import com.example.quartoandar.entities.enums.EstateType;
import com.example.quartoandar.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstatesService {

    @Autowired
    private EstateRepository estateRepository;

    public List<Estate> encontraTodos() {
        return estateRepository.findAll();
    }
    public List<Estate> encontraPeloTipo(EstateType tipo) {
        return estateRepository.findByEstateType(tipo);
    }

    public Estate encontraPorId(Long id) {
        Optional<Estate> obj = estateRepository.findById(id);
        return obj.get();
    }

    public Estate salvarNovoImovel(Estate estate) {

        return estateRepository.save(estate);
    }

    public void deletaImovel(Long id) {
        estateRepository.deleteById(id);
    }
}
