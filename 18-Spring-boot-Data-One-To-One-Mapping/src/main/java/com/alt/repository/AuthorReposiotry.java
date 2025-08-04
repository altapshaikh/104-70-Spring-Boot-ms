package com.alt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.AuthorEntity;

@Repository
public interface AuthorReposiotry extends CrudRepository<AuthorEntity, Long> {

}
