package com.github.fontesrafa.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.github.fontesrafa.workshopmongo.domain.Post;
import com.github.fontesrafa.workshopmongo.domain.User;
import com.github.fontesrafa.workshopmongo.dto.AuthorDTO;
import com.github.fontesrafa.workshopmongo.dto.CommentDTO;
import com.github.fontesrafa.workshopmongo.repositories.PostRepository;
import com.github.fontesrafa.workshopmongo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();
        
        User maria = new User(null, "Maria Silva", "maria@hotmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User joao = new User(null, "Joao Fontes", "joaoa@outlook.com");

        userRepository.saveAll(Arrays.asList(maria, alex, joao));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar pro Maranhão, abraços", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Cheguei!", "Cheguei de viagem, deu tudo certo!", new AuthorDTO(maria));
        
        CommentDTO c1 = new CommentDTO("Boa viagem mana!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(joao));
        CommentDTO c3 = new CommentDTO("Have a good day!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));
        
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }    
}
