package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.client.Customer;
import com.myapp.spring.client.CustomerClient;
import com.myapp.spring.client.LineItem;
import com.myapp.spring.client.LineItemClient;
import com.myapp.spring.dao.OrderRepository;

import com.myapp.spring.doman.Order;


@RestController
public class OrderAPI {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerClient customerClient;
	
	@Autowired
	private LineItemClient lineItemClient;
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> loadAll(){
		return new ResponseEntity<List<Order>>
		(orderRepository.findAll(),HttpStatus.OK);
		
	}
	@PostMapping("/orders")
	public ResponseEntity<String> addNew(@RequestBody Order order){
		orderRepository.save(order);
		return new ResponseEntity<String>("Order Added",HttpStatus.CREATED);
		
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> findOrder(@PathVariable("id")long id){
		return new ResponseEntity<Order>
		(orderRepository.findById(id).get(),HttpStatus.OK);
		
	}
	
	
	
	@PutMapping(value="/orders/{id}")
	public ResponseEntity<String> update(@PathVariable("id")long id , @RequestBody Order order) {
		// TODO Auto-generated method stub
		//Order oldOrder =orderRepository.searchById(id);
		BeanUtils.copyProperties(order, orderRepository.findById(id).get());
		orderRepository.save(order);
		return new ResponseEntity<String>("order updated",HttpStatus.CREATED);
		}
	
	 @DeleteMapping("/orders/{id}")
	    public ResponseEntity<String> deleteOrder(
	            @PathVariable("id")long id) {orderRepository.deleteById(id);
	       return new ResponseEntity<String>("OrderDeleted",
	                HttpStatus.OK);
	    }
	
	@GetMapping("/orders/findByCustomerId/{customerid}/{orderid}")
	public Order getByCustomerId(@PathVariable("customerid")String customerid,
			@PathVariable("orderid")Long orderid) {
		Customer customer=customerClient.findById(customerid);
		Order order=orderRepository.findById(orderid).get();
		List<LineItem> lineItems=lineItemClient.findAll();
		order.setLineItems(lineItems);
		order.setCustomer(customer);
		return order;
	}

}
