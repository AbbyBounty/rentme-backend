package com.leasepe.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.leasepe.entities.Category;
import com.leasepe.entities.Product;

public class CategoryImageDto {


	private int categoryId;

	private String categoryName;

	private String categoryDescription;


	private MultipartFile categoryImage;
	
	List<ProductItemDto> productItem;

	{
		this.productItem= new ArrayList<ProductItemDto>();
	}
	
	public CategoryImageDto() {

	}

	public CategoryImageDto(int categoryId, String categoryName, String categoryDescription, MultipartFile categoryImage,
			List<ProductItemDto> productItem) {

		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryImage = categoryImage;
		this.productItem = productItem;
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

	public MultipartFile getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(MultipartFile categoryImage) {
		this.categoryImage = categoryImage;
	}

	public List<ProductItemDto> getProductItem() {
		return productItem;
	}

	public void setProductItem(List<ProductItemDto> productItem) {
		this.productItem = productItem;
	}

	public void addProductItem(ProductItemDto item) {
		this.productItem.add(item);
	}
	
	@Override
	public String toString() {
		return "CategoryItemDto [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryImage=" + categoryImage + ", productItem=" + productItem + "]";
	}

	
	public static Category toEntity( CategoryImageDto dto) {
		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity, "categoryImage" );
		List<Product> newProductList = entity.getProductList();
		System.out.println("Product list from dto :" + newProductList);
		newProductList.forEach(item->{
		
		item.setCategory(entity);
		ProductItemDto itemDto = ProductItemDto.fromEntity(item);
		dto.addProductItem(itemDto);
		});
		
		return entity;
	}
}