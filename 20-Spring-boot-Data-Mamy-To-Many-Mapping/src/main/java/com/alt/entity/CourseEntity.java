package com.alt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude ="students" )
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	
	@ManyToMany(mappedBy = "course",fetch = FetchType.EAGER)
	private Set<StudentEntity>students=new HashSet<>();
	
	

}
