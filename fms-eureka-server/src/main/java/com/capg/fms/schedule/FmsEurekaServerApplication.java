package com.capg.fms.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsEurekaServerApplication.class, args);
	}

}
