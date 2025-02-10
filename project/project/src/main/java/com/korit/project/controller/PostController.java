package com.korit.project.controller;

import com.korit.project.dto.request.ReqAddPostDto;
import com.korit.project.dto.request.ReqAddUserDto;
import com.korit.project.dto.response.common.SuccessResponseDto;
import com.korit.project.entity.Post;
import com.korit.project.entity.User;
import com.korit.project.service.PostService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/api/post")
    public ResponseEntity<SuccessResponseDto<Post>> addUser(@Valid @RequestBody ReqAddPostDto reqAddPostDto) {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.addPost(reqAddPostDto)));
    }

    @GetMapping("/api/posts")
    public ResponseEntity<SuccessResponseDto<List<Post>>> getAllPosts() throws NotFoundException {
        return ResponseEntity.ok().body(new SuccessResponseDto<>(postService.getAllPosts()));
    }
}
