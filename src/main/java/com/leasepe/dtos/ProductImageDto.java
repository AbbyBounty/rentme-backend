package com.leasepe.dtos;


import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.leasepe.entities.Category;
import com.leasepe.entities.Product;

public class ProductImageDto {

	private int productId;

	private String productName;
	
	private String productDescription;

	private int quantityPerUnit;

	private double productPrice;

	private double productDiscount;

	private double productRating;

	private MultipartFile productImage;

	private int sellerId;
	private Category category;
	
	public ProductImageDto() {
	}

	

	
	public ProductImageDto(int productId, String productName, String productDescription, int quantityPerUnit,
			double productPrice, double productDiscount, double productRating, MultipartFile productImage, int sellerId,
			Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.quantityPerUnit = quantityPerUnit;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productRating = productRating;
		this.productImage = productImage;
		this.sellerId = sellerId;
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




	public MultipartFile getProductImage() {
		return productImage;
	}




	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}








	public int getSellerId() {
		return sellerId;
	}




	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	
	
	


	@Override
	public String toString() {
		return "ProductImageDto [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", quantityPerUnit=" + quantityPerUnit + ", productPrice=" + productPrice
				+ ", productDiscount=" + productDiscount + ", productRating=" + productRating + ", productImage="
				+ productImage + ", sellerId=" + sellerId + ", category=" + category + "]";
	}




	public static Product toEntity( ProductImageDto dto) {
		System.out.println("product from product image dto : " + dto);
		System.out.println(dto.getSellerId());
	Product entity = new Product();
	BeanUtils.copyProperties(dto, entity, "productImage");
	return entity;
		
	}
	
}

