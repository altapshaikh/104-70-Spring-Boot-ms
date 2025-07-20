package com.alt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alt.service.PrintMsg;
import com.alt.service.WishGeneratorService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		WishGeneratorService wishGeneratorBean = run.getBean(WishGeneratorService.class);
		PrintMsg printMsgBean = run.getBean(PrintMsg.class);
		wishGeneratorBean.wishGenerator();
		printMsgBean.PrintMsg();
	}

}
