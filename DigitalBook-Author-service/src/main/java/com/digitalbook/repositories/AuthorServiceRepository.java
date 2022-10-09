package com.digitalbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbook.entities.Author;


public interface AuthorServiceRepository extends JpaRepository<Author, Integer> {
}