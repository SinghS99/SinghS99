package com.springboot.digitalbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.digitalbook.entities.Book;
@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

}
