package com.alt;

import java.awt.BufferCapabilities.FlipContents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alt.util.Flipkart;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
	
	//take a bean of target
		Flipkart flipkartBean = run.getBean(Flipkart.class);
		
		flipkartBean.sendCourier(1001, "mumbai");
		flipkartBean.sendCourier1(1001, "mumbai");
	
	}

}
