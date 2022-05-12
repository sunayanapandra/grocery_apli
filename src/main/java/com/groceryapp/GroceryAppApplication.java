package com.groceryapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroceryAppApplication {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	

	public static void main(String[] args) {
		SpringApplication.run(GroceryAppApplication.class, args);
		System.out.println("success..");
	//	log.info("hai");
	}

}