package com.alt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

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
		ProductEntity entity=new ProductEntity();
		
		BeanUtils.copyProperties(product, entity);
		
		ProductEntity save = productRepository.save(entity);
		
		BeanUtils.copyProperties(save, product);
		return product;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO fetchProductById(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public void deleteProduct() {
		// TODO Auto-generated method stub
		
	}

	

}
