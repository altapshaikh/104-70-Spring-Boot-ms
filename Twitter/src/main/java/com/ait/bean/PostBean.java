package com.ait.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostBean {
	private int id;
	private String username;
    //private String handle;
    private LocalDateTime time;
    private String content;
    //private String imageUrl;
    //private int commentCount;
    //private int retweets;
    private int likeCount;
}
