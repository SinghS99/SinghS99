package com.digitalbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.entities.Author;
import com.digitalbook.repositories.AuthorServiceRepository;



@Service
public class AuthorService {

   
    @Autowired
    private AuthorServiceRepository repo;
    
    public List<Author> getAllAuthors(){
        return repo.findAll();
    }

    public Author saveAuthor(Author author){
        return repo.save(author);
    }
//    public Author createAuthor(Author author){
//        return repo.save(author);
//    }
    
}
