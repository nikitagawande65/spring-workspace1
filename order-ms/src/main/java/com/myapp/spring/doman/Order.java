package com.myapp.spring.doman;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.myapp.spring.client.Customer;
import com.myapp.spring.client.LineItem;

@Document
public class Order {
	
	@Id
	private long id;
	private Date orderDate;
	private double orderValue;
	
	private Customer customer;
	
	private List<LineItem> lineItems;
	

	public Customer getCustomer() {
		return customer;
	}


	public List<LineItem> getLineItems() {
		return lineItems;
	}


	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(long id, Date orderDate, double orderValue) {
		this.id = id;
		this.orderDate = orderDate;
		this.orderValue = orderValue;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

}
