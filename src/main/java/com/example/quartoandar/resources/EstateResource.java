package com.example.quartoandar.resources;

import com.example.quartoandar.entities.Estate;
import com.example.quartoandar.entities.enums.EstateType;
import com.example.quartoandar.repositories.EstateRepository;
import com.example.quartoandar.services.EstatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estates")
public class EstateResource {

    @Autowired
    EstatesService estatesService;



    @GetMapping
    public List<Estate> findAll() {
        return estatesService.encontraTodos();
    }


    @GetMapping("/tipo")
    public List<Estate> findByEstateType(@RequestParam EstateType tipo){
        return estatesService.encontraPeloTipo(tipo);
    }

    @PostMapping("/novoImovel")
    public ResponseEntity<Estate> saveEstate(@RequestBody Estate estate) {
        return new ResponseEntity<>(estatesService.salvarNovoImovel(estate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        estatesService.deletaImovel(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
