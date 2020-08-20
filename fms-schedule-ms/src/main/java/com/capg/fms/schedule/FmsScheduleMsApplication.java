package com.capg.fms.schedule;

import org.hibernate.annotations.Loader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class FmsScheduleMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsScheduleMsApplication.class, args);
	}

	@Bean
	
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}

}
