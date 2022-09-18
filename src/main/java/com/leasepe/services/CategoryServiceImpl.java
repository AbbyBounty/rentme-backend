package com.leasepe.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leasepe.daos.CategoryDao;
import com.leasepe.entities.Category;
import com.leasepe.utils.StorageService;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private StorageService storageService;

	
	
	@Override
	public Category findByCategoryId(int id) {

		System.out.println("id :"+ id);
		Category category = categoryDao.findByCategoryId(id);
		System.out.println("category from daos : "+category);
		return category;
	}

	@Override
	public Category findByCategoryName(String name) {

		return categoryDao.findByCategoryName(name);
	}



	

	@Override
	public List<Category> findAll() {

		return categoryDao.findAll();
	}

	@Override
	public Category save(Category c) {

		System.out.println("inside save : category service");
		return categoryDao.save(c);
	}

	@Override
	public boolean existsBycategoryId(int id) {

		return categoryDao.deleteByCategoryId(id);
	}
	
	@Override
	public boolean existsBycategoryName(String name) {

		return categoryDao.existsBycategoryName(name);
	}

	@Override
	public boolean deleteByCategoryId(int id) {

		if(categoryDao.existsBycategoryId(id)) {
			categoryDao.deleteByCategoryId(id);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteByCategoryName(String name) {

		if(categoryDao.existsBycategoryName(name)) {
			categoryDao.deleteByCategoryName(name);
			return true;
		}
		
		return false;
	}
	
	@Override
	public Category saveWithImage(Category category, MultipartFile categoryImage) {

		String fileName = storageService.store(categoryImage);
		category.setCategoryImage(fileName);
		return categoryDao.save(category);
	}

}
