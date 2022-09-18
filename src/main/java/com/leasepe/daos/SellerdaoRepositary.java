package com.leasepe.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leasepe.entities.Seller;


public interface SellerdaoRepositary extends JpaRepository<Seller,Integer> {
	@Query(value = "select * from users u inner join seller s on s.seller_id=u.user_id where s.seller_id=id;",nativeQuery = true)
      Optional<Seller> fetchDetailsSeller(@Param("id") Integer sellerId);
	@Query(value = "select * from users u inner join seller s on s.seller_id=u.user_id;",nativeQuery = true)
	 List<Seller> fetchDetailsSellerList();

	
}