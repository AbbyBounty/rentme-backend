package com.leasepe.daos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.Order;
import com.leasepe.entities.User;

public interface OrderDao extends JpaRepository<Order, Integer> {
	List<Order> findAllByUser(User user);
}
