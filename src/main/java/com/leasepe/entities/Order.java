package com.leasepe.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders" )
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	@Column(nullable = false, precision = 10,scale = 2)
	private double total;
	@Column(name = "up_id", nullable = false)
	private int upId;
	@Column(nullable = false)
	private int status;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "modified_at", nullable = false)
	private Date modifiedAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "delivery_date", nullable = false)
	private Date deliveryDate;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id" )
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItemList;

	{
		this.orderItemList = new ArrayList<OrderItem>();
	}
	public Order() {

	}

	public Order(int orderId, double total, int upId, int status, Date createdAt, Date modifiedAt, Date deliveryDate,
			 User user, List<OrderItem> orderItemList) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.upId = upId;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.deliveryDate = deliveryDate;

		this.user = user;
		this.orderItemList = orderItemList;
	}

	public int getOrderId() {
		return orderId;
	}
	

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getUpId() {
		return upId;
	}

	public void setUpId(int upId) {
		this.upId = upId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	public void addItemInorder( OrderItem item) {
		item.setOrder(this);
		this.orderItemList.add(item);
	}
	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + ", upId=" + upId + ", status=" + status
				+ ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", deliveryDate=" + deliveryDate
				+ ", user=" + user + ", orderItemList=" + orderItemList + "]";
	}

}

