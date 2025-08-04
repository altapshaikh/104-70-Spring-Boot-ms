package com.alt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
