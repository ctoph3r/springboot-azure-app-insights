package com.poc.insights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class InsightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsightsApplication.class, args);
	}

}
