package com.alt.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator  implements IdentifierGenerator{
private static final String PREFIX="product_";
private static long Counter=1000L;
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		return PREFIX+(Counter++);
	}

}
