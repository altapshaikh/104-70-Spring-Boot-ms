package com.alt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alt.entity.StudentEntity;

@Repository
public interface StudentReposiotry extends JpaRepository<StudentEntity, Integer> {
	
	public StudentEntity findByName(String name);
	
	public StudentEntity  findByNameAndContactNo(String name,long contactno);
	
	public StudentEntity  findByNameAndStream(String name,String stream);
	
	public StudentEntity  findByNameAndStreamAndContactNo(String name,
			String stream,long contactNo);

}
