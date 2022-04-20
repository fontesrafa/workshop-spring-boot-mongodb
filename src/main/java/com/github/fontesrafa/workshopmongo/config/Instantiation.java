package com.github.fontesrafa.workshopmongo.config;

import java.util.Arrays;

import com.github.fontesrafa.workshopmongo.domain.User;
import com.github.fontesrafa.workshopmongo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        
        User maria = new User(null, "Maria Silva", "maria@hotmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User joao = new User(null, "Joao Fontes", "joaoa@outlook.com");

        userRepository.saveAll(Arrays.asList(maria, alex, joao));
        
    }
    
}
