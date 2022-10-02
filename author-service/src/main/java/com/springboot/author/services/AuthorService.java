package com.springboot.author.services;

import java.util.List;

import com.springboot.author.entities.Author;

public interface AuthorService {

	Author createAuthor(Author author);
	Author updateAuthor(Author author,Integer authorid);
   Author  getAuthorById(Integer authorid);
   List<Author> getAllAuthor();   void deleteAuthor(Integer authorid);

}