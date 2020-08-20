package com.capg.fms.microservice.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FmsFlightMicroserviceApplication { 

	public static void main(String[] args) {
		SpringApplication.run(FmsFlightMicroserviceApplication.class, args);
		
	}
		
}
