package com.myapp.spring;
import grails.gorm.annotation.Entity
import grails.mongodb.MongoEntity
@Entity
class Customer implements MongoEntity<Customer>{

String id;

String firstName;

String lastName;

String city;


String email;

static mapping={
id generator:'assigned'
}
}