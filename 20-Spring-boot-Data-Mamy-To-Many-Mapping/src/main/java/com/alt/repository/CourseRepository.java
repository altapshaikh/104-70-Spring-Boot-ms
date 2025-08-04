package com.alt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alt.entity.CourseEntity;


public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
