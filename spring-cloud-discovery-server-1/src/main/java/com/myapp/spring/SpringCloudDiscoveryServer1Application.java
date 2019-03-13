package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudDiscoveryServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDiscoveryServer1Application.class, args);
	}
}
