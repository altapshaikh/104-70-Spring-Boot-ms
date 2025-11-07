package com.ait.service;

import java.util.List;

import com.ait.bean.PostBean;
import com.ait.bean.PostWithSentimentDTO;
import com.ait.model.PostEntity;

public interface PostService {
public List<PostEntity> createPost(PostBean bean) throws Exception;
public List<PostWithSentimentDTO> getPost(String username);
public int incrementLikeCount(int postId);
public boolean deletePostById(int id);
}
