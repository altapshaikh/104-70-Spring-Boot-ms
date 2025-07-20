package com.alt.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.alt.service.RBI;

public class HDfC implements RBI {
public HDfC() {
	System.out.println("HDfC::0-param constrtcor");
}
	
	@Override
	public void calculateIntrest(int principle, int time,int intrestRate) {
		  intrestRate=(int) (intrestRate+0.5);
		double simpleIntrest=(principle*time*intrestRate)/100;
              System.out.println("HDFC INTREST: "+simpleIntrest);
	}

}
