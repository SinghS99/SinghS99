package com.digitalbook.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbook.entities.BRole;
import com.digitalbook.entities.BookRole;

@Repository
public interface BookRoleRepository extends JpaRepository<BookRole, Long> {
	Optional<BookRole> findByName(BRole name);
}
