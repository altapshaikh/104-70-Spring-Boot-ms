package com.ait.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ait.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password")
	Optional<UserEntity> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	Optional<UserEntity> findByEmail(@Param("email") String email);

}
