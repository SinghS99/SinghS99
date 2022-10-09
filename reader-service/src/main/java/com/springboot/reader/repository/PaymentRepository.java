package com.springboot.reader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.reader.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	public List<Payment> findByUserUserId(Integer userId);

}
