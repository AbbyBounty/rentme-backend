package com.leasepe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leasepe.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	Category findByCategoryId(int categoryId);
	Category findByCategoryName(String name);
	List<Category> findAll();
	Category save(Category c);
	
	boolean existsBycategoryId(int id);
	boolean existsBycategoryName(String name);
	
	boolean deleteByCategoryId(int id);
	boolean deleteByCategoryName(String name);
	
}
