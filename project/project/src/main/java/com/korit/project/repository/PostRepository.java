package com.korit.project.repository;

import com.korit.project.entity.Post;
import com.korit.project.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    private PostMapper postMapper;


    public Optional<Post> save(Post post) {
        try {
            postMapper.insert(post);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(post);
    }

    public Optional<List<Post>> findAll() {
        List<Post> foundPosts = postMapper.selectAll();
        return foundPosts.isEmpty() ? Optional.empty() : Optional.of(foundPosts);
    }

}
