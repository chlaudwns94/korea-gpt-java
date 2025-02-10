package com.korit.project.mapper;

import com.korit.project.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);
    User selectById(int userId);

}
