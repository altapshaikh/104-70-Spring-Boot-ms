package com.alt.service;

import org.springframework.stereotype.Service;

//dependent object
@Service
public class BlueDartService {

	public BlueDartService() {
		System.out.println("BlueDartService.BlueDartService()");
	}
	//deliver method to send courier
	public void delivery(int orderId,String address) {
		System.out.println("BlueDartService.delivery()");
		System.out.println("order id: "+orderId+" delivered sucessfully and address is"+address);
	}
}
