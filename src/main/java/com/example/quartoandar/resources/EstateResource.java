package com.example.quartoandar.resources;

import com.example.quartoandar.entities.Estate;
import com.example.quartoandar.entities.enums.EstateType;
import com.example.quartoandar.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estates")
public class EstateResource {

    @Autowired
    EstateRepository estateRepository;

    @GetMapping
    public List<Estate> findAll() {
        return estateRepository.findAll();
    }

    @GetMapping("/tipo")
    public List<Estate> findByEstateType(@RequestParam EstateType tipo){
        return estateRepository.findByEstateType(tipo);
    }

    @PostMapping("/novoImovel")
    public ResponseEntity<Estate> saveEstate(@RequestBody Estate estate) {
        return new ResponseEntity<>(estateRepository.save(estate), HttpStatus.CREATED);
    }

}
