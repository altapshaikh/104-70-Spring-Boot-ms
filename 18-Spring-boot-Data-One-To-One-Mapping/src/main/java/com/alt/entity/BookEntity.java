package com.alt.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class BookEntity {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private AuthorEntity author;

}
