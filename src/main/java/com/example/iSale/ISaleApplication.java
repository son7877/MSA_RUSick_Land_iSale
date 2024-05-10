package com.example.iSale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ISaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ISaleApplication.class, args);
	}

}
