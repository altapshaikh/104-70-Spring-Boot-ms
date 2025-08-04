package com.alt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alt.entity.StudentEntity;

public interface StudentReposiotry extends JpaRepository<StudentEntity, Long> {


}
