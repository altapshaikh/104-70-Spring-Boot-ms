package com.alt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alt.service.BlueDartService;
import com.alt.service.DTDCService;

import jakarta.inject.Inject;

@Component
public class Flipkart {

	

	//@Autowired
//	@Inject
	private BlueDartService blueDartService;
	//@Autowired
	//@Inject
	private DTDCService dTDCService;
	
	public Flipkart() {
		System.out.println("Flipkart:0-param");
	}
	@Autowired
	public Flipkart(BlueDartService blueDartService, DTDCService dTDCService) {
		System.out.println("Flipkart:: parameterized");
		this.blueDartService = blueDartService;
		this.dTDCService = dTDCService;
	}
//	@Autowired
	
	 /* public Flipkart(BlueDartService blueDartService) {
	 * System.out.println("Flipkart: constrctor...................");
	 * this.blueDartService = blueDartService; }
	 */

	       //setter injection
			/*
			 * @Autowired public void setBlueDartService(BlueDartService blueDartService) {
			 * this.blueDartService=blueDartService; }
			 */
	
	public void sendCourier(int orderId,String address,String courierPartner) {
		System.out.println("Flipkart.sendCourier()");
		if(courierPartner.equalsIgnoreCase("BLUEDART")) {
			blueDartService.delivery(orderId, address);
		}else {
			dTDCService.delivery(orderId, address);
		}
		
	}
}
