package com.cg.fms;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;

import com.cg.fms.service.BookingService;
import com.cg.fms.service.BookingServiceImpl;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * @author nitesh
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class BookingApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingApplication.class);
	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		logger.info("Starting Application.");
		SpringApplication.run(BookingApplication.class, args);
		logger.info("Application Running.");
	}
	
	@Bean
	public BookingService getBookingService() {
		return new BookingServiceImpl();
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.fms"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Booking Flight API", 
				"This API can be used for booking flights", 
				"1.0", 
				"", 
				new springfox.documentation.service.Contact("Team 2 Batch 1", "URl", "ks@b.com"), 
				"API licence", 
				"www.fms.com",
				Collections.emptyList());
	}
	
}
