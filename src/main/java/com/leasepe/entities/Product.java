package com.leasepe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "tb_product")
@Entity
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "product_id",  unique=true)
	private int productId;
	
	@Column(name = "product_name", length = 100)
	private String productName;
	
	@Column(name = "product_description", length = 1000)
	private String productDescription;
	
	@Column(name="quantity_per_unit")
	private int quantityPerUnit;
	
	@Column(name="product_price")
	private double productPrice;
	
	@Column(name="product_discount")
	private double productDiscount;
	
	@Column(name="product_rating")
	private double productRating;
	
	@Column(name="product_image", length = 200)
	private String productImage;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	@JsonIgnore
	private Seller seller;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id" )
	@JsonIgnore
	private Category category;
	
	
	

	
	public Product() {
		
	}


	


	public Product(int productId, String productName, String productDescription, int quantityPerUnit,
			double productPrice, double productDiscount, double productRating, String productImage, Seller seller,
			Category category, Product product) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantityPerUnit = quantityPerUnit;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productRating = productRating;
		this.productImage = productImage;
	
		this.category = category;
		
	}





	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getQuantityPerUnit() {
		return quantityPerUnit;
	}


	public void setQuantityPerUnit(int quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public double getProductDiscount() {
		return productDiscount;
	}


	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}


	public double getProductRating() {
		return productRating;
	}


	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", quantityPerUnit=" + quantityPerUnit + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productRating=" + productRating + ", productImage="
				+ productImage + ", seller=" + seller + ", category=" + category + "]";
	}



}

