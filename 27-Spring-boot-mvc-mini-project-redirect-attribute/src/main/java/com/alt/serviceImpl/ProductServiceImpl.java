package com.alt.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.alt.dto.ProductDTO;
import com.alt.entity.ProductEntity;
import com.alt.reposiotry.ProductReposiotry;
import com.alt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
@Autowired
	private ProductReposiotry productRepository;
	
	@Override
	public ProductDTO registerProduct(ProductDTO product) {
		
		return registerOrUpdateProduct(product);
	}

	public ProductDTO registerOrUpdateProduct(ProductDTO product) {
		ProductEntity entity=new ProductEntity();
		BeanUtils.copyProperties(product, entity);
		ProductEntity save = productRepository.save(entity);
		BeanUtils.copyProperties(save, product);
		return product;
	}
	
	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		return registerOrUpdateProduct(product);
	}

	
	@Override
	public ProductDTO fetchProductById(long id) {
		ProductDTO dto=new ProductDTO();
		Optional<ProductEntity> product = productRepository.findById(id);
		if(product.isPresent()) {
		BeanUtils.copyProperties(product.get(), dto);
		}
		return dto;	
	}

	@Override
	public List<ProductDTO> fetchAllProduct() {
		List<ProductDTO>products=new ArrayList<>();
		List<ProductEntity> allProduct = productRepository.findAll();
		
		allProduct.forEach(data->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(data, dto);
			products.add(dto);
		});
		
		return products;
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
		
	}

	

}
