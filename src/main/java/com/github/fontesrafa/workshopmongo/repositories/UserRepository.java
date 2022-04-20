package com.github.fontesrafa.workshopmongo.repositories;

import com.github.fontesrafa.workshopmongo.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
