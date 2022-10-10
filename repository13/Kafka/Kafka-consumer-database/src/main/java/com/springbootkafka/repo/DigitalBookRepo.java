package com.springbootkafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootkafka.entity.DigitalBook;
@Repository
public interface DigitalBookRepo extends JpaRepository<DigitalBook, Long>{

}
