

package com.myapp.spring;

import grails.gorm.services.Service
import java.util.List


@Service(Customer)
interface CustomerService{
List<Customer> findByFirstName(String firstName)

}