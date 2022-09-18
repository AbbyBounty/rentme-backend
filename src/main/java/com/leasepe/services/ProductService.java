package com.leasepe.services;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.leasepe.entities.Product;


public interface ProductService {

	Product findByProductId(int id);
	Product findByProductName(String name);
	List<Product> findAll();
	
	boolean existsByProductId(int id);
	boolean existsByProductName(String name);
	
	boolean deleteByProductId(int id);
	boolean deleteByProductName(String name);

	Product save(Product p);
	Product saveWithImage(Product product, MultipartFile productImage);
	
	

}


