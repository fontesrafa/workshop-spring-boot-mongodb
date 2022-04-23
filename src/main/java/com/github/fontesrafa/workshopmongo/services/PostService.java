package com.github.fontesrafa.workshopmongo.services;

import java.util.List;

import com.github.fontesrafa.workshopmongo.domain.Post;
import com.github.fontesrafa.workshopmongo.repositories.PostRepository;
import com.github.fontesrafa.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    
    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    public List<Post> findByTitle(String text) {
        //return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

}
