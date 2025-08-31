package com.alt.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alt.entity.ProductEntity;

public interface ProductReposiotry  extends JpaRepository<ProductEntity, Long>{

}
