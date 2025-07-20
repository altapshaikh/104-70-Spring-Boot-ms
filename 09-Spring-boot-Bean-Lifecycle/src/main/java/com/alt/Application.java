package com.alt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("1: starting spring boot application....");
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		System.out.println("7: starting spring boot application....");
		run.close();
	}

}
