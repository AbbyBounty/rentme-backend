package com.leasepe.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leasepe.daos.ProductItemDao;
import com.leasepe.entities.Product;
import com.leasepe.utils.StorageService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductItemDao productDao;
	
	@Autowired
	private StorageService storageService;
	
	@Override
	public Product findByProductId(int id) {
		return productDao.findByProductId(id);
	}

	@Override
	public Product findByProductName(String name) {
		return productDao.findByProductName(name);
	}

	@Override
	public boolean deleteByProductId(int id) {
		if(productDao.existsByProductId(id)) {
			productDao.deleteByProductId(id);
			return true;
		}
		return false;
			
	}

	@Override
	public boolean deleteByProductName(String name) {
		if(productDao.existsByProductName(name)) {
			productDao.deleteByProductName(name);
			return true;
		}
		return false;
	}

	

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Product save(Product p ) {
		return productDao.save(p);
	}
	
	

	@Override
	public boolean existsByProductName(String name) {
		return productDao.existsByProductName(name);
	}

	@Override
	public boolean existsByProductId(int id) {
		return productDao.existsByProductId(id);
	}

	@Override
	public Product saveWithImage(Product product, MultipartFile productImage) {
		String fileName = storageService.store(productImage);
		
		
		
		product.setProductImage(fileName);
		product.setCategory(product.getCategory());
		product.setSeller(product.getSeller());
		
		
		System.out.println(product.getCategory()+"--------------------");
		System.out.println(product.getSeller()+"---------------------------- ");
		System.out.println("product with seller :" + product);
		return productDao.save(product);
	}


}

