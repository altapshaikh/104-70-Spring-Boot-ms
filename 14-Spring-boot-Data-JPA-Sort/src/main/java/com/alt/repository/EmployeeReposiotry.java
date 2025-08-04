package com.alt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.EmployeeEntity;


@Repository
public interface EmployeeReposiotry extends JpaRepository<EmployeeEntity, Integer> {
	
	

}
