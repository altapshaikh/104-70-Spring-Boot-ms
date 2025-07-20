package com.alt.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resources;

@Service
public class DTDCService {

	public DTDCService() {
		System.out.println("DTDCService::0-param constrctor..................");
	}

	// deliver method to send courier
	public void delivery(int orderId, String address) {
		System.out.println("DTDCService.delivery()");
		System.out.println("order id: " + orderId + " delivered sucessfully and address is" + address);
	}
}
