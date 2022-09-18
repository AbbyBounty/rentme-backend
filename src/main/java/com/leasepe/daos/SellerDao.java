package com.leasepe.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.Seller;

public interface SellerDao extends JpaRepository<Seller, Integer> {

	Optional<Seller> findByCompanyEmailAndPassword(String companyEmail, String password);
	
	

}
