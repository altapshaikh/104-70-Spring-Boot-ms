package com.ait.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.service.PostService;

@RestController
public class LikeController {

    @Autowired
    private PostService postService;

    @PostMapping("/like/{postId}")
    public ResponseEntity<Map<String, Object>> likePost(@PathVariable int postId) {
        int updatedLikeCount = postService.incrementLikeCount(postId);

        Map<String, Object> response = new HashMap<>();
        response.put("likeCount", updatedLikeCount);

        return ResponseEntity.ok(response);
    }
}

