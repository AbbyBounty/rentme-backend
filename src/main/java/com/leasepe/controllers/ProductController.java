package com.leasepe.controllers;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leasepe.custom_exception.ProductHandlingException;
import com.leasepe.daos.ProductItemDao;
import com.leasepe.daos.SellerDao;
import com.leasepe.dtos.ProductImageDto;
import com.leasepe.dtos.ProductItemDto;
import com.leasepe.entities.Category;
import com.leasepe.entities.Product;
import com.leasepe.entities.Seller;
import com.leasepe.services.CategoryService;
import com.leasepe.services.ProductService;

@CrossOrigin
@RequestMapping("/products")
//@RequestMapping("/api")
@RestController      
public class ProductController {    
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductItemDao productDao;
	
	@Autowired
	private SellerDao sellerDao;
	

	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findProductById(@PathVariable("id")int  id) {
		//logger.error("inside product controller");   
		
		logger.trace("Product controller : findProductById method Accessed");
		Product product = productService.findByProductId(id);
		  
		if(product==null) {
			logger.error(" product with given ID is not exists ");
			throw new ProductHandlingException("product with given ID is not exists");
		}
			
		
		ProductItemDto productItemDto = ProductItemDto.fromEntity(product);
		
		return ResponseEntity.ok(productItemDto);
	}
	

	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findProductByNameMultiple(@PathVariable("name")String  name) {
		
		logger.trace("Product controller : findProductByNameMultiple method Accessed");
		List<ProductItemDto> productNameList= new ArrayList<>();
		
		List<Product> product =productDao.findAllByProductName(name); 
		System.out.println(product);
		
		if(product.isEmpty()) {
			logger.error(" products with given name are not exists ");
			throw new ProductHandlingException("products with given name are not exists ");
		}
		
		for (Product product2 : product) {
			ProductItemDto productItemDto = ProductItemDto.fromEntity(product2);
			productNameList.add(productItemDto);
		}
	
		return ResponseEntity.ok(productNameList);
	}

	
	
	@GetMapping("")
	public ResponseEntity<?> findAllProducts() {
		
		logger.trace("Product controller : findAllProducts method Accessed");
		List<ProductItemDto> productNameList= new ArrayList<>();
		List<Product> productList = productService.findAll();
		
		if(productList.isEmpty()) {
			logger.error(" product list is empty ");
			throw new ProductHandlingException(" product list is empty");
		}
		
		System.out.println(productList);
		for (Product product : productList) {
			ProductItemDto productItemDto = ProductItemDto.fromEntity(product);
			productNameList.add(productItemDto);
		}
		
		return ResponseEntity.ok(productNameList);
	}
	
	@PostMapping("/id/{categoryId}")
	public ResponseEntity<?> saveProduct(@RequestBody Product p , @PathVariable("categoryId") int categoryId) {
		
		logger.trace("Product controller : saveProductByCategoryId method Accessed");
		Category category = categoryService.findByCategoryId(categoryId);
		if(category==null) {
			logger.error(" category with given ID is not exists ");
			throw new ProductHandlingException("category with given ID is not exists");
		}
		
		p.setCategory(category);
		Product newProduct = productService.save(p);
		ProductItemDto productItemDto = ProductItemDto.fromEntity(newProduct);
		return ResponseEntity.ok(productItemDto);
	}
	
	@PostMapping("/name/{categoryName}")    
	public ResponseEntity<?> saveProduct(@RequestBody Product p , @PathVariable("categoryName") String categoryName) {
		
		logger.trace("Product controller : saveProductByCategoryName method Accessed");
		Category category = categoryService.findByCategoryName(categoryName);
		
		if(category==null) {
			logger.error(" category with given name is not exists ");
			throw new ProductHandlingException("category with given name is not exists");
		}
		p.setCategory(category);
		Product newProduct = productService.save(p);
		ProductItemDto productItemDto = ProductItemDto.fromEntity(newProduct);
		return ResponseEntity.ok(productItemDto);
	}
	
	@PostMapping("image")
	public ResponseEntity<?> save(ProductImageDto productDto){
		
		logger.trace("Product controller : saveProductWithImage method Accessed");
		System.out.println("product/ image before : "+ productDto);
		int id = productDto.getSellerId();
		Seller seller2 = sellerDao.findById(id).orElse(null);
		
		if(seller2==null) {
			logger.error(" seller with given id is not exists ");
			throw new ProductHandlingException("seller with given id is not exists");
		}
		
		Product product = ProductImageDto.toEntity(productDto);
		product.setSeller(seller2);
		product=productService.saveWithImage(product, productDto.getProductImage());
		System.out.println("product/ image after : "+ product);
		return ResponseEntity.ok(product);
	}
	
	
	

	
	@PutMapping("/id/{id}")
	public ResponseEntity<?> updateProductById(@RequestBody Product p, @PathVariable("id") int id ) {
		
		logger.trace("Product controller : updateProductById method Accessed");
		p.setProductId(id);
		Product originalProduct = productService.findByProductId(id);
	
		Category category = originalProduct.getCategory();
	
		
		Product product = productService.save(p);
		product.setCategory(category);
		Product newProduct = productService.save(product);
		System.out.println("newProduct:"+ newProduct);
		ProductItemDto productItemDto = ProductItemDto.fromEntity(newProduct);
		return ResponseEntity.ok(productItemDto);
	}
	


	@DeleteMapping("/id/{id}")
	public void deleteProductById(@PathVariable("id") int id) {
		
		logger.trace("Product controller : deleteProductById method Accessed");
	productDao.deleteById(id);
	}
	
	

	
	@DeleteMapping("/name/{name}")
	public void deleteProductByName(@PathVariable("name") String name) {
		
		logger.trace("Product controller : deleteProductByName method Accessed");
		List<Product> product = productDao.findAllByProductName(name);
		for (Product product2 : product) {
			int id = product2.getProductId();
			productDao.deleteById(id);
		}
		
		
	}
} 



