package com.github.fontesrafa.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.fontesrafa.workshopmongo.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Silva", "maria@hotmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        User joao = new User("3", "Joao Fontes", "joaoa@outlook.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex, joao));
        return ResponseEntity.ok().body(list);
    }
}
