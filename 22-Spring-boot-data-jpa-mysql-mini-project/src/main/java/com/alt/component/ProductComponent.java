package com.alt.component;

import java.time.LocalDate;
import java.util.List;

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
    	  ProductEntity entity=new ProductEntity();
    	  entity.setProductName("POCO");
    	  entity.setModel(" C-75");
    	  entity.setPrize("7699");
    	  entity.setWarrnty(1);
    	  entity.setMfd(LocalDate.now());
    	  
    	  ProductEntity saveProduct = productService.saveProduct(entity);
    	  return saveProduct;
      }
      
      public ProductEntity selectProductById() {
    	  ProductEntity fetchProductById = productService.fetchProductById(1l);
    	  return fetchProductById;
      }
      
      public ProductEntity updateProduct() {
    	  ProductEntity entity=new ProductEntity();
    	  entity.setId(52l);
    	  entity.setProductName("POCO-new");
    	  entity.setModel(" C-75");
    	  entity.setPrize("7699");
    	  entity.setWarrnty(1);
    	  entity.setMfd(LocalDate.now());
    	  ProductEntity saveProduct = productService.saveProduct(entity);
    	  return saveProduct;
      }
      
      public void deleteProductById() {
    //	  productService.deleteProduct(152l);
      }
      
      public List<ProductEntity>fetchAllProduct() {
    	  List<ProductEntity> fetchAllProduct = productService.fetchAllProduct();
    	  return fetchAllProduct;
      }
      
	
}
