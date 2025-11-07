package com.ait.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SentimentScore")
@Data
public class SentimentScoreEntity {
	@Id
	@GeneratedValue
	private int id;
	private int postId;
	private String userName;
	private String sentiment;
	private float positive;
	private float negative;
	private float neutral;
	private float mixed;
	private LocalDateTime time; 
}
