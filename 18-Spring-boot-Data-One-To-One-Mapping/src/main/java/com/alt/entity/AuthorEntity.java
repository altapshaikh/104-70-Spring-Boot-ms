package com.alt.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class AuthorEntity {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	List<BookEntity>books=new ArrayList<>();
}
