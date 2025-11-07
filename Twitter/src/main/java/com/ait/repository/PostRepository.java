package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ait.model.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {
	@Query("SELECT p FROM PostEntity p WHERE p.username = :username ORDER BY p.time DESC")
	List<PostEntity> findPostsByUser(@Param("username") String username);

}
