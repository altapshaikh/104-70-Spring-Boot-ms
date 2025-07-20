package com.alt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alt.serviceImpl.HDfC;
import com.alt.serviceImpl.SBI;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		/*
		 * InterestCalculator intrestBean = run.getBean(InterestCalculator.class);
		 * intrestBean.calculateIntrest(100000, 2); InterestCalculator intrestBean1 =
		 * run.getBean(InterestCalculator.class);
		 * System.out.println(intrestBean.hashCode());
		 * System.out.println(intrestBean1.hashCode());
		 */
		
		HDfC HDFCbean = run.getBean(HDfC.class);
		HDfC HDFCbean1 = run.getBean(HDfC.class);
		 HDFCbean.calculateIntrest(100000, 2, 8);
		 System.out.println("THIS ISSINGELTON INSTANCE : "+(HDFCbean ==HDFCbean1));
		 SBI bean1 = run.getBean(SBI.class);
		 SBI bean2 = run.getBean(SBI.class);
		 SBI bean3 = run.getBean(SBI.class);
		 System.out.println("THIS ISSINGELTON INSTANCE : "+(bean1 ==bean3));
		 
		
		 
	}

}
