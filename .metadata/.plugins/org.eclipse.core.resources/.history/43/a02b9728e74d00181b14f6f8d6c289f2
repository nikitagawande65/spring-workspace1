package com.myapp.spring.rest.api;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.myapp.spring.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.myapp.spring.dao.FlightRepository;

@RestController
class FlightRestAPI
{

	@Autowired
	FlightRepository repository;
 
 	@GetMapping("/flights")
 	List<Flight> findAll()
 	
 	{
 	return repository.findAll();
 
 	}

}