package com.ait.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "ipl", groupId = "my-group")
	public void listen(String msg) {
		//Business logic from this method
		System.out.println(msg);
	}
	
	
	@KafkaListener(topics = "order-events", groupId = "order")
	public void order(String msg) {
		//Business logic from this method
		System.out.println("KafkaConsumerService.order()");
		System.out.println(msg);
	}
	
	@KafkaListener(topics = "payment-events", groupId = "payment")
	public void payment(String msg) {
		//Business logic from this method
		System.out.println("KafkaConsumerService.payment()");
		System.out.println(msg);
	}
	@KafkaListener(topics = "notification-events", groupId = "notification")
	public void notification(String msg) {
		//Business logic from this method
		System.out.println("KafkaConsumerService.notification()");
		System.out.println(msg);
	}
}
