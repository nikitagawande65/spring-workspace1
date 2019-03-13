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


import com.myapp.spring.dao.ItemRepository;

import com.myapp.spring.doman.Item;


@RestController
public class ItemAPI {
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> loadAll(){
		return new ResponseEntity<List<Item>>
		(itemRepository.findAll(),HttpStatus.OK);
		
	}
	@PostMapping("/items")
	public ResponseEntity<String> addNew(@RequestBody Item item){
		itemRepository.save(item);
		return new ResponseEntity<String>("item Added",HttpStatus.CREATED);
		
	}
	

	@GetMapping("/items/{id}")
	public ResponseEntity<Item> finditem(@PathVariable("id")long id){
		return new ResponseEntity<Item>
		(itemRepository.findById(id).get(),HttpStatus.OK);
		
	}
	
	
	
	@PutMapping(value="/items/{id}")
	public ResponseEntity<String> update(@PathVariable("id")long id , @RequestBody Item item) {
		// TODO Auto-generated method stub
		//item olditem =itemRepository.searchById(id);
		BeanUtils.copyProperties(item, itemRepository.findById(id).get());
		itemRepository.save(item);
		return new ResponseEntity<String>("item updated",HttpStatus.CREATED);
		}
	
	 @DeleteMapping("/items/{id}")
	    public ResponseEntity<String> deleteitem(
	            @PathVariable("id")long id) {itemRepository.deleteById(id);
	       return new ResponseEntity<String>("itemDeleted",
	                HttpStatus.OK);
	    }
	
	

}
