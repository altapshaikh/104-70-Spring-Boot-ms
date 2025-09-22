package com.alt.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	private final RestClient restClient;
	
	public ProductServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		
		ProductDTO[] body = restClient.get()
		                           .uri("list_product")
		                           .header("Accept", "application/xml")
		                           .retrieve()
		                           .body(ProductDTO[].class);
		
		List<ProductDTO> asList = Arrays.asList(body);
		return asList;
	}

	@Override
	public ProductDTO getProductById(long id) {
		ProductDTO body = restClient.get()
		.uri("/edit/{id}", id)
		.retrieve()
		.body(ProductDTO.class);
		return body;
	}

	@Override
	public ProductDTO registerProduct(ProductDTO product) {
		ProductDTO body = restClient.post()
		.uri("/register")
		.body(product)
		.retrieve()
		.body(ProductDTO.class);
		return body;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		ProductDTO body = restClient.post()
				.uri("/update")
				.body(product)
				.retrieve()
				.body(ProductDTO.class);
				return body;
	}

	@Override
	public String deleteProduct(Long id) {
		String body = restClient.get()
		.uri("/delete/{id}", id)
		.retrieve()
		.body(String.class);
		
		return body;
	}
	
	
	

}
