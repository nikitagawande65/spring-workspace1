package com.myapp.spring.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.doman.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, Long>{

	//String remove(Long id);

	List<Item> findById();

	

	


	
	

}
