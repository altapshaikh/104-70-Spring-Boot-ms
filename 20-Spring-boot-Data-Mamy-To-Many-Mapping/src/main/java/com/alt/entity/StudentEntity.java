package com.alt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "student")

@ToString(exclude ="course" )
public class StudentEntity {
  @Id
  @GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="student_course",
	   joinColumns = @JoinColumn(name="student_id"),
	   inverseJoinColumns = @JoinColumn(name="course_id")
	   )
	private Set<CourseEntity>course=new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseEntity> getCourse() {
		return course;
	}

	public void setCourse(Set<CourseEntity> course) {
		this.course = course;
	}

}
