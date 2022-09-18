package com.leasepe.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leasepe.custom_exception.UserHandlingException;
import com.leasepe.dtos.CartDto;
import com.leasepe.dtos.CartItemDto;
import com.leasepe.entities.Cart;
import com.leasepe.entities.CartItem;
import com.leasepe.entities.User;
import com.leasepe.services.CartItemsService;
import com.leasepe.services.CartService;
import com.leasepe.services.UserService;
@CrossOrigin
@RequestMapping("/cart")
@RestController
public class CartController {
	
	
	Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CartItemsService cartItemsService;
	
	@Autowired
	private UserService uservice;

	@GetMapping("/{id}")
	public ResponseEntity<?> getCart(@PathVariable("id") int customerId) {
		
		logger.trace("Cart Controller  : getCart method Accessed");
		
		User user = uservice.getUser(customerId);
		if(user==null) {
			logger.error("Customer id is not exist");
			throw new UserHandlingException("Customer id not exist");
		}
			
		Cart cart = user.getCart();
		System.out.println("cart controller : "+cart);
		return ResponseEntity.ok(CartDto.fromEntity(cart));
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> saveCart(@PathVariable("id") int customerId, @RequestBody CartItem cartItem ) {
		
		logger.trace("Cart Controller  : saveCart method Accessed");
		Cart cart = new Cart(customerId);
		
		cart.addItemsInCart(cartItem);
		cartService.saveCart(cart);

		return ResponseEntity.ok("success");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> addProductInCart(@PathVariable("id") int customerId, @RequestBody CartItemDto cartItemDto ) {
		
		logger.trace("Cart Controller  : addProductInCart method Accessed");
		Cart cart = cartService.addItemInCart(customerId,cartItemDto);
		return ResponseEntity.ok(CartDto.fromEntity(cart));
	}
	
	@PutMapping("remove/{id}")
	public ResponseEntity<?> removeProductInCart(@PathVariable("id") int customerId, @RequestBody CartItemDto cartItemDto ) {
		
		logger.trace("Cart Controller  : removeProductInCart method Accessed");
		Cart cart = cartService.removeItemInCart(customerId,cartItemDto);
		return ResponseEntity.ok(CartDto.fromEntity(cart));
	}
}
