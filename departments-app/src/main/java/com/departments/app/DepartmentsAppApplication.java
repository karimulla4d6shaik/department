package com.departments.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentsAppApplication.class, args);
	}

}
