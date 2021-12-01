package com.example.quartoandar.config;

import com.example.quartoandar.entities.Estate;
import com.example.quartoandar.entities.enums.EstateType;
import com.example.quartoandar.entities.enums.TipoUsuario;
import com.example.quartoandar.entities.User;
import com.example.quartoandar.repositories.EstateRepository;
import com.example.quartoandar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("teste")
public class QuartoConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EstateRepository estateRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null,"Edi","edi@gmail","0111111","12345", TipoUsuario.LOCADOR);
        User u2 = new User(null,"Eduardo","edu@gmail","0111111","12345",TipoUsuario.LOCATARIO);

        Estate e1 = new Estate(null,"Ap centro Poa",EstateType.APARTAMENTO,"Porto Alegre",44);
        Estate e2 = new Estate(null,"Casa Menino Deus",EstateType.CASA,"Porto Alegre",110);
        Estate e3 = new Estate(null,"Casa Moinhos de Vento",EstateType.CASA,"Porto Alegre",440);


        userRepository.saveAll(Arrays.asList(u1,u2));
        estateRepository.saveAll(Arrays.asList(e1,e2,e3));

    }
}
