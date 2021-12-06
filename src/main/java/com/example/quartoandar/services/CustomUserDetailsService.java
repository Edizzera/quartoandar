package com.example.quartoandar.services;

import com.example.quartoandar.entities.User;
import com.example.quartoandar.repositories.UserRepository;
import com.example.quartoandar.resources.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNome(username);
        if(user == null) {
            throw new UsernameNotFoundException("Usuario n encontrado");
        }
        return new CustomUserDetails(user);
    }
}
