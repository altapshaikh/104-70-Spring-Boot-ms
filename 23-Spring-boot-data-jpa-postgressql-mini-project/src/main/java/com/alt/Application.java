package com.alt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alt.component.ProductComponent;
import com.alt.entity.ProductEntity;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
	
		/*
		 * ProductComponent bean = ctx.getBean(ProductComponent.class);
		 * bean.createProduct();
		 * 
		 * ProductEntity selectProductById = bean.selectProductById();
		 * System.out.println(selectProductById);
		 * 
		 * ProductEntity updateProduct = bean.updateProduct();
		 * System.out.println(updateProduct); bean.deleteProductById();
		 * System.out.println("====================all product========================"
		 * ); bean.fetchAllProduct().forEach(data->{ System.out.println(data); });
		 */
	}

}
