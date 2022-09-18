package com.leasepe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Table(name = "tb_category")
@Entity
public class Category {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "category_id", unique=true)
	private int categoryId;

	@Column(name = "category_name", length = 100, unique=true)
	private String categoryName;

	@Column(name = "category_description", length = 1000)
	private String categoryDescription;

	@Column(name = "category_image", length = 200)
	private String categoryImage;

	@OneToMany(mappedBy = "category" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	
	private List<Product> productList;
	
	{this.productList = new ArrayList<Product>();}
	
	public Category() {
	
	}

	public Category(int categoryId, String categoryName, String categoryDescription, String categoryImage) {
		
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImage = categoryImage;
		
	}

	
	public Category(String categoryName, String categoryDescription, String categoryImage) {
		
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImage = categoryImage;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String multipartFile) {
		this.categoryImage = multipartFile;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	

	public void addProduct(Product product) {
		System.out.println("id: "+this);
		product.setCategory(this);
		productList.add(product);
		System.out.println(productList);

	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryImage=" + categoryImage + "]";
	}

	
	
}
