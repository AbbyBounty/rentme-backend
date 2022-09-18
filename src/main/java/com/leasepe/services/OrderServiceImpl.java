package com.leasepe.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leasepe.daos.OrderDao;
import com.leasepe.daos.ProductItemDao;
import com.leasepe.daos.SellerDao;
import com.leasepe.daos.Userdao;
import com.leasepe.dtos.OrderDTO;
import com.leasepe.dtos.OrderItemDTO;
import com.leasepe.entities.Order;
import com.leasepe.entities.OrderItem;
import com.leasepe.entities.Product;
import com.leasepe.entities.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private Userdao userDao;

	@Autowired
	private ProductItemDao productDao;


	
	@Autowired SellerDao sellerDao;

	@Override
	public Order saveOrder(Order o) {
		o.setCreatedAt(new Date());
		o.setModifiedAt(new Date());
		return orderDao.save(o);
	}

	@Override
	public Order saveOrderFromDto(OrderDTO dto) {
		Order order = new Order();
		order.setTotal(dto.getTotal());
		User user = userDao.findById(dto.getUserId()).get();
		order.setUser(user);
		order.setCreatedAt(new Date());
		order.setModifiedAt(new Date());
		Date dt = java.sql.Date.valueOf(LocalDate.now().plusDays(3));
		order.setDeliveryDate(dt);
		List<OrderItemDTO> orderItemDto = dto.getOrderItem();
		for (OrderItemDTO itemDto : orderItemDto) {
			OrderItem item = new OrderItem();
			Product product = productDao.findByProductId(itemDto.getProductId());
			item.setProduct(product);
			item.setQuantity(itemDto.getQuantity());
			item.setCreatedAt(new Date());
			item.setModifiedAt(new Date());
			order.addItemInorder(item);
		}
		

		order = orderDao.save(order);
		return order;
	}
	
	@Override
	public List<Order> getOrdersByCustId(int custId) {
		List<Order> orders = orderDao.findAllByUser(userDao.findById(custId).orElse(null));
		orders.forEach(System.out::println);
		return orders;
	}
	

	
}

