package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {

    int insert(Post post);
    Post selectById(@Param("postId") int PostId);

    List<Post> selectAllByKeywordContaining(
            @Param("startIndex") int startIndex,
            @Param("limitCount") int limitCount,
            @Param("keyword") String keyword);
}
