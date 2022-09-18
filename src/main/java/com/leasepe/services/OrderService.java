package com.leasepe.services;



import java.util.List;

import com.leasepe.dtos.OrderDTO;
import com.leasepe.entities.Order;

public interface OrderService {

	Order saveOrderFromDto(OrderDTO dto);

	Order saveOrder(Order o);

	List<Order> getOrdersByCustId(int custId);


}
