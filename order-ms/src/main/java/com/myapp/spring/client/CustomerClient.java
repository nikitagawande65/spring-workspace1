package com.myapp.spring.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CUSTOMER-MS")// Or IP Addreess
public interface CustomerClient {
	
	@GetMapping("/customers")
	List<Customer> findAll();
	
	@GetMapping("customers/{id}")
	Customer findById(@PathVariable("id")String id);
	
	@GetMapping("/customers/find/{firstName}")
	List<Customer> findAllByFirstName(@PathVariable("fisrtName")String firstName);

}
