package com.korit.project.service;

import com.korit.project.dto.request.ReqAddPostDto;
import com.korit.project.entity.Post;
import com.korit.project.exception.CustomDuplicateKeyException;
import com.korit.project.repository.PostRepository;
import com.korit.project.repository.UserRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post addPost(ReqAddPostDto reqAddPostDto) {
        Post savePost = postRepository.save(reqAddPostDto.toPost())
                .orElseThrow(() -> new CustomDuplicateKeyException("", Map.of("title", "이미 사용중인 게시글 이름입니다.")));
    return savePost;
    }

    public List<Post> getAllPosts() throws NotFoundException {
        return postRepository.findAll()
                .orElseThrow( ()-> new NotFoundException("게시글 정보가 존재하지않습니다"));
    }

}
