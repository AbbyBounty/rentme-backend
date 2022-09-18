package com.leasepe.daos;





import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.OrderItem;


public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
	
	


}
