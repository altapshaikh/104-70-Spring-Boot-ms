package com.alt.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.alt.service.Courier;
@Service

public class DtdcCourier implements Courier {
	
public DtdcCourier() {
	System.out.println("DTDC::0-param constrctor");
}
	@Override
	public void delivery(int orderId, String address) {
		System.out.println("order id: "+orderId+" deliverd on this location: "
	                                +address+" though courier partner is: DTDC ");

	}

}
