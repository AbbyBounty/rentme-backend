package com.leasepe.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

	public Optional<Cart> findByCustomerId(int customerId);
}
