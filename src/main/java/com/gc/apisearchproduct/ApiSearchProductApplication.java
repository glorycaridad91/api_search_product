package com.gc.apisearchproduct;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
			@Info(
					title = "Search Products API",
					version = "1.0",
					description = "Product search in an online store"))
public class ApiSearchProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSearchProductApplication.class, args);
	}

}
