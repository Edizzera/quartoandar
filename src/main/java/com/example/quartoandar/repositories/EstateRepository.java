package com.example.quartoandar.repositories;

import com.example.quartoandar.entities.Estate;
import com.example.quartoandar.entities.enums.EstateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstateRepository extends JpaRepository<Estate, Long> {
    List<Estate> findByEstateType(EstateType estateType);
}
