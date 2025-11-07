package com.ait.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "post")
public class PostEntity {
	@Id
	@GeneratedValue
	private int id;
	private String username;
    //private String handle;
    private LocalDateTime time;
    private String content;
    //private String imageUrl;
    private int commentCount;
    private int likeCount;
    
    //private int retweets;
  
}
