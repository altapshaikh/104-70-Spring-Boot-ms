package com.ait.bean;

import com.ait.model.PostEntity;
import com.ait.model.SentimentScoreEntity;

import lombok.Data;

@Data
public class PostWithSentimentDTO {
	 private PostEntity post;
	    private SentimentScoreEntity sentiment;
}
