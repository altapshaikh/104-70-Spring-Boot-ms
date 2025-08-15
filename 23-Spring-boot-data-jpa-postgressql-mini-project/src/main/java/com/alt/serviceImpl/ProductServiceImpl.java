package com.alt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alt.entity.ProductEntity;
import com.alt.repo.ProductRepostiory;
import com.alt.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
       @Autowired
	private ProductRepostiory productRepository;
	
	
	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		ProductEntity savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		ProductEntity updatedProduct =productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public void deleteProduct(String id) {
		productRepository.deleteById(id);
	}

	@Override
	public ProductEntity fetchProductById(String id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		return product.get();
	}

	@Override
	public List<ProductEntity> fetchAllProduct() {
		List<ProductEntity> allProduct = (List<ProductEntity>) productRepository.findAll();
		return allProduct;
	}

}
