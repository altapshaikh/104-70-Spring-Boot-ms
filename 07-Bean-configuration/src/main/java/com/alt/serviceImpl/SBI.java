package com.alt.serviceImpl;

import org.springframework.stereotype.Service;

import com.alt.service.RBI;


public class SBI implements RBI {
	
	public SBI() {
		System.out.println("SBI::0-param constrtcor");
	}
	@Override
	public void calculateIntrest(int principle, int time, int intrestRate) {
		double simpleIntrest=(principle*time*intrestRate)/100;
        System.out.println("SBI INTREST: "+simpleIntrest);

	}

}
