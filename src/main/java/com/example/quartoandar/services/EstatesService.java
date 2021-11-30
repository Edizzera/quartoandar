package com.example.quartoandar.services;

import com.example.quartoandar.entities.Estate;
import com.example.quartoandar.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstatesService {

    @Autowired
    private EstateRepository estateRepository;

    public List<Estate> findAll() {
        return estateRepository.findAll();
    }

    public Estate findById(Long id) {
        Optional<Estate> obj = estateRepository.findById(id);
        return obj.get();
    }

    public Estate save(Estate estate) {

        return estateRepository.save(estate);
    }

    public void delete(Long id) {
        estateRepository.deleteById(id);
    }
}
