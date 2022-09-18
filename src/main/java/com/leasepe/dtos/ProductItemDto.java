package com.leasepe.dtos;

import java.util.List;



import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leasepe.entities.Product;

public class ProductItemDto {

	private int productId;

	private String productName;

	private String productDescription;

	private int quantityPerUnit;

	private double productPrice;

	private double productDiscount;

	private double productRating;

	private String productImage;

	private int sellerId;

	@JsonProperty("category_id")
	private int categoryId;

	
	public ProductItemDto() {
	
	}


	public ProductItemDto(int productId, String productName, String productDescription, int quantityPerUnit,
		double productPrice, double productDiscount, double productRating, String productImage, int supplierId) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productDescription = productDescription;
	this.quantityPerUnit = quantityPerUnit;
	this.productPrice = productPrice;
	this.productDiscount = productDiscount;
	this.productRating = productRating;
	this.productImage = productImage;
	this.sellerId = supplierId;
}


	public ProductItemDto(int productId, String productName, String productDescription, int quantityPerUnit,
			double productPrice, double productDiscount, double productRating, String productImage, int supplierId,
			int categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantityPerUnit = quantityPerUnit;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productRating = productRating;
		this.productImage = productImage;
		this.sellerId = supplierId;
		this.categoryId = categoryId;
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

	public int getSupplierId() {
		return sellerId;
	}

	public void setSupplierId(int supplierId) {
		this.sellerId = supplierId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	
	public static ProductItemDto fromEntity(Product entity) {
		ProductItemDto dto= new ProductItemDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setCategoryId(entity.getCategory().getCategoryId());
		dto.setSupplierId(entity.getSeller().getSellerId());

		return dto;
	}




	@Override
	public String toString() {
		return "ProductItemDto [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", quantityPerUnit=" + quantityPerUnit + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productRating=" + productRating + ", productImage="
				+ productImage + ", supplierId=" + sellerId + ", categoryId=" + categoryId + "]";
	}


	public static ProductItemDto fromEntity(List<Product> entity) {
		ProductItemDto dto= new ProductItemDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}

