package com.example.quartoandar.repositories;

import com.example.quartoandar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    void deleteById(Long aLong);
}
