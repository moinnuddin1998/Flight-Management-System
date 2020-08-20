package com.capg.fms.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FmsAirportMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(FmsAirportMs2Application.class, args);
		System.out.println("Application running successfully");
	}

}
