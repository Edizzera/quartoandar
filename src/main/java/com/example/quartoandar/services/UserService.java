package com.example.quartoandar.services;

import com.example.quartoandar.config.SecurityConfig;
import com.example.quartoandar.entities.User;
import com.example.quartoandar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public boolean veryUser(User user) {
       List<User>users = repository.findAll();
       for(User u : users){
           if(u.getCpf().equals(user.getCpf())){
               return false;
           }
       }
       return true;

    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User save(User user) {
        if(veryUser(user)) {
            return repository.save(user);
        }

        return user;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public void deleteTuto(){
        repository.deleteAll();
    }
}
