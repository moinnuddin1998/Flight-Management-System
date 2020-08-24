package com.capg.fms.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD


/****************************************************************************************************************************
- File Name        : FmsPassengerMsApplication.java 
- Author           : Capgemini 
- Creation Date    : 11/08/2020
- Modified Date    : 16/08/2020
****************************************************************************************************************************/

=======
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableAutoConfiguration
@EnableEurekaClient
>>>>>>> branch 'master' of https://github.com/moinnuddin1998/Flight-Management-System.git
@SpringBootApplication

public class FmsPassengerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsPassengerMsApplication.class, args);
	}

}
