package com.alt.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class MyBean implements InitializingBean, DisposableBean {

	public MyBean() {
		System.out.println("2: MyBean::0-param constrctor.....................!!!");
	}

	@PostConstruct
	public void postConstrct() {
		System.out.println("4:@PostConstruct: initialization logic");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("5: afterPropertiesSet(): from InitializingBean");

	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("8:@PreDestroy: cleanup before bean is destroy");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("9:destroy(): from DisposableBean");

	}
}
