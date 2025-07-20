package com.alt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alt.util.Flipkart;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		System.out.println("run .get bean method we are going to call");
		Flipkart flipkart = run.getBean(Flipkart.class);
		System.out.println("flipkart bean we have recived and now going to call sendCourier");
		 flipkart.sendCourier(1001, "hyderabad","EKART");
	}

}
