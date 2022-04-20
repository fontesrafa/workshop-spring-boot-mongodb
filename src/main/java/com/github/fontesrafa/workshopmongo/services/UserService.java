package com.github.fontesrafa.workshopmongo.services;

import java.util.List;

import com.github.fontesrafa.workshopmongo.domain.User;
import com.github.fontesrafa.workshopmongo.repositories.UserRepository;
import com.github.fontesrafa.workshopmongo.services.exception.ObjectNotFoundException;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }
}
