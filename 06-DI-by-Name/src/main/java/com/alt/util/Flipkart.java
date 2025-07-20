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
	
	  @Autowired
	  @Qualifier("blueDartCourier")
	   private Courier blueDartCourier;

	
	  @Autowired
	  @Qualifier("dtdcCourier")
	   private Courier dtdcCourier;
	/*
	 * @Autowired public void setCourier(@Qualifier("dtdcCourier") Courier courier)
	 * { this.courier = courier; }
	 */


	public void sendCourier(int orderId,String address) {
		blueDartCourier.delivery(orderId, address);
	}
	public void sendCourier1(int orderId,String address) {
		dtdcCourier.delivery(orderId, address);
	}
	
}
