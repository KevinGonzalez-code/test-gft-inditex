package com.gft.test.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gft.test.inditex")
public class InditexPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InditexPricesApplication.class, args);
	}

}
