package com.alt.componet;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import com.alt.entity.CourseEntity;
import com.alt.entity.StudentEntity;
import com.alt.repository.StudentReposiotry;

@Component
public class TestCompoent {
@Autowired
	StudentReposiotry srepo;


public void fetchAllStudent() {
	List<StudentEntity> all = srepo.findAll();
	
}
}
