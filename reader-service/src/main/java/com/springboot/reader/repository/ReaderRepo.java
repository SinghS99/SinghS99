package com.springboot.reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.reader.entities.Reader;
@Repository
public interface ReaderRepo extends JpaRepository<Reader,Integer> {

}
