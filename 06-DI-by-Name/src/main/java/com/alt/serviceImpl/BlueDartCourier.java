package com.alt.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.alt.service.Courier;

@Service
public class BlueDartCourier implements Courier {

	public BlueDartCourier() {
		System.out.println("BlueDart::0-param constrctor");
	}
	@Override
	public void delivery(int orderId, String address) {
		System.out.println("order id: "+orderId+" deliverd on this location: "
                +address+" though courier partner is: BlueDart ");

	}

}
