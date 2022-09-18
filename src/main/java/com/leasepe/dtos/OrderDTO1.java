package com.leasepe.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.leasepe.entities.Order;
import com.leasepe.entities.OrderItem;
import com.leasepe.entities.User;

public class OrderDTO1 {
	private int userId;
	private String name;
	private String phone;
	private String email;

	private int OrderId;
	private double total;
	private int status;
	private Date deliveryDate;
	private List<OrderItemDTO1> orderItemDtoList;

	

	public OrderDTO1() {
		
	}

	public OrderDTO1(int orderId, double total, int status, List<OrderItemDTO1> orderItemDtoList) {
		OrderId = orderId;
		this.total = total;
		this.status = status;
		this.orderItemDtoList = orderItemDtoList;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<OrderItemDTO1> getOrderItemDtoList() {
		return orderItemDtoList;
	}

	public void setOrderItemDtoList(List<OrderItemDTO1> orderItemDtoList) {
		this.orderItemDtoList = orderItemDtoList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	@Override
	public String toString() {
		return "OrderDTO1 [OrderId=" + OrderId + ", total=" + total + ", status=" + status + ", orderItemDtoList="
				+ orderItemDtoList + "]";
	}

	public static OrderDTO1 fromEntity(Order order) {
		OrderDTO1 orderDto = new OrderDTO1();
		BeanUtils.copyProperties(order, orderDto);
		orderDto.setUserId(order.getUser().getId());
		orderDto.setName(order.getUser().getName());
		orderDto.setEmail(order.getUser().getEmail());
		orderDto.setPhone(order.getUser().getPhoneNo());
		List<OrderItemDTO1> orderItemDtoList1 = new ArrayList<OrderItemDTO1>();
		for (OrderItem orderItem : order.getOrderItemList()) {

			OrderItemDTO1 orderItemDto = OrderItemDTO1.fromEntity(orderItem);
			orderItemDtoList1.add(orderItemDto);
		}
		orderDto.setOrderItemDtoList(orderItemDtoList1);
		return orderDto;
	}

	public static OrderDTO1 fromEntityforEmployee(Order order) {
		User user = order.getUser();
		OrderDTO1 orderDto = new OrderDTO1();

		BeanUtils.copyProperties(order, orderDto);
		BeanUtils.copyProperties(user, orderDto);

		

		ArrayList<OrderItemDTO1> orderItemDtoList1 = new ArrayList<OrderItemDTO1>();
		for (OrderItem orderItem : order.getOrderItemList()) {

			OrderItemDTO1 orderItemDto = OrderItemDTO1.fromEntity(orderItem);
			orderItemDtoList1.add(orderItemDto);
		}

		orderDto.setOrderItemDtoList(orderItemDtoList1);

		return orderDto;

	}

}
