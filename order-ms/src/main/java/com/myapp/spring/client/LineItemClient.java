package com.myapp.spring.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CATALOG-MS")// Or IP Addreess
public interface LineItemClient {
	
	@GetMapping("/items")
	List<LineItem> findAll();
	
	@GetMapping("items/{id}")
	Customer findById(@PathVariable("id")long id);
	
//	@GetMapping("/customers/find/{firstName}")
//	List<Customer> findAllByFirstName(@PathVariable("fisrtName")String firstName);

}
