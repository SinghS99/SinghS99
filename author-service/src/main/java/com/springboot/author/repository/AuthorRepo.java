package com.springboot.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.author.entities.Author;
@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {

}
