package com.alt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.ProfileEntity;
@Repository
public interface ProfileReposiotry extends CrudRepository<ProfileEntity, Long> {

}
