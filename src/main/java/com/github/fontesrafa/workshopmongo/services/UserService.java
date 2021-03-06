package com.github.fontesrafa.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.github.fontesrafa.workshopmongo.domain.User;
import com.github.fontesrafa.workshopmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }    

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
