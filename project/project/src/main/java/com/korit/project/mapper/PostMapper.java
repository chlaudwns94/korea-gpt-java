package com.korit.project.mapper;

import com.korit.project.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    int insert(Post post);

    List<Post> selectAll();

}
