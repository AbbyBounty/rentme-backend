package com.leasepe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leasepe.dtos.OrderDTO;
import com.leasepe.dtos.OrderDTO1;
import com.leasepe.entities.Order;
import com.leasepe.services.OrderService;

@CrossOrigin
@RequestMapping("/orders")
@RestController
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@PostMapping("/addorder")
	private ResponseEntity<?> saveOrder(@RequestBody OrderDTO dto) {

		logger.trace("Order Controller  : saveOrder method Accessed");
		Order order = orderService.saveOrderFromDto(dto);
		OrderDTO1 orderDTO1 = OrderDTO1.fromEntity(order);
		if( orderDTO1 != null )
		return ResponseEntity.ok(orderDTO1);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getOrder(@PathVariable("id") int custId) {
		//System.out.println("in order controller");
		
		logger.trace("Order Controller  : getOrder method Accessed");
		List<Order> orderList= orderService.getOrdersByCustId(custId);
		List<OrderDTO1> orderDtoList = new ArrayList<OrderDTO1>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDTO1.fromEntity(order));
		}
		return ResponseEntity.ok(orderDtoList);
		
//		if( orderDtoList != null )
//			return ResponseEntity.ok(orderDtoList);
//		else
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	



}
