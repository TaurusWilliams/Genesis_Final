package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.gcu" })
@SpringBootApplication
public class Milestone {

	public static void main(String[] args) {
		SpringApplication.run(Milestone.class, args);
	}

}
