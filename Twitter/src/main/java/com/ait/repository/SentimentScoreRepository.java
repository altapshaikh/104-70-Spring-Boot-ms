package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ait.model.SentimentScoreEntity;

public interface SentimentScoreRepository extends CrudRepository<SentimentScoreEntity, Integer> {
	@Query("SELECT s FROM SentimentScoreEntity s WHERE s.userName = :username ORDER BY s.time DESC")
	List<SentimentScoreEntity> findScoresByUser(@Param("username") String username);

}
