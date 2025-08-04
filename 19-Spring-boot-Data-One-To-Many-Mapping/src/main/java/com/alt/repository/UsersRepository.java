package com.alt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.UserEntity;
@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

}
