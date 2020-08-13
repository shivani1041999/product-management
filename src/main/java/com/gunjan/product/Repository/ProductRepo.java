package com.gunjan.product.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.gunjan.product.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product, String>{
	
	Product findByProductId(String productId);
	List<Product> findByPriceGreaterThanEqual(double minPrice);
	List<Product> findByAvailabilityIsFalse();
	List<Product> findByCategoryRegex(String category);
//	 @Query("{'category': ?#{[0]} }")
//	List<Product> findByQueryWithExpression(String param0);
	List<Product> findByNameContaining(String title);
	List<Product> findByNameRegex(String title);
	List<Product> findByNameLike(String title);
	List<Product> findByOrderByPriceAsc();
	
	
//	@Query(value = "{category: ?0}")
//	List<Product> findByCategory(HashSet<String> Category);
	//QueryDslPredicateExecutor<Product>

//	
//	 @Query(value = "{address.city:?0}")
//	    List<Hotel> findByCity(String city);

}
