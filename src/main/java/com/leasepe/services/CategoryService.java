package com.leasepe.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.leasepe.entities.Category;

public interface CategoryService {

	Category findByCategoryId(int id);
	Category findByCategoryName(String name);
	List<Category> findAll();
	
	Category save(Category c);
	
	boolean existsBycategoryId(int id);
	boolean existsBycategoryName(String name);
	
	boolean deleteByCategoryId(int id);
	boolean deleteByCategoryName(String name);
	Category saveWithImage(Category category, MultipartFile categoryImage);
}
