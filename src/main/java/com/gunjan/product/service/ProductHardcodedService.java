package com.gunjan.product.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunjan.product.Repository.ProductRepo;
import com.gunjan.product.model.Product;

@Service
public class ProductHardcodedService {
	 
	 @Autowired
	 private ProductRepo productRepo;
	 
	 public List<Product> getAll(){
		 return productRepo.findAll();
	 }
	 
	 public Product save(Product product){
		 return productRepo.insert(product);
	 }
	 
	 public List<Product> priceGreaterThanMentioned( double Price){
		 return productRepo.findByPriceGreaterThanEqual(Price);
		}

	 public List<Product> filterBasedOnAvailability(){
		 return productRepo.findByAvailabilityIsFalse();
		}
	 
	 
	 public Product update(Product product) {		 
		 return productRepo.save(product); 
	 }
	 
	 public List<Product> searchCategory(String ListOfCategory){ 
		 return productRepo.findByCategoryRegex(ListOfCategory);
	 }

//	  searchByWord
	public List<Product> searchWord(String title) {
		return productRepo.findByNameRegex(title);
	}

	public List<Product> sortByPrice(){
		
		return productRepo.findByOrderByPriceAsc();
	}
	public Product deleteById(String id) {
		Product product = productRepo.findByProductId(id);
		productRepo.delete(product);
		return product;
	}
	 
	

}
