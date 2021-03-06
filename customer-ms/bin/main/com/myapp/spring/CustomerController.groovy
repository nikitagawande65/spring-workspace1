package com.myapp.spring;

import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import grails.gorm.transactions.Transactional;



@RestController
@CompileStatic
class CustomerController {

@Autowired
CustomerService customerService

@RequestMapping("/customers")
@ReadOnly
List<Customer> customers() {
Customer.list()
}


@RequestMapping(value="/customers",method=RequestMethod.POST)
String save(@RequestBody Customer customers)
{
customers.save()
}
@RequestMapping("/customers/{id}")
@ReadOnly
Customer customers(@PathVariable("id")String id){
Customer.get(id);
}
@RequestMapping("/customers/find/{name}")
@ReadOnly
List<Customer> customerByName(@PathVariable("name")String name){
customerService.findByFirstName(name)
}

}   