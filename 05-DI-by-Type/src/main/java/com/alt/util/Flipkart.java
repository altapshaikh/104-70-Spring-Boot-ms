package com.alt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alt.service.Courier;

@Component
public class Flipkart {
	
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier("dtdcCourier") private Courier courier;
	 * 
	 * 
	 * 
	 * 
	 * public Flipkart(@Qualifier("bluedartCourier") Courier courier) { this.courier
	 * = courier; }
	 */
	private Courier courier;

@Autowired
	public void setCourier(@Qualifier("bluedartCourier") Courier courier) {
		this.courier = courier;
	}


	public void sendCourier(int orderId,String address) {
		courier.delivery(orderId, address);
	}
	
}
