package com.alt.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.alt.dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	//fetch list of Movie
	
	WebClient webclient;
	
	public ProductService(WebClient webclient) {
		this.webclient = webclient;
	}

	
	
	public Flux<ProductDTO>getAllProduct(){
		Flux<ProductDTO> bodyToFlux = webclient.get()
		                      .uri("list_product")
		                      .retrieve()
		                      .bodyToFlux(ProductDTO.class);
		return bodyToFlux;
	}
	
	public Mono<ProductDTO>getProductById(Long id){
		Mono<ProductDTO> bodyToFlux = webclient.get()
		                      .uri("/edit/{id}",id)
		                      .retrieve()
		                      .bodyToMono(ProductDTO.class);
		return bodyToFlux;
	}
	
	
	public Mono<ProductDTO>createProduct(ProductDTO dto){
		Mono<ProductDTO> bodyToFlux = webclient.post()
		                      .uri("/register")
		                      .bodyValue(dto)
		                      .retrieve()
		                      .bodyToMono(ProductDTO.class);
		return bodyToFlux;
	}



	public Mono<ProductDTO> updateProduct(ProductDTO dto) {
		Mono<ProductDTO> mono = webclient.post()
                .uri("/update")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ProductDTO.class);
		
		
		System.out.println("welcome...........................................");
		
		Mono<ProductDTO> bodyToFlux = webclient.post()
                .uri("/register")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ProductDTO.class);
		
		System.out.println("welcome...........................................");
		
		
		return mono;
	}
	
	

}
