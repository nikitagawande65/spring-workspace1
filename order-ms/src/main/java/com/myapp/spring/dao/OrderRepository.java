package com.myapp.spring.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.doman.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long>{

	//String remove(Long id);

	List<Order> findById();

	

	


	
	

}
