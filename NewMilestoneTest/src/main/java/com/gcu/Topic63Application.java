package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.gcu" })
@SpringBootApplication
public class Topic63Application {

	public static void main(String[] args) {
		SpringApplication.run(Topic63Application.class, args);
	}

}
