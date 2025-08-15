package com.alt.component;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alt.entity.ProductEntity;
import com.alt.service.ProductService;

@Component
public class ProductComponent {
	
	
      @Autowired
	private ProductService productService;
	
	//save the product
	
      public ProductEntity createProduct() {
    	  ProductEntity saveProduct =null;
    	  for(int i=0;i<10;i++) {
    		  ProductEntity entity=new ProductEntity();
        	  entity.setProductName("POCO_"+i);
        	  entity.setModel(" C-75");
        	  entity.setPrize("7699");
        	  entity.setWarrnty(1);
        	  entity.setMfd(LocalDate.now());
        	  
        	   saveProduct = productService.saveProduct(entity);
    	  }
    	 
    	  return saveProduct;
      }
      
   
      
	
}
