package com.alt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.ProductEntity;

@Repository
public interface ProductRepostiory extends CrudRepository<ProductEntity, String> {

}
