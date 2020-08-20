package com.capg.fms.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class FmsPassengerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsPassengerMsApplication.class, args);
	}

}
