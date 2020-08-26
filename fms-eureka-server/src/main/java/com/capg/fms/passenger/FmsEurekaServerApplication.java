package com.capg.fms.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsEurekaServerApplication.class, args);
	}

}