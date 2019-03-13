package com.myapp.spring.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long>{

	//List<Product> findByName(String name);

	List<Product> findByName(String name);
	List<Product> findByPrice(double price);
	List<Product> findByNameIsOrPriceEquals(String name,double price);
}
